package catalog;

import java.util.List;

public class PrintedFeatures implements Feature {

    private List<String> authors;
    private int numberOfPages;
    private String title;

    public PrintedFeatures(String title, int numberOfPages, List<String> authors) {
        if (numberOfPages <= 0){
            throw new IllegalStateException("Pages must be more than 0!");
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
