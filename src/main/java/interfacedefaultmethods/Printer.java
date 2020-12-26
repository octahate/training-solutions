package interfacedefaultmethods;

public class Printer {

    public String print(Printable document) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < document.getLength(); i++) {
            if (!"#000000".equals(document.getColor(i))) {
                sb.append("[" + document.getColor(i) + "]");
            }
            sb.append(document.getPage(i)).append("\n");
        }
        return sb.toString();
    }
}

