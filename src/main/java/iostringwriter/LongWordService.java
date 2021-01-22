package iostringwriter;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.List;

public class LongWordService {

    private void writeWithWriter(Writer writer, List<String> longWords) {

        PrintWriter pw = new PrintWriter(writer);
        for (String word : longWords) {
            pw.print(word);
            pw.print(":");
            pw.print(word.length());
        }

    }

    public String writeWithStringWriter(List<String> longWords){
        StringWriter sw = new StringWriter();
        writeWithWriter(sw,longWords);
        return sw.toString();
    }
}
