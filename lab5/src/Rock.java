/**
 * Клас, що описує музичну композицію в стилі Рок.
 * Успадковується від {@link MusicalComposition}.
 */
public class Rock extends MusicalComposition{
    /**
     * Конструктор для створення рок-композиції.
     * Автоматично встановлює стиль "Rock".
     *
     * @param title           назва пісні.
     * @param artist          виконавець.
     * @param durationSeconds тривалість у секундах.
     * @throws MusicException якщо тривалість некоректна.
     */
    public Rock(String title, String artist, int durationSeconds) throws MusicException {
        super(title, artist, durationSeconds, "Rock");
    }
}
