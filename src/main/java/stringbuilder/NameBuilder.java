package stringbuilder;

public class NameBuilder {

/*    private String middleName;
    private String familyName;
    private String givenName;
    private Title title;

    public NameBuilder(String familyName, String givenName) {
        this.familyName = familyName;
        this.givenName = givenName;
    }

    public NameBuilder(String familyName, String middleName, String givenName) {
        if (familyName == null || familyName.isEmpty() == true) {
            throw new IllegalArgumentException("Family name can't be empty!");
        }
        if (givenName == null || givenName.isEmpty() == true) {
            throw new IllegalArgumentException("Given name can't be empty!");
        }
        this.middleName = middleName;
        this.familyName = familyName;
        this.givenName = givenName;
    }

    public NameBuilder(Title title, String familyName, String middleName, String givenName) {
        if (familyName == null || familyName.isEmpty() == true) {
            throw new IllegalArgumentException("Family name can't be empty!");
        }
        if (givenName == null || givenName.isEmpty() == true) {
            throw new IllegalArgumentException("Given name can't be empty!");
        }
        this.middleName = middleName;
        this.familyName = familyName;
        this.givenName = givenName;
        this.title = title;

    }*/

    private boolean isEmpty(String text){
        return text.isBlank();
    }


    public String concatNameWesternStyle(String familyName, String middleName, String givenName, Title title) {
        if(middleName.isEmpty() || familyName.isEmpty()){
            throw new IllegalArgumentException("This can't be left blank!");
        }
        StringBuilder sb = new StringBuilder();
        sb.append(title + " ");
        sb.append(givenName + " ");
        sb.append(middleName + " ");
        sb.append(familyName + " ");
        return sb.toString();
    }
    public static String concatNameHungarianStyle(String familyName, String middleName, String givenName, Title title) {
        if(middleName.isEmpty() || familyName.isEmpty()){
            throw new IllegalArgumentException("This can't be left blank!");
        }
        StringBuilder sb = new StringBuilder();
        sb.append(title + " ");
        sb.append(familyName + " ");
        sb.append(middleName + " ");
        sb.append(givenName + " ");
        return sb.toString();
    }

    public static String insertTitle (String name, Title title, String where){
        int place = name.indexOf(where);
        StringBuilder sb = new StringBuilder();
        sb.append(name.substring(0,place));
        sb.append(title);
        sb.append(name.substring (place + title.toString().length()));
        return sb.toString();
    }

    public static String deleteNamePart(String name, String delete){
        StringBuilder sb = new StringBuilder();
        int start = name.indexOf(delete);
        sb.append(name);
        sb.delete(start, (start+delete.length()+1));
        return sb.toString();
    }

}
