/**
 * Клас, що представляє окрему літеру слова..
 */
public class Letter {
    private char value;
    /**
     * Конструктор класу Letter.
     *
     * @param value символ, який представляє літеру.
     */
    public Letter(char value) {
        this.value = value;
    }
    /**
     * Отримує значення літери.
     *
     * @return символ літери.
     */
    public char getValue() {
        return value;
    }
    /**
     * Порівнює цю літеру з іншою без урахування регістру.
     * @param letter інший об'єкт Letter для порівняння.
     * @return true, якщо літери однакові (ігноруючи регістр), інакше false.
     */
    public boolean equalsIgnoreCase(Letter letter) {
        char firstLetter = Character.toLowerCase(this.value);
        char secondLetter = Character.toLowerCase(letter.value);
        return firstLetter == secondLetter;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
