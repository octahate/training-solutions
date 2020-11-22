package controlselection.consonant;

public class ToConsonant {
    public static final String VOWELS = "aeiou";  //inicializálok egy stringet amiben benne vannak a magánhangzók

    public char convertToConsonant(char c) {
        if (VOWELS.indexOf(c) >= 0) {  // ha része visszaadja az előző karaktert
            return (char) (c + 1);
        } else {
            return c;  //egyéb esetben saját magát        }
        }
    }
}