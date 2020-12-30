package catalog;

import java.util.ArrayList;
import java.util.List;

public class AudioFeatures implements Feature {
    private List<String> composer;
    private int length;
    private List<String> performers;
    private String title;

    public AudioFeatures(String title, int length, List<String> composer) {
        this.composer = composer;
        this.length = length;
        this.title = title;
    }

    public AudioFeatures(String title, int length, List<String> composer, List<String> performers) {
        this.composer = composer;
        this.length = length;
        this.performers = performers;
        this.title = title;
    }

    @Override
    public List<String> getContributors() {
        List<String> together = new ArrayList<>();
        together.addAll(composer);
        together.addAll(performers);
        return together;
    }

    @Override
    public String getTitle() {
        return title;
    }

    public int getLength() {
        return length;
    }
}