import java.util.*;
/**
 * Типізована колекція для зберігання об'єктів {@link MusicalComposition}.
 * Клас реалізує інтерфейс {@link List}.
 */
public class MusicList implements List<MusicalComposition> {
    private MusicalComposition[] tracks;
    private int size;
    private static final int INITIAL_CAPACITY = 15;
    /**
     * Конструктор без параметрів.
     * Ініціалізує порожній список з початковою ємністю 15 елементів.
     */
    public MusicList() {
        this.tracks = new MusicalComposition[INITIAL_CAPACITY];
        this.size = 0;
    }
    /**
     * Конструктор, що створює список з одним початковим елементом.
     *
     * @param track об'єкт {@link MusicalComposition}, який буде додано до списку.
     */
    public MusicList(MusicalComposition track) {
        this();
        add(track);
    }
    /**
     * Конструктор, що створює список на основі іншої колекції.
     *
     * @param collection колекція, елементи якої будуть додані до списку.
     */
    public MusicList(Collection<MusicalComposition> collection) {
        int capacity = Math.max(INITIAL_CAPACITY, collection.size());
        this.tracks = new MusicalComposition[capacity];
        this.size = 0;
        for (MusicalComposition song : collection) {
            this.add(song);
        }
    }
    // --- МЕТОДИ ІНТЕРФЕЙСУ LIST ---

    /**
     * Повертає кількість елементів у списку.
     *
     * @return кількість елементів.
     */
    @Override
    public int size() {
        return size;
    }
    /**
     * Перевіряє, чи порожній список.
     *
     * @return true, якщо список не містить елементів.
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }
    /**
     * Повертає елемент за вказаним індексом.
     *
     * @param index індекс елемента.
     * @return знайдений об'єкт {@link MusicalComposition}.
     * @throws IndexOutOfBoundsException якщо індекс виходить за межі списку.
     */
    @Override
    public MusicalComposition get(int index) {
        checkIndex(index);
        return tracks[index];
    }
    /**
     * Замінює елемент у вказаній позиції.
     *
     * @param index індекс елемента для заміни.
     * @param track новий елемент.
     * @return попередній елемент, що знаходився на цій позиції.
     */
    @Override
    public MusicalComposition set(int index, MusicalComposition track) {
        checkIndex(index);
        MusicalComposition oldValue = tracks[index];
        tracks[index] = track;
        return oldValue;
    }
    /**
     * Додає елемент у кінець списку.
     * Якщо масив заповнений, він розширюється на 30%.
     *
     * @param track елемент для додавання.
     * @return true (згідно з контрактом Collection.add).
     */
    @Override
    public boolean add(MusicalComposition track) {
        ensureCapacity(size + 1);
        tracks[size++] = track;
        return true;
    }
    /**
     * Вставляє елемент у вказану позицію.
     * Елементи праворуч від індексу зміщуються на одну позицію.
     *
     * @param index індекс для вставки.
     * @param track елемент для вставки.
     * @throws IndexOutOfBoundsException якщо індекс некоректний.
     */
    @Override
    public void add(int index, MusicalComposition track) {
        if (index < 0 || index > size) throw new IndexOutOfBoundsException();
        ensureCapacity(size + 1);

        System.arraycopy(tracks, index, tracks, index + 1, size - index);

        tracks[index] = track;
        size++;
    }
    /**
     * Видаляє перше входження вказаного об'єкта зі списку.
     *
     * @param o об'єкт для видалення.
     * @return true, якщо об'єкт було знайдено і видалено.
     */
    @Override
    public boolean remove(Object o) {
        int index = indexOf(o);
        if (index >= 0) {
            remove(index);
            return true;
        }
        return false;
    }
    /**
     * Видаляє елемент за вказаним індексом.
     *
     * @param index індекс елемента.
     * @return видалений елемент.
     */
    @Override
    public MusicalComposition remove(int index) {
        checkIndex(index);
        MusicalComposition oldValue = tracks[index];

        int numMoved = size - index - 1;
        if (numMoved > 0) {
            System.arraycopy(tracks, index + 1, tracks, index, numMoved);
        }
        tracks[--size] = null;
        return oldValue;
    }
    /**
     * Додає всі елементи з колекції у кінець списку.
     *
     * @param c колекція, елементи якої треба додати.
     * @return {@code true}, якщо список змінився в результаті виклику.
     */
    @Override
    public boolean addAll(Collection<? extends MusicalComposition> c) {
        if (c.isEmpty()) return false;
        ensureCapacity(size + c.size());
        for (MusicalComposition item : c) {
            tracks[size++] = item;
        }
        return true;
    }
    /**
     * Вставляє всі елементи з вказаної колекції, починаючи з заданого індексу.
     *
     * @param index індекс, з якого почати вставку.
     * @param c колекція елементів для вставки.
     * @return {@code true}, якщо список змінився.
     */
    @Override
    public boolean addAll(int index, Collection<? extends MusicalComposition> c) {
        boolean modified = false;
        for (MusicalComposition e : c) {
            add(index++, e);
            modified = true;
        }
        return modified;
    }
    /**
     * Видаляє зі списку всі елементи, що містяться у вказаній колекції.
     *
     * @param c колекція елементів, які треба видалити.
     * @return {@code true}, якщо список змінився.
     */
    @Override
    public boolean removeAll(Collection<?> c) {
        boolean modified = false;
        for (Object item : c) {
            while (contains(item)) {
                remove(item);
                modified = true;
            }
        }
        return modified;
    }
    /**
     * Залишає у списку тільки ті елементи, що містяться у вказаній колекції.
     * Інші елементи видаляються.
     *
     * @param c колекція елементів, які треба залишити.
     * @return {@code true}, якщо список змінився.
     */
    @Override
    public boolean retainAll(Collection<?> c) {
        boolean modified = false;
        for (int i = 0; i < size; i++) {
            if (!c.contains(tracks[i])) {
                remove(i);
                i--;
                modified = true;
            }
        }
        return modified;
    }
    /**
     * Очищує список, видаляючи всі елементи.
     */
    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            tracks[i] = null;
        }
        size = 0;
    }
    /**
     * Повертає індекс першого входження вказаного елемента.
     *
     * @param o елемент для пошуку.
     * @return індекс елемента або -1, якщо елемент не знайдено.
     */
    @Override
    public int indexOf(Object o) {
        if (o == null) {
            for (int i = 0; i < size; i++)
                if (tracks[i] == null) return i;
        } else {
            for (int i = 0; i < size; i++)
                if (o.equals(tracks[i])) return i;
        }
        return -1;
    }
    /**
     * Повертає індекс останнього входження вказаного елемента.
     *
     * @param o елемент для пошуку.
     * @return індекс елемента або -1, якщо елемент не знайдено.
     */
    @Override
    public int lastIndexOf(Object o) {
        if (o == null) {
            for (int i = size - 1; i >= 0; i--)
                if (tracks[i] == null) return i;
        } else {
            for (int i = size - 1; i >= 0; i--)
                if (o.equals(tracks[i])) return i;
        }
        return -1;
    }
    /**
     * Перевіряє, чи містить список вказаний елемент.
     *
     * @param o елемент для перевірки.
     * @return {@code true}, якщо елемент знайдено.
     */
    @Override
    public boolean contains(Object o) {
        return indexOf(o) >= 0;
    }
    /**
     * Перевіряє, чи містить список всі елементи з вказаної колекції.
     *
     * @param c колекція для перевірки.
     * @return {@code true}, якщо всі елементи присутні.
     */
    @Override
    public boolean containsAll(Collection<?> c) {
        for (Object e : c)
            if (!contains(e)) return false;
        return true;
    }
    /**
     * Повертає масив, що містить усі елементи списку у правильній послідовності.
     *
     * @return масив об'єктів.
     */
    @Override
    public Object[] toArray() {
        return Arrays.copyOf(tracks, size);
    }
    /**
     * Повертає масив, що містить усі елементи списку.
     * Тип масиву визначається переданим параметром.
     *
     * @param a масив, у який будуть збережені елементи (якщо розміру достатньо).
     * @param <T> тип елементів масиву.
     * @return масив, що містить елементи списку.
     */
    @Override
    public <T> T[] toArray(T[] a) {
        if (a.length < size)
            return (T[]) Arrays.copyOf(tracks, size, a.getClass());
        System.arraycopy(tracks, 0, a, 0, size);
        if (a.length > size)
            a[size] = null;
        return a;
    }
    /**
     * Повертає ітератор для послідовного обходу елементів списку.
     *
     * @return об'єкт Iterator.
     */
    @Override
    public Iterator<MusicalComposition> iterator() {
        return new Iterator<MusicalComposition>() {
            private int cursor = 0;

            @Override
            public boolean hasNext() {
                return cursor < size;
            }

            @Override
            public MusicalComposition next() {
                if (cursor >= size) throw new NoSuchElementException();
                return tracks[cursor++];
            }
        };
    }

    @Override
    public ListIterator<MusicalComposition> listIterator() {
        return listIterator(0); }

    @Override
    public ListIterator<MusicalComposition> listIterator(int index) {
        return null;
    }
    /**
     * Повертає частину списку (підсписок) від fromIndex до toIndex.
     * Повертається новий незалежний екземпляр MusicList.
     *
     * @param fromIndex початковий індекс (включно).
     * @param toIndex кінцевий індекс (не включно).
     * @return новий список {@link MusicList}.
     * @throws IndexOutOfBoundsException якщо індекси некоректні.
     */
    @Override
    public List<MusicalComposition> subList(int fromIndex, int toIndex) {
        MusicList sub = new MusicList();
        for(int i = fromIndex; i < toIndex; i++) sub.add(tracks[i]);
        return sub;
    }
    // --- ДОПОМІЖНІ МЕТОДИ ---

    /**
     * Перевіряє місткість масиву та збільшує його при необхідності на 30%.
     *
     * @param minCapacity мінімально необхідна місткість.
     */
    private void ensureCapacity(int minCapacity) {
        if (minCapacity > tracks.length) {
            int oldCapacity = tracks.length;
            int newCapacity = oldCapacity + (int)(oldCapacity * 0.3);
            if (newCapacity < minCapacity) {
                newCapacity = minCapacity;
            }
            tracks = Arrays.copyOf(tracks, newCapacity);
        }
    }
    /**
     * Перевіряє коректність індексу.
     *
     * @param index індекс для перевірки.
     * @throws IndexOutOfBoundsException якщо індекс некоректний.
     */
    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Індекс: " + index + ", Розмір: " + size);
        }
    }
    /**
     * Метод для тестування місткості масиву.
     *
     * @return поточний розмір внутрішнього масиву.
     */
    public int getCapacity() {
        return tracks.length;
    }
}
