import java.util.ArrayList;
import java.util.List;
/**
 * Клас, що представляє текст.
 * Текст складається зі списку речень.
 */
public class Text {
    private List<Sentence> sentences;
    /**
     * Конструктор тексту.
     * Виконує заміну послідовностей пробілів/табуляцій на один пробіл та розбиває текст на речення.
     *
     * @param text вхідний текст у форматі StringBuilder.
     */
    public Text(StringBuilder text) {
        sentences = new ArrayList<>();
        String cleanedString = text.toString().replaceAll("\\s+", " ").trim();
        StringBuilder cleanedText = new StringBuilder(cleanedString);
        StringBuilder currentSentence = new StringBuilder();
        for (int i = 0; i < cleanedText.length(); i++) {
            char c = cleanedText.charAt(i);
            currentSentence.append(c);
            if (c == '.' || c == '!' || c == '?') {
                Sentence sentence = new Sentence(currentSentence);
                sentences.add(sentence);
                currentSentence.setLength(0);
            }
        }

        if (!currentSentence.isEmpty()) {
            sentences.add(new Sentence(new StringBuilder(currentSentence.toString().trim())));
        }
    }
    /**
     * Отримує список речень.
     *
     * @return список об'єктів Sentence.
     */
    public List<Sentence> getSentences() {
        return sentences;
    }
    /**
     * Отримує всі слова з усіх речень тексту в єдиний список.
     * Використовується для подальшого сортування слів.
     *
     * @return список всіх об'єктів Word у тексті.
     */
    public List<Word> getAllWords() {
        List<Word> allWords = new ArrayList<>();
        for (Sentence sentence : sentences) {
            for (SentenceElement element : sentence.getSentenceElements()) {
                if (element instanceof Word) {
                    allWords.add((Word) element);
                }
            }
        }
        return allWords;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Sentence sentence : sentences) {
            result.append(sentence).append(" ");
        }
        return result.toString().trim();
    }
}
