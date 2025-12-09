import java.util.List;
/*
Варіант:
C13 = Визначити ієрархію музичних композицій.
Записати на диск альбом. Порахувати тривалість альбому.
Провести перестановку композицій диска на основі приналежності до стилю.
Знайти композицію, що відповідає заданому діапазону довжини треків.
*/
public class Main {
    public static void main(String[] args) throws MusicException {
        Album album = new Album("Greatest Hits");

        MusicalComposition t1 = new Rock("In the End", "Linkin Park", 216);
        MusicalComposition t2 = new Pop("Billie Jean", "Michael Jackson", 294);
        MusicalComposition t3 = new Classical("Four Seasons \"Spring\"", "Vivaldi", 600);
        MusicalComposition t4 = new Rock("Back in Black", "AC/DC", 255);

        album.addTrack(t1);
        album.addTrack(t2);
        album.addTrack(t3);
        album.addTrack(t4);

        System.out.println("Оригінальний спсиок");
        album.printAlbum();

        System.out.println("\nСписок відсортований за стилем");
        album.sortByStyle();
        album.printAlbum();

        System.out.println("\nПошук треків 250 - 300 секунд");
        List<MusicalComposition> found = album.findByDurationRange(250, 300);
        for (MusicalComposition track : found) {
            System.out.println(track);
        }
    }
}