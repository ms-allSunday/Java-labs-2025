/**
 * Клас, що описує класичну музичну композицію.
 * Успадковується від {@link MusicalComposition}.
 */
public class Classical extends MusicalComposition {
    /**
     * Конструктор для створення класичної композиції.
     * Автоматично встановлює стиль "Classical".
     *
     * @param title           назва композиції.
     * @param artist          композитор або виконавець.
     * @param durationSeconds тривалість у секундах.
     * @throws MusicException якщо тривалість некоректна.
     */
    public Classical(String title, String artist, int durationSeconds) throws MusicException {
        super(title, artist, durationSeconds, "Classical");
    }
}