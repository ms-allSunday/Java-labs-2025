/**
 * Клас SportsEquipment описує спортивний інвентар.
 * Містить поля: назва, вид спорту, вага, ціна та рік виготовлення.
 */
public class SportsEquipment {
    private String name;
    private String sportType;
    private double weight;
    private double price;
    private int yearOfProduction;
    public static void main(String[] args) {
    }
    /**
     * Конструктор створює об'єкт SportsEquipment з усіма полями.
     *
     * @param name              Назва предмета
     * @param sportType         Вид спорту
     * @param weight            Вага у кг
     * @param price             Ціна у доларах
     * @param yearOfProduction  Рік виготовлення
     */
    public SportsEquipment(String name, String sportType, double weight,
                           double price, int yearOfProduction) {
        this.name = name;
        this.sportType = sportType;
        this.weight = weight;
        this.price = price;
        this.yearOfProduction = yearOfProduction;
    }

    // Гетери
    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    /**
     * Перевизначений метод equals для порівняння двох об'єктів SportsEquipment.
     * Два об'єкти вважаються рівними, якщо всі поля однакові.
     *
     * @param obj Об'єкт для порівняння
     * @return true, якщо об'єкти рівні; false інакше
     */
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        SportsEquipment other = (SportsEquipment) obj;
        return name.equals(other.name)
                && sportType.equals(other.sportType)
                && weight == other.weight
                && price == other.price
                && yearOfProduction == other.yearOfProduction;
    }

    /**
     * Перевизначений метод toString для виводу об'єкта.
     *
     * @return Назва предмета
     */
    @Override
    public String toString() {
        return name;
    }
}
