package lesson14;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
    }

    public Integer[] method1(Integer[] array) {
        boolean presenceFour = false;
        ArrayList<Integer> newArray = new ArrayList<>();

        for (Integer integer : array) {
            if (integer == 4) {
                presenceFour = true;
                break;
            }
        }
        if (presenceFour) {
            for(int i = array.length-1; array[i] != 4; i--){
                newArray.add(0, array[i]);
            }
        } else {
            throw new RuntimeException("В массиве нет четвёрок");
        }
        return newArray.toArray(new Integer[0]);
    }

    public boolean method2(Integer[] array) {
        boolean isOne = false;
        boolean isFour = false;
        boolean isAnother = false;

        for (Integer integer : array) {
            if (integer == 1) {
                isOne = true;
            }
            if (integer == 4) {
                isFour = true;
            }
            if (integer != 1 && integer != 4) {
                isAnother = true;
            }
        }
        return isOne & isFour & !isAnother;
    }
}
