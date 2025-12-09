/**
 * Клас, що описує музичну композицію в стилі Поп.
 * Успадковується від {@link MusicalComposition}.
 */
public class Pop extends MusicalComposition {
    /**
     * Конструктор для створення поп-композиції.
     * Автоматично встановлює стиль "Pop".
     *
     * @param title           назва пісні.
     * @param artist          виконавець.
     * @param durationSeconds тривалість у секундах.
     * @throws MusicException якщо тривалість некоректна.
     */
    public Pop(String title, String artist, int durationSeconds) throws MusicException {
        super(title, artist, durationSeconds, "Pop");
    }
}
