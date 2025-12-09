/**
 * Виключення, що використовується для обробки
 * помилок, пов'язаних з логікою роботи музичної бібліотеки.
 */
public class MusicException extends Exception {
    public MusicException(String message) {
        super(message);
    }
}
