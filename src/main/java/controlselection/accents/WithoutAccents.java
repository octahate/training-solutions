package controlselection.accents;

public class WithoutAccents {
    public final String ACCENTS = "áéíóöőúüűÁÉÍÓÖŐÚÜŰ";
    public final String NOACCENTS = "aeiooouuuAEIOOOUUU";

    public char convertToCharWithoutAccents (char letter) {
        if (ACCENTS.indexOf(letter) >= 0){
            return NOACCENTS.charAt(ACCENTS.indexOf(letter));
        } else return letter;
    }
}
