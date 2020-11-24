package week05d02;

public class ChangeLetter {

    public String changeVowels(String word) {
        String vowels = "aeiou";
        String finished = "";
        int[] vowelPlace = new int[word.length()];
        for (int i = 0; i < word.length(); i++) {
            for (int j = 0; i < vowels.length(); j++) {
                if (word.charAt(i) == (vowels.charAt(j))) ;
                vowelPlace[i] = vowels.charAt(j);
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
