/*Варіант:
С5 = 2: C = A+B,
С7 = 2: short
С11 = 6: Обчислити суму найбільших елементів в стовпцях матриці з парними номерами
та найменших елементів в стовпцях матриці з непарними номерами */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int rows, cols, matrixInputMethod;
        System.out.println("Enter the number of rows and columns of the matrix:");
        System.out.print("Rows: ");
        rows = sc.nextInt();
        System.out.print("Columns: ");
        cols = sc.nextInt();
        System.out.print("Select matrix input method: 1 — manual, 2 — random: ");
        matrixInputMethod = sc.nextInt();

        short[][] A = new short[rows][cols];
        short[][] B = new short[rows][cols];

        if (matrixInputMethod == 1) {
            fillMatrixManual(A, sc, "A");
            fillMatrixManual(B, sc, "B");
        } else if (matrixInputMethod == 2) {
            fillMatrixRandom(A, "A");
            fillMatrixRandom(B, "B");
        } else {
            System.out.println("Invalid choice");
            return;
        }

        short[][] C = sumMatrix(A, B);
        countColumnElements(C);
    }

    static void fillMatrixManual(short[][] matrix, Scanner sc, String name) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        System.out.println(name + "(enter " + rows*cols + " numbers): ");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = (short) sc.nextInt();
            }
        }
    }

    static void fillMatrixRandom(short[][] matrix, String name) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        System.out.println(name + ":");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = (short) (Math.random() * 10);
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    static short[][] sumMatrix(short[][] A, short[][] B) {
        int rows = A.length;
        int cols = A[0].length;
        short[][] C = new short[rows][cols];
        System.out.println("C:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                C[i][j] = (short)(A[i][j] + B[i][j]);
                System.out.print(C[i][j] + " ");
            }
            System.out.println();
        }
        return C;
    }

    static void countColumnElements(short[][] C) {
        short sumEvenColumnsMax = 0;
        short sumOddColumnsMin = 0;
        int rows = C.length;
        int cols = C[0].length;

        for (int j = 0; j < cols; j++) {
            if (j % 2 == 0) {
                short max = C[0][j];
                for (int i = 0; i < rows; i++) {
                    if (C[i][j] > max) {
                        max = C[i][j];
                    }
                }
                sumEvenColumnsMax += max;
            } else {
                short min = C[0][j];
                for (int i = 0; i < rows; i++) {
                    if (C[i][j] < min) {
                        min = C[i][j];
                    }
                }
                sumOddColumnsMin += min;
            }
        }
        System.out.println("Sum of max elements in even columns: " + sumEvenColumnsMax);
        System.out.println("Sum of min elements in odd columns: " + sumOddColumnsMin);
    }
}