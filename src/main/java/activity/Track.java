package activity;

import java.util.ArrayList;
import java.util.List;

public class Track {

    private List<TrackPoint> trackPoints = new ArrayList<>();

    public void addTrackPoint(TrackPoint newTrackPoint) {
        trackPoints.add(newTrackPoint);
    }

    public List<TrackPoint> getTrackPoints() {
        return trackPoints;
    }

    public Coordinate findMaximumCoordinate() {
        double maxLatitude = trackPoints.get(0).getCoordinate().getLatitude();
        double maxLongitude = trackPoints.get(0).getCoordinate().getLongitude();
        for (TrackPoint currentTrackPoint : trackPoints) {
            if (currentTrackPoint.getCoordinate().getLatitude() > maxLatitude) {
                maxLatitude = currentTrackPoint.getCoordinate().getLatitude();
            }
            if (currentTrackPoint.getCoordinate().getLongitude() > maxLongitude) {
                maxLongitude = currentTrackPoint.getCoordinate().getLongitude();
            }
        }
        return new Coordinate(maxLatitude, maxLongitude);
    }

    public Coordinate findMinimumCoordinate() {
        double minLatitude = trackPoints.get(0).getCoordinate().getLatitude();
        double minLongitude = trackPoints.get(0).getCoordinate().getLongitude();
        for (TrackPoint currentTrackPoint : trackPoints) {
            if (currentTrackPoint.getCoordinate().getLatitude() < minLatitude) {
                minLatitude = currentTrackPoint.getCoordinate().getLatitude();
            }
            if (currentTrackPoint.getCoordinate().getLongitude() < minLongitude) {
                minLongitude = currentTrackPoint.getCoordinate().getLongitude();
            }
        }
        return new Coordinate(minLatitude, minLongitude);
    }

    public double getRectangleArea() {
        double a = findMaximumCoordinate().getLatitude() - findMinimumCoordinate().getLatitude();
        double b = findMaximumCoordinate().getLongitude() - findMinimumCoordinate().getLongitude();
        return a * b;
    }

    public double getFullElevation() {
        TrackPoint prevOne = trackPoints.get(0);
        double sumOfIt = 0;
        for (TrackPoint current : trackPoints) {
            if (current.getElevation() > prevOne.getElevation()) {
                sumOfIt += current.getElevation() - prevOne.getElevation();
            }
            prevOne = current;
        }
        return sumOfIt;
    }

    public double getFullDecrease() {
        TrackPoint prevOne = trackPoints.get(0);
        double sumOfIt = 0;
        for (TrackPoint current : trackPoints) {
            if (current.getElevation() < prevOne.getElevation()) {
                sumOfIt += prevOne.getElevation() - current.getElevation();
            }
            prevOne = current;
        }
        return sumOfIt;
    }

    public double getDistance() {
        TrackPoint prevOne = trackPoints.get(0);
        double sumOfDistance = 0;
        for (TrackPoint current : trackPoints) {
            sumOfDistance += prevOne.getDistanceFrom(current);
            prevOne = current;
        }
        return sumOfDistance;
    }
}
