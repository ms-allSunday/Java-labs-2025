/**
 * Клас, що представляє розділовий знак у реченні.
 */
public class Punctuation implements SentenceElement {
    private char punctuationMark;
    /**
     * Конструктор класу Punctuation.
     *
     * @param punctuationMark символ розділового знаку.
     */
    public Punctuation(char punctuationMark) {
        this.punctuationMark = punctuationMark;
    }
    /**
     * Отримує символ розділового знаку.
     *
     * @return символ знаку.
     */
    public char getPunctuationMark() {
        return punctuationMark;
    }

    @Override
    public String toString() {
        return String.valueOf(punctuationMark);
    }
}
