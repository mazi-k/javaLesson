package lesson14;


import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

    }

    public int[] method1(int[] array) {
        boolean presenceFour = false;
        ArrayList<Integer> arrayList = new ArrayList<>();

        for (int integer : array) {
            if (integer == 4) {
                presenceFour = true;
                break;
            }
        }
        if (presenceFour) {
            for(int i = array.length-1; array[i] != 4; i--){
                arrayList.add(0, array[i]);
            }
        } else {
            throw new RuntimeException("В массиве нет четвёрок");
        }

        int[] newArr = new int[arrayList.size()];
        for (int i = 0; i < newArr.length; i++) {
            newArr[i] = arrayList.get(i);
        }
        return newArr;
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
