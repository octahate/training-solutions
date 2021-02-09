package week15d02;

// * Adott egy vetélkedő kérdésbankja egy fájlban. A fálban az egy kérdéshez tartozó adatok két sorban helyezkednek el. Első sorban a kérdés, a második sorban a válasz a pontszám és a téma szóközzel elválasztava.
//   Olvasd be a fájl tartalmát a memóriába, majd oldjátok meg a lenti feladatokat.
//        Mikor volt a mohacsi vesz?
//        1526 1 tortenelem
//        Melyik evben bomlott fel a Nyugat-Romai Birodalom?
//        476 1 tortenelem
//        Melyik a legkisebb primszam?
//        2 1 matematika
//        Mennyi 64 kobgyoke?
//        4 2 matematika
//        Hany atloja van a szabalyos nyolcszognek?
//        24 2 matematika
//        Melyik evben kezdodott a Honfoglalas?
//        895 1 tortenelem
//        Mikor adtak ki az Aranybullat?
//        1222 1 tortenelem
//        Melyik evben adtak ki Angliaban a Magna Chartat?
//        1215 3 tortenelem
//        ```
//        1. Írj egy metódust, melynek paramétere a téma és add vissza, az összes kérdést abban a témában. (Csak a kérdéseket)
//        2. Írj egy metódust, ami random sorsol ki egy kérdést, és adja vissza annak összes adatát.
//        3. Készíts egy metódust ami rendszerezi a kérdéseket témakörönként. Visszatér egy datszerkezetben amelyben témánként megtalálható az összes kérdés.
//        4. Az előző feladat segítségével határozd meg, hogy melyik téma kérdései érik a legtöbb pontot (összpontszám)!**

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class Trivia {

    List<Question> questions = new ArrayList<>();

    public Trivia(Path path) {
        readFromFile(path);
    }

    public void readFromFile(Path path) {

        String[] string = new String[3];

        try (BufferedReader br = Files.newBufferedReader(path)) {
            String line;
            while ((line = br.readLine()) != null) {
                String buffer = br.readLine();
                String answer = buffer.split(" ")[0];
                int score = Integer.parseInt(buffer.split(" ")[1]);
                String type = buffer.split(" ")[2];
                questions.add(new Question(line, answer, score, type));
            }
        } catch (IOException e) {
            throw new IllegalArgumentException("Cannot read line!", e);
        }

    }

    public List<String> getQuestionsBySubject(String type) {
        List<String> result = new ArrayList<>();

        for (Question i : questions) {
            if (i.getqType().equals(type)) {
                result.add(i.getQuestion());
            }
        }
        return result;
    }

    public Question returnRandonQuestion(Random rnd) {
        return questions.get(rnd.nextInt(questions.size()));
    }

    public Map<String, List<String>> getAllQuestionsBySubject() {
        Map<String, List<String>> result = new HashMap();
        for (Question q : questions) {
            if (!result.containsKey(q.getqType())) {
                result.put(q.getqType(), new ArrayList<>());
            }
            result.get(q.getqType()).add(q.getQuestion());
        }
        return result;
    }

    private Map<String, Integer> getScoreBySubject() {
        Map<String, Integer> temp = new HashMap();
        for (Question q : questions) {
            if (!temp.containsKey(q.getqType())) {
                temp.put(q.getqType(), 0);
            }
            temp.put(q.getqType(), temp.get((q.getqType()) + q.getScore()));
        }
        return temp;
    }

    public String getHighScorebySubject() {
        Map<String, Integer> temp2 = getScoreBySubject();
        int max = 0;
        Map.Entry<String, Integer> temp3 = null;
        for (Map.Entry<String, Integer> i : temp2.entrySet()) {
            if (max < i.getValue()) {
                max = i.getValue();
                temp3 = i;
            }
        }
        return temp3.getKey();
    }
}