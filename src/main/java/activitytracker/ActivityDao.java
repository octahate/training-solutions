package activitytracker;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import javax.xml.crypto.Data;
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

    public void saveActivity(DataSource ds, Activity currentActivity){
        try (
                Connection cnn = ds.getConnection();
                PreparedStatement smt = cnn.prepareStatement("INSERT INTO `activities` (`startTime`, `activity_desc`, `activity_type`) VALUES (?,?,?)", Statement.RETURN_GENERATED_KEYS);
        ) {
            smt.setTimestamp(1, Timestamp.valueOf(currentActivity.getStartTime()));
            smt.setString(2,currentActivity.getDesc());
            smt.setString(3,currentActivity.getType().toString());
            smt.executeUpdate();

        } catch (SQLException throwables) {
            throw new IllegalStateException("can not insert");
        }
    }

    public Activity findActivityById(DataSource dataSource, long id){
        try (
                Connection conn = dataSource.getConnection();
                PreparedStatement stmt =
                        conn.prepareStatement("select * from employees where id = ?");
        ) {
            stmt.setLong(1, id);
            try (
                    ResultSet rs = stmt.executeQuery();
            ) {
                if (rs.next()) {
                    Activity result = new Activity((int) id,rs.getTimestamp("startTime").toLocalDateTime(),rs.getString("activity_desc"), Type.valueOf(rs.getString("activity_type")));
                }
                throw new IllegalArgumentException("No result");
            } catch (SQLException sqle) {
                throw new IllegalArgumentException("Error by insert", sqle);
            }
        } catch (SQLException sqle) {
            throw new IllegalArgumentException("Error by insert", sqle);
        }
    }

    public List<Activity> listActivites(DataSource dataSource){
        try (
                Connection conn = dataSource.getConnection();
                PreparedStatement stmt =
                        conn.prepareStatement("select * from employees where id = ?");
        ) {
            stmt.setLong(1, id);
            try (
                    ResultSet rs = stmt.executeQuery();
            ) {
                if (rs.next()) {
                    Activity result = new Activity((int) id,rs.getTimestamp("startTime").toLocalDateTime(),rs.getString("activity_desc"), Type.valueOf(rs.getString("activity_type")));
                }
                throw new IllegalArgumentException("No result");
            } catch (SQLException sqle) {
                throw new IllegalArgumentException("Error by insert", sqle);
            }
        } catch (SQLException sqle) {
            throw new IllegalArgumentException("Error by insert", sqle);
        }
    }


}
