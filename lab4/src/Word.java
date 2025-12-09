import java.util.ArrayList;
import java.util.List;
/**
 * Клас, що представляє слово.
 * Слово складається зі списку літер.
 */
public class Word implements SentenceElement {
    private List<Letter> letters;
    /**
     * Конструктор, який створює слово з StringBuilder.
     *
     * @param wordString текст слова у форматі StringBuilder.
     */
    public Word (StringBuilder wordString) {
        letters = new ArrayList<>();
        for (int i = 0; i < wordString.length(); i++) {
            char c = wordString.charAt(i);
            letters.add(new Letter(c));
        }
    }
    /**
     * Отримує список літер слова.
     *
     * @return список об'єктів Letter.
     */
    public List<Letter> getLetters() {
        return letters;
    }
    /**
     * Рахує кількість заданої літери в слові.
     *
     * @param letterToCount об'єкт Letter, кількість якого треба підрахувати.
     * @return кількість входжень літери.
     */
    public int countLetter(Letter letterToCount) {
        int count = 0;
        for (Letter letter : letters) {
            if (letter.equalsIgnoreCase(letterToCount)) {
                count++;
            }
        }
        return count;
    }

    @Override
    public String toString() {
        StringBuilder word = new StringBuilder();
        for (Letter letter : letters) {
            word.append(letter.toString());
        }
        return word.toString();
    }
}
