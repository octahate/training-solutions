package catalog;

public final class SearchCriteria {

    String contributor;
    String title;

    public SearchCriteria(String contributor, String title) {
        this.contributor = contributor;
        this.title = title;
    }

    public static SearchCriteria createByBoth(String title, String contributor) {
        if (title == null || contributor == null){
            throw new IllegalArgumentException("Filelds can't be empty");
        }
        Validators.isBlank(title);
        Validators.isBlank(contributor);
        return new SearchCriteria(contributor, title);
    }

    public static SearchCriteria createByContributor(String contributor) {
        if (contributor == null){
            throw new IllegalArgumentException("Filelds can't be empty");
        }
        Validators.isBlank(contributor);
        return new SearchCriteria(contributor, null);
    }

    public static SearchCriteria createByTitle(String title) {
        if (title == null){
            throw new IllegalArgumentException("Filelds can't be empty");
        }
        Validators.isBlank(title);
        return new SearchCriteria(null, title);
    }

    public boolean hasContributor() {
        if (contributor != null) {
            return true;
        }
        return false;
    }

    public boolean hasTitle() {
        if (title != null) {
            return true;
        }
        return false;
    }

    public String getContributor() {
        return contributor;
    }

    public String getTitle() {
        return title;
    }
}
