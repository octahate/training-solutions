package isahasa.htmlmarchaller.isa;

import isahasa.htmlmarchaller.HtmlText;

public class UnderlinedAndItalicAndBold extends HtmlText {
    public UnderlinedAndItalicAndBold(String plainText) {
        super(plainText);
    }
    @Override
    public String getPlainText() {
        String bold = "<u><i><b>" + super.getPlainText() + "</b></i><u/>";
        return bold;
    }

}
