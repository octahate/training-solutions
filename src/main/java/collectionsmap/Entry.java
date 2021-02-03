package collectionsmap;

import java.time.LocalDate;

public class Entry {

    private String ip;
    private LocalDate LocalDate;
    private String credential;

    public Entry(String ip, LocalDate loginDate, String credential) {
        this.ip = ip;
        this.LocalDate = loginDate;
        this.credential = credential;
    }

    public String getIp() {
        return ip;
    }

    public java.time.LocalDate getLocalDate() {
        return LocalDate;
    }

    public String getCredential() {
        return credential;
    }
}
