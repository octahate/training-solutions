package week05d02;

public class ChangeLetter {

    public String changeVowels(String word) {
        final String VOWELS = "aeiouAEIOU";
        String finished = "";
        int[] vowelPlace = new int[word.length()];
        for (int i = 0; i < word.length(); i++) {
            for (int j = 0; i < VOWELS.length(); j++) {
                if (word.charAt(i) == (VOWELS.charAt(j))) ;
                vowelPlace[i] = VOWELS.charAt(j);
            }
        }
        for (int k = 0; k < word.length(); k++) {
            for (int l = 0; l < vowelPlace.length; l++) {
                if (k == vowelPlace[l]) {
                    finished = finished + "*";
                } else {
                    finished = finished + word.charAt(k);
                }
            }
        }
        return finished;
    }
}
