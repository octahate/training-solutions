package interfacedefaultmethods.print;

import java.util.ArrayList;
import java.util.List;

public class StoryBook implements Printable{

    private List<ColoredPage> pages = new ArrayList<>();

    public void addPage(String text, String color){
        pages.add(new ColoredPage(text,color));
    }

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

