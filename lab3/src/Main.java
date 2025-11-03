import java.util.*;


/* Варіант:
С11 = 6: Визначити клас спортивний інвентар, який складається як мінімум з 5-и полів. */
public class Main {
    public static void main(String[] args) {

        // Масив об'єктів SportsEquipment
        SportsEquipment[] items = {
                new SportsEquipment("М'яч", "Командний спорт", 0.45, 25.99, 2021),
                new SportsEquipment("Ракетка", "Теніс", 0.33, 89.49, 2022),
                new SportsEquipment("Коврик", "Йога", 1.5, 20.0, 2020),
                new SportsEquipment("Шолом", "Велоспорт", 0.55, 60.00, 2023),
                new SportsEquipment("Ковзани", "Хокей", 2.8, 120.00, 2019)
        };

        // Сортування за назвою (зростання)
        Arrays.sort(items, Comparator.comparing(SportsEquipment::getName));
        System.out.println("Сортування за назвою (зростання):");
        for (SportsEquipment item : items) System.out.print(item + " ");

        // Сортування за ціною (спадання)
        Arrays.sort(items, Comparator.comparingDouble(SportsEquipment::getPrice).reversed());
        System.out.println("\nСортування за ціною (спадання):");
        for (SportsEquipment item : items) System.out.print(item.getName() + " - " + item.getPrice() + " ");

        // Пошук об'єкта, який ідентичний заданому
        System.out.println("\nПошук об'єкту, який ідентичний заданому: ");

        SportsEquipment target = new SportsEquipment("Шолом", "Велоспорт", 0.55, 60.00, 2023);

        boolean exists = false;
        int foundIndex = 0;

        for (int i = 0; i < items.length; i++) {
            if (items[i].equals(target)) {
                exists = true;
                foundIndex = i;
                break;
            }
        }

        if (exists) {
            System.out.println("Знайдено елемент: " + items[foundIndex] + "[" + foundIndex + "]");
        } else {
            System.out.println("Ідентичного об’єкта не знайдено.");
        }
    }
}