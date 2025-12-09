import java.util.List;
import java.util.Scanner;
/**
 * Головний клас програми.
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter text: ");
        StringBuilder inputText = new StringBuilder(sc.nextLine());

        Text text = new Text(inputText);

        System.out.print("Enter letter: ");
        String inputLetter = sc.next();
        Letter letter = new Letter(inputLetter.charAt(0));

        List<Word> words = text.getAllWords();

        // Сортування слів за зростанням кількості заданої літери
        for (int i = 0; i < words.size(); i++) {
            for (int j = i + 1; j < words.size(); j++) {
                Word word1 = words.get(i);
                Word word2 = words.get(j);
                if (word1.countLetter(letter) > word2.countLetter(letter)) {
                    words.set(i, word2);
                    words.set(j, word1);
                }
            }
        }
        System.out.print("Result: ");
        for (Word word : words) {
            System.out.print(word + " ");
        }
    }
}