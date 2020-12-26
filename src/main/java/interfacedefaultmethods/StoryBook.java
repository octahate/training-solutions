package interfacedefaultmethods;

import java.util.List;

public class StoryBook implements Printable{

    private List<ColoredPage> pages;

    @Override
    public int getLength() {
        return pages.size();
    }

    @Override
    public String getPage(int pageNumber) {
        return pages.get(pageNumber).getContent();
    }

    public String getColor(int pageNumber){
        return pages.get(pageNumber).getColor();
    }
}

