package week03d04;

import java.util.Objects;

public class Phone {

    private String prefix;
    private String number;

    public Phone(String prefix, String number) {
        this.prefix = prefix;
        this.number = number;
    }

    public String getPrefix() {
        return prefix;
    }

    public String getNumber() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Phone phone = (Phone) o;
        return Objects.equals(prefix, phone.prefix) && Objects.equals(number, phone.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(prefix, number);
    }
}
