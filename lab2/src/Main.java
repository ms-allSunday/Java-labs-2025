import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
Варіант:
C3 = 0 StringBuilder
C17 = 8 Відсортувати слова заданого тексту за зростанням кількості в них заданої літери.
*/
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter text: ");
        String inputText = sc.nextLine();
        StringBuilder text = new StringBuilder(inputText);

        System.out.println("Enter letter: ");
        char letter = sc.next().charAt(0);

        List<StringBuilder> words = new ArrayList<>();
        StringBuilder word = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);

            if (c != ' ') {
                word.append(c);
            } else {
                if (!word.isEmpty()) {
                    words.add(word);
                    word = new StringBuilder();
                }
            }
        }

        if (!word.isEmpty()) {
            words.add(word);
        }

        for (int i = 0; i < words.size(); i++) {
            for (int j = i + 1; j < words.size(); j++) {
                if (countLetter(words.get(i), letter) > countLetter(words.get(j), letter)) {
                    StringBuilder temp = words.get(i);
                    words.set(i, words.get(j));
                    words.set(j, temp);
                }
            }
        }

        StringBuilder result = new StringBuilder();
        for (StringBuilder el : words) {
            result.append(el).append(" ");
        }

        System.out.println(result.toString().trim());
    }

    private static int countLetter(StringBuilder word, char letter) {
        int count = 0;
        for (int i = 0; i < word.length(); i++) {
            if (Character.toLowerCase(word.charAt(i)) == letter) {
                count++;
            }
        }
        return count;
    }
}