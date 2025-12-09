import java.util.ArrayList;
import java.util.List;
/*
Варіант:
C2 = 0 List
C3 = 0 Масив із початковою кількістю елементів 15 та збільшенням кількості елементів на 30%
*/
public class Main {
    public static void main(String[] args) throws MusicException {
        System.out.println("ТЕСТ 1: Порожній конструктор + Ріст масиву");

        MusicList list1 = new MusicList();

        System.out.println("Початкова ємність: " + list1.getCapacity());
        System.out.println("Додаємо 16 пісень");
        for (int i = 1; i <= 16; i++) {
            list1.add(new Rock("Track " + i, "Band", 200 + i));
        }
        System.out.println("Кількість елементів: " + list1.size());
        System.out.println("Нова ємність масиву: " + list1.getCapacity());

        System.out.println("\nТЕСТ 2: Конструктор з одним елементом");
        MusicalComposition singleTrack = new Pop("Track", "Artist", 300);
        MusicList list2 = new MusicList(singleTrack);

        System.out.println("Розмір списку 2: " + list2.size());
        System.out.println("Елемент: " + list2.get(0));

        System.out.println("\nТЕСТ 3: Конструктор зі стандартною колекцією");
        List<MusicalComposition> standardList = new ArrayList<>();
        standardList.add(new Classical("Track", "Composer", 400));
        standardList.add(new Rock("Track", "Band", 350));
        standardList.add(new Pop("Track", "Artist", 280));

        MusicList list3 = new MusicList(standardList);

        System.out.println("Розмір списку 3: " + list3.size());
        System.out.println("Вміст списку 3:");

        for (MusicalComposition track : list3) {
            System.out.println(track);
        }
    }
}