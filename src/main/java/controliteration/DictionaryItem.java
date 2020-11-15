package controliteration;

import java.util.List;

public class DictionaryItem {
    private String word;
    private List<String> translations;

    public DictionaryItem(String word, List<String> translations) {
        this.word = word;
        this.translations = translations;
    }

    public String getWord() {
        return word;
    }

    public List<String> getTranslations() {
        return translations;
    }

    public void addTranslations(List<String> translations) {
        for (int i = 0; i< translations.size(); i++){
            if (this.translations.contains(translations.get(i))) {
            } else {
                this.translations.add(translations.get(i));
            }
        }
    }
}
