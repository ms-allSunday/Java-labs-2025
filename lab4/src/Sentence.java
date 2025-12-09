import java.util.ArrayList;
import java.util.List;
/**
 * Клас, що представляє речення.
 * Речення складається з елементів (слів та розділових знаків).
 */
public class Sentence {
    private List<SentenceElement> sentenceElements;
    /**
     * Конструктор, що розділяє рядок тексту на слова та розділові знаки.
     *
     * @param sentence текст речення у форматі StringBuilder.
     */
    public Sentence(StringBuilder sentence) {
        sentenceElements = new ArrayList<>();

        StringBuilder currentWord = new StringBuilder();
        for (int i = 0; i < sentence.length(); i++) {
            char c = sentence.charAt(i);

            if (Character.isLetterOrDigit(c)) {
                currentWord.append(c);
            } else {
                if (!currentWord.isEmpty()) {
                    sentenceElements.add(new Word(new StringBuilder(currentWord)));
                    currentWord.setLength(0);
                }
                sentenceElements.add(new Punctuation(c));
            }
        }
        if (!currentWord.isEmpty()) {
            sentenceElements.add(new Word(new StringBuilder(currentWord)));
        }
    }
    /**
     * Отримує елементи речення.
     *
     * @return список елементів речення.
     */
    public List<SentenceElement> getSentenceElements() {
        return sentenceElements;
    }

    @Override
    public String toString() {
        StringBuilder text = new StringBuilder();
        for (SentenceElement el : sentenceElements) {
            text.append(el);
        }
        return text.toString();
    }
}
