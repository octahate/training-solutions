package matura.y20s2;

public class SeriesEntry {

    private String date;
    private String name;
    private int season;
    private int episode;
    private int length;
    private boolean isWatched;

    public SeriesEntry(String date, String name, int season, int episode, int length, boolean isWatched) {
        this.date = date;
        this.name = name;
        this.season = season;
        this.episode = episode;
        this.length = length;
        this.isWatched = isWatched;
    }

    public String getDate() {
        return date;
    }

    public String getName() {
        return name;
    }

    public int getSeason() {
        return season;
    }

    public int getEpisode() {
        return episode;
    }

    public int getLength() {
        return length;
    }

    public boolean isWatched() {
        return isWatched;
    }

    @Override
    public String toString() {
        return "SeriesEntry{" +
                "date='" + date + '\'' +
                ", name='" + name + '\'' +
                ", season=" + season +
                ", episode=" + episode +
                ", length=" + length +
                ", isWatched=" + isWatched +
                '}';
    }
}
