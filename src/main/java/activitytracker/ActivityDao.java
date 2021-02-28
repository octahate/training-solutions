package activitytracker;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ActivityDao {

    public DataSource initializeDataSource() {
        MysqlDataSource ds = new MysqlDataSource();
        ds.setUrl("jdbc:mysql://localhost:3306/activitytracker?useUnicode=true");
        ds.setUser("activitytracker");
        ds.setPassword("Q2R4q7");
        return ds;
    }

    public void saveActivity(DataSource ds, Activity currentActivity) {
        makeActivityPart(ds, currentActivity);
        makeTrackPointPart(ds, currentActivity);
    }

    private void makeTrackPointPart(DataSource ds, Activity currentActivity) {
        for (TrackPoint currentTrackPoint : currentActivity.getPoints()) {
            try (
                    Connection cnn = ds.getConnection();
                    PreparedStatement smt = cnn.prepareStatement("INSERT INTO `track_point` (`id`, `time`, `lat`, `lon`) VALUES (?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
            ) {
                smt.setInt(1, currentActivity.getId());
                smt.setTimestamp(2, Timestamp.valueOf(currentActivity.getStartTime()));
                smt.setLong(3, currentTrackPoint.getLat());
                smt.setLong(4, currentTrackPoint.getLon());
                smt.executeUpdate();

            } catch (SQLException throwables) {
                throw new IllegalStateException("can not insert");
            }
        }
    }


    private void makeActivityPart(DataSource ds, Activity currentActivity) {
        try (
                Connection cnn = ds.getConnection();
                PreparedStatement smt = cnn.prepareStatement("INSERT INTO `activities` (`startTime`, `activity_desc`, `activity_type`) VALUES (?,?,?)", Statement.RETURN_GENERATED_KEYS);
        ) {
            smt.setTimestamp(1, Timestamp.valueOf(currentActivity.getStartTime()));
            smt.setString(2, currentActivity.getDesc());
            smt.setString(3, currentActivity.getType().toString());
            currentActivity.setId(smt.getGeneratedKeys().getInt("id"));
            smt.executeUpdate();

        } catch (SQLException throwables) {
            throw new IllegalStateException("can not insert into table: activities");
        }
    }

    public Activity findActivityById(DataSource dataSource, long id) {
        try (
                Connection conn = dataSource.getConnection();
                PreparedStatement stmt =
                        conn.prepareStatement("select * from activities where id = ?");
        ) {
            stmt.setLong(1, id);
            try (
                    ResultSet rs = stmt.executeQuery();
            ) {
                if (rs.next()) {
                    Activity result = new Activity((int) id, rs.getTimestamp("startTime").toLocalDateTime(), rs.getString("activity_desc"), Type.valueOf(rs.getString("activity_type")));
                    result.addAllTrackPoints(returnTrackPoints(dataSource, id));
                    return result;
                }
                throw new IllegalArgumentException("No result");
            } catch (SQLException sqle) {
                throw new IllegalArgumentException("Error by insert", sqle);
            }
        } catch (SQLException sqle) {
            throw new IllegalArgumentException("Error by insert", sqle);
        }
    }

    private List<TrackPoint> returnTrackPoints(DataSource dataSource, long id) {
        List<TrackPoint> result = new ArrayList<>();
        try (
                Connection conn = dataSource.getConnection();
                PreparedStatement stmt =
                        conn.prepareStatement("select * from track_point where id = ?");
        ) {
            stmt.setLong(1, id);
            try (
                    ResultSet rs = stmt.executeQuery();
            ) {
                if (rs.next()) {
                    TrackPoint currentTrackPoint = new TrackPoint((int) id, rs.getTimestamp("time").toLocalDateTime(), rs.getLong("lat"), rs.getLong("lon"));
                    result.add(currentTrackPoint);
                }
                return result;
            } catch (SQLException sqle) {
                throw new IllegalArgumentException("Error by insert", sqle);
            }
        } catch (SQLException sqle) {
            throw new IllegalArgumentException("Error by insert", sqle);
        }
    }

    public List<Activity> listActivites(DataSource dataSource) {

        List<Activity> list = new ArrayList<>();

        try (
                Connection conn = dataSource.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("select * from activities")
        ) {
            while (rs.next()) {
                Activity result = new Activity(rs.getInt("id"), rs.getTimestamp("startTime").toLocalDateTime(), rs.getString("activity_desc"), Type.valueOf(rs.getString("activity_type")));
                list.add(result);
            }
        } catch (SQLException sqle) {
            throw new IllegalArgumentException("Error by insert", sqle);
        }
        return list;
    }


}
