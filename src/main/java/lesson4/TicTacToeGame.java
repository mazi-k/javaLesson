package lesson4;

import java.util.Random;
import java.util.Scanner;

public class TicTacToeGame {

    static int SIZE = 6;
    static int WINNING_STREAK = 4;

    static final char DOT_EMPTY = '•';
    static final char DOT_HUMAN = 'X';
    static final char DOT_AI = 'O';

    static final char HEADER_FIRST_SYMBOL = '♥';
    static final String EMPTY = "　";

    static final char[][] MAP = new char[SIZE][SIZE];
    static final Scanner in = new Scanner(System.in);
    static final Random random = new Random();
    static int turnsCount;

    static int rowNumber;
    static int columnNumber;


    public static void main(String[] args) {
        turnGame();
    }

    public static void turnGame() {

        //инициализация поля
        initMap();

        //печать поля в консоль
        printMap();

        //игра
        playGame();

    }

    private static void initMap() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                MAP[i][j] = DOT_EMPTY;
            }
        }
    }

    private static void printMap() {
        //печать заголовка
        printHeaderMap();

        //печать поля
        printBodyMap();
    }

    private static void printHeaderMap() {
        System.out.print(HEADER_FIRST_SYMBOL + EMPTY);

        for (int i = 0; i < SIZE; i++) {
            printMapNumber(i);
        }
        System.out.println();

    }

    private static void printMapNumber(int i) {
        System.out.print(i + 1 + EMPTY);
    }

    private static void printBodyMap() {
        for (int i = 0; i < SIZE; i++) {
            printMapNumber(i);
            for (int j = 0; j < SIZE; j++) {
                System.out.print(MAP[i][j] + EMPTY);
            }
            System.out.println();
        }
    }


    private static void playGame() {

        turnsCount = 0;
        while (true) {
            humanTurn();
            printMap();
            checkEnd(DOT_HUMAN);


            turnComputer();
            printMap();
            checkEnd(DOT_AI);
        }
    }

    private static void humanTurn() {
        boolean isInputValid = true;
        System.out.println("\nХод человека! Введите номера строки и столбца");
        do {
            rowNumber = -1;
            columnNumber = -1;
            isInputValid = true;

            System.out.print("Строка: ");
            if (in.hasNextInt()) {
                rowNumber = in.nextInt() - 1;
            } else {
                processingIncorrectInput();
                isInputValid = false;
                continue;
            }

            System.out.print("Столбик: ");
            if (in.hasNextInt()) {
                columnNumber = in.nextInt() - 1;
            } else {
                processingIncorrectInput();
                isInputValid = false;
            }

        } while (!(isInputValid && isHumanTurnValid(rowNumber, columnNumber)));

        MAP[rowNumber][columnNumber] = DOT_HUMAN;
        turnsCount++;
    }

    private static void processingIncorrectInput() {
        System.out.println("Ошибка ввода! Введите число в диапазоне размера игрового поля");
        in.nextLine();
    }

    private static boolean isHumanTurnValid(int rowNumber, int columnNumber) {
        if (!isNumbersValid(rowNumber, columnNumber)) {
            System.out.println("\nПроверьте значения строки и столбца");
            return false;
        } else if (!isCellOccupancy(rowNumber, columnNumber)) {
            System.out.println("\nВы выбрали занятую ячейку");
            return false;
        }

        return true;
    }

    private static boolean isNumbersValid(int rowNumber, int columnNumber) {
        return !(rowNumber >= SIZE || rowNumber < 0 || columnNumber >= SIZE || columnNumber < 0);
    }

    private static boolean isCellOccupancy(int rowNumber, int columnNumber) {
        return MAP[rowNumber][columnNumber] == DOT_EMPTY;
    }


    private static void checkEnd(char symbol) {
        if (checkWin(symbol, rowNumber, columnNumber)) {
            if (symbol == DOT_HUMAN) {
                System.out.println("Ура! Вы победили!");
            } else {
                System.out.println("Победил компьютер!");
            }
            System.exit(0);
        } else if (isMapFull()) {
            System.out.println("Ничья!");
            System.exit(0);
        }
    }

    private static boolean isMapFull() {
        return turnsCount == SIZE * SIZE;
    }

    private static boolean checkWin(char symbol, int x, int y){
        return checkRow(symbol, x, y) || checkColumn(symbol, x, y)
                || checkParallelMainDiagonal(symbol, x, y) || checkParallelSideDiagonal(symbol, x, y);
    }

    private static boolean checkRow(char symbol, int x, int y){
        int winCount = 0;
        boolean win = false;
        for (int i = 0; i < SIZE; i++) {
            if (MAP[x][i] == symbol) {
                winCount++;
                win = winCount >= WINNING_STREAK ? true : false;
            }
            else if(MAP[x][i] != symbol)
                winCount = 0;
        }
        return win;
    }

    private static boolean checkColumn(char symbol, int x, int y) {
        int winCount = 0;
        boolean win = false;
        for (int i = 0; i < SIZE; i++){
            if (MAP[i][y] == symbol) {
                winCount++;
                win = winCount >= WINNING_STREAK ? true : false;
            }
            else if(MAP[i][y] != symbol)
                winCount = 0;
        }
        return win;
    }

    private static boolean checkParallelMainDiagonal(char symbol, int x, int y){
        int winCount = 0;
        boolean win = false;
        for (int k = 0; k < SIZE - WINNING_STREAK + 1; k++) { //diagonals
            for (int i = 0; i < SIZE - k; i++){ //elements
                if (Math.abs(x - y) == k && (MAP[i][i+k] == symbol || MAP[i+k][i] == symbol)) {
                    winCount++;
                    win = winCount >= WINNING_STREAK ? true : false;
                }
                else if(MAP[i][i+k] != symbol || MAP[i+k][i] != symbol)
                    winCount = 0;
            }
        }
        return win;
    }

    private static boolean checkParallelSideDiagonal(char symbol, int x, int y){
        int winCount = 0;
        boolean win = false;
        for (int k = 1; k < SIZE - WINNING_STREAK; k++) {//diagonals
            for (int i = 0; i < SIZE - k; i++){//elements
                if ((x + y == SIZE-k || x+y == SIZE+k) && MAP[i][SIZE-1-i] == symbol || MAP[k+i][SIZE-1-i] == symbol) {
                    winCount++;
                    win = winCount >= WINNING_STREAK ? true : false;
                }
                else if(MAP[i][SIZE-1-i] != symbol || MAP[k+i][SIZE-1-i] != symbol)
                    winCount = 0;
            }
        }
        return win;
    }

    private static void turnComputer() {
        System.out.println("\nХод компьютера!");

        do {
            rowNumber = random.nextInt(SIZE);
            columnNumber = random.nextInt(SIZE);
        } while (!isCellOccupancy(rowNumber, columnNumber));

        MAP[rowNumber][columnNumber] = DOT_AI;
        turnsCount++;
    }
}
