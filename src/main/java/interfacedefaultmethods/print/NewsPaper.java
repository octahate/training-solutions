package interfacedefaultmethods.print;

import java.util.ArrayList;
import java.util.List;

public class NewsPaper implements Printable {

    private List<String> content = new ArrayList<>();

    public void addPage(String page){
        content.add(page);
    }

    @Override
    public int getLength() {
        return content.size();
    }

    @Override
    public String getPage(int pageNumber) {
        return content.get(pageNumber);
    }
}
