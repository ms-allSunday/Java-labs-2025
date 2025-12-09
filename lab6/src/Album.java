import java.util.ArrayList;
import java.util.List;
/**
 * Клас, що представляє музичний альбом.
 * Містить колекцію композицій та методи для роботи з ними.
 */
public class Album {
    private String name;
    private List<MusicalComposition> tracks;
    /**
     * Конструктор альбому.
     *
     * @param name назва альбому.
     */
    public Album(String name) {
        this.name = name;
        this.tracks = new ArrayList<>();
    }
    /**
     * Додає нову композицію до альбому.
     *
     * @param track об'єкт {@link MusicalComposition} для додавання.
     */
    public void addTrack(MusicalComposition track) {
        tracks.add(track);
    }
    /**
     * Підраховує загальну тривалість всіх треків альбому.
     *
     * @return сумарна тривалість у секундах.
     */
    public int getTotalDuration() {
        int total = 0;
        for (MusicalComposition track : tracks) {
            total += track.getDurationSeconds();
        }
        return total;
    }
    /**
     * Сортує композиції альбому на основі стилю.
     */
    public void sortByStyle() {
        for (int i = 0; i < tracks.size(); i++) {
            for (int j = i + 1; j < tracks.size(); j++) {
                MusicalComposition track1 = tracks.get(i);
                MusicalComposition track2 = tracks.get(j);
                if (track1.getStyle().compareTo(track2.getStyle()) > 0) {
                    tracks.set(i, track2);
                    tracks.set(j, track1);
                }
            }
        }
    }
    /**
     * Знаходить композиції, тривалість яких потрапляє у заданий діапазон.
     *
     * @param minSeconds мінімальна тривалість.
     * @param maxSeconds максимальна тривалість.
     * @return список знайдених композицій.
     * @throws MusicException якщо у заданому діапазоні не знайдено жодної композиції.
     */
    public List<MusicalComposition> findByDurationRange(int minSeconds, int maxSeconds) throws MusicException {
        List<MusicalComposition> result = new ArrayList<>();
        for (MusicalComposition track : tracks) {
            if (track.getDurationSeconds() >= minSeconds && track.getDurationSeconds() <= maxSeconds) {
                result.add(track);
            }
        }
        if (result.isEmpty()) {
            throw new MusicException("Треків тривалістю " + minSeconds + " сек. - " + maxSeconds + " сек. не знайдено");
        }
        return result;
    }
    /**
     * Виводить інформацію про альбом та список всіх треків.
     * Також виводить загальну тривалість альбому.
     */
    public void printAlbum() {
        System.out.println("Альбом: " + name);
        for (MusicalComposition track : tracks) {
            System.out.println(track);
        }
        System.out.println("Загальна тривалість: " + MusicalComposition.getDurationInMinutes(getTotalDuration()));
    }
}
