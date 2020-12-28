package isahasa.htmlmarchaller.isa;

import isahasa.htmlmarchaller.HtmlText;

public class UnderlineHtmlText extends HtmlText {
    public UnderlineHtmlText(String plainText) {
        super(plainText);
    }


    @Override
    public String getPlainText() {
        String bold = "<u>" + super.getPlainText() + "</u>";
        return bold;
    }
}
