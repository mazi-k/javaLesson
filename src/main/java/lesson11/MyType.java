package lesson11;

import java.util.ArrayList;
import java.util.Arrays;

public class MyType<T extends Object> {
    private T[] array;

    public MyType(T... array){
        this.array = array;
    }

    public T[] swap(int numberOfFirstElement, int numberOfSecondElement){
        T buf = array[numberOfFirstElement];
        array[numberOfFirstElement] = array[numberOfSecondElement];
        array[numberOfSecondElement] = buf;
        return array;
    }

    public void print(){
        for (int i = 0; i < array.length; i++){
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public ArrayList<T> arrayToArrayList(){
        ArrayList<T> arrayList = new ArrayList<T>(Arrays.asList(array));
        return arrayList;
    }
}
