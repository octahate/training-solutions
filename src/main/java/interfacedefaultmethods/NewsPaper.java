package interfacedefaultmethods;

import java.util.List;

public class NewsPaper implements Printable {

    private List<String> content;

    @Override
    public int getLength() {
        return content.size();
    }

    @Override
    public String getPage(int pageNumber) {
        return content.get(pageNumber);
    }
}
