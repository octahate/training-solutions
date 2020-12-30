package catalog;

import java.util.ArrayList;
import java.util.List;

public class AudioFeatures implements Feature {
    private List<String> composer;
    private int length;
    private List<String> performers;
    private String title;

    public AudioFeatures(String title, int length, List<String> performers) {
        if (length <= 0) {
            throw new IllegalArgumentException("Length must be longer than 0!");
        }
        if (Validators.isBlank(title)) {
            throw new IllegalArgumentException("Title can't be empty!");
        }
        this.performers = performers;
        this.length = length;
        this.title = title;
    }

    public AudioFeatures(String title, int length, List<String> composer, List<String> performers) {
        if (length <= 0) {
            throw new IllegalArgumentException("Length must be longer than 0!");
        }
        if (Validators.isBlank(title)) {
            throw new IllegalArgumentException("Title can't be empty!");
        }
        this.composer = composer;
        this.length = length;
        this.performers = performers;
        this.title = title;
    }

    @Override
    public List<String> getContributors() {
        List<String> together = new ArrayList<>();
        together.addAll(performers);
        if (composer != null) {
            together.addAll(composer);
        }
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