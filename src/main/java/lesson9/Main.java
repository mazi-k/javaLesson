package lesson9;

public class Main {
    public static void main(String[] args) {
        String[][] arr1;
        String[][] arr2;

        arr1 = new String[][]{{"1", "y", "1", "1"},
                {"1", "1", "1", "1"},
                {"3", "1", "1", "1"},
                {"1", "1", "o", "1"}};

        arr2 = new String[][]{{"1", "1", "1", "1"},
                {"1", "1", "1", "1"},
                {"1", "1", "1", "1"},
                {"1", "1", "1", "1"},
                {"1", "1", "1", "1"}};

        makeSumArray(arr1);
        makeSumArray(arr2);
    }

    public static void makeSumArray(String[][] array) {
        int sum = 0;

        try {
            if (array.length != 4 || array[0].length != 4) {
                throw new MyArraySizeException();
            }
        } catch (MyArraySizeException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                try {
                    sum += myParseInt(array[i][j], i, j);
                } catch (MyArrayDataException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("Sum of array elements: " + sum);
    }

    public static int myParseInt(String s, int i, int j) throws MyArrayDataException {
        Integer num = null;

        try {
            num = Integer.parseInt(s.trim());
        } catch (NumberFormatException e) {
            e.getMessage();
        }

        if (!(num instanceof Integer)) {
            throw new MyArrayDataException(i, j);
        } else {
            return num;
        }
    }
}
