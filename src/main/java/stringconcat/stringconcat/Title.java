package stringconcat.stringconcat;

public enum Title {

    MR("Mr."), MRS("Mrs."), MS("Ms."), DR("Dr.");

    private String meaning;

    Title(String meaning) {
        this.meaning = meaning;
    }

    public String getTitleString() {
        return meaning;
    }
}
