/**
 * Базовий клас, що описує узагальнену музичну композицію.
 */
public class MusicalComposition {
    private String title;
    private String artist;
    private int durationSeconds;
    private String style;
    /**
     * Конструктор для створення музичної композиції.
     *
     * @param title           назва пісні.
     * @param artist          ім'я виконавця або назва гурту.
     * @param durationSeconds тривалість пісні в секундах (має бути > 0).
     * @param style           музичний стиль.
     * @throws MusicException якщо передана тривалість менша або дорівнює нулю.
     */
    public MusicalComposition(String title, String artist, int durationSeconds, String style) throws MusicException {
        if (durationSeconds <= 0) {
            throw new MusicException("Тривалість пісні не може були менше 0: " + title);
        }
        this.title = title;
        this.artist = artist;
        this.durationSeconds = durationSeconds;
        this.style = style;
    }
    /**
     * Отримує тривалість композиції.
     *
     * @return тривалість у секундах.
     */
    public int getDurationSeconds() {
        return durationSeconds;
    }
    /**
     * Отримує стиль композиції.
     *
     * @return рядок з назвою стилю.
     */
    public String getStyle() {
        return style;
    }
    /**
     * Статичний допоміжний метод для форматування часу.
     * Перетворює секунди у формат "хвилини:секунди".
     *
     * @param totalSeconds загальна кількість секунд.
     * @return відформатований рядок часу.
     */
    public static String getDurationInMinutes(int totalSeconds) {
        int minutes = totalSeconds / 60;
        int seconds = totalSeconds % 60;
        String secondsString;
        if (seconds < 10) {
            secondsString = "0" + seconds;
        } else {
            secondsString = String.valueOf(seconds);
        }
        return minutes + ":" + secondsString;
    }
    /**
     * Повертає рядкове представлення об'єкта композиції.
     *
     * @return рядок з інформацією про назву, виконавця, тривалість та стиль.
     */
    @Override
    public String toString() {
        return "Назва: " + title + " | Виконавець: " + artist + " | Тривалість: " + getDurationInMinutes(durationSeconds) + " | Стиль: " + style;
    }
}
