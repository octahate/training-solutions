package week04;

public class NameChanger {
    private String fullname;
    //sajnos még nem jutottam el a StringBuilderig és a kivételkezelésig :(


        public NameChanger(String fullname) {
            if (fullname == null || fullname.isBlank()) {
                throw new IllegalArgumentException("Invalid name: " + fullname);
            }
            this.fullname = fullname.trim();
        }

        public String getFullname() {
            return fullname;
        }

        public void changeFirsName(String firstName) {
            String str = firstName.trim();
            fullname = fullname.replace(fullname.substring(fullname.indexOf(" ") + 1), str);
        }
    }
}
