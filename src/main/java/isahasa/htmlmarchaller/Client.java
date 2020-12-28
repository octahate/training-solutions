package isahasa.htmlmarchaller;

import java.nio.charset.StandardCharsets;

public class Client {

   private Channel channel;

    public Client(Channel channel) {
        this.channel = channel;
    }

    public void writeTo(TextSource text){
       channel.writeByte(text.getPlainText().getBytes(StandardCharsets.UTF_8));
    }
}
