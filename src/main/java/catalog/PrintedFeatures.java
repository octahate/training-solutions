package catalog;

import java.util.List;

public class PrintedFeatures implements Feature {

    private List<String> authors;
    private int numberOfPages;
    private String title;

    public PrintedFeatures(String title, int numberOfPages, List<String> authors) {
        if (numberOfPages <= 0){
            throw new IllegalArgumentException("Pages must be more than 0!");
        }
        if (title.isEmpty()|| title.isBlank() || title.equals(null)){
            throw new IllegalArgumentException("Empty title");
        }
        if (authors == null){
            throw new IllegalArgumentException("No author given!");
        }
        this.authors = authors;
        this.numberOfPages = numberOfPages;
        this.title = title;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    @Override
    public String getTitle() {
        return title;
    }

    public List<String> getContributors() {
        return authors;
    }

}
