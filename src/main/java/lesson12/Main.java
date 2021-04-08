package lesson12;

import java.util.Arrays;

public class Main {

    static final int SIZE = 10000000;
    static final int HALF = SIZE / 2;

    public static void main(String[] args) {
        singleThread();
        multiThread();
    }

    public static void singleThread(){
        float[] arr = new float[SIZE];
        Arrays.fill(arr, 1);

        long a = System.currentTimeMillis();
        formula(arr, 0);
        System.currentTimeMillis();
        System.out.println("singleThread time: " + (System.currentTimeMillis() - a));
    }

    public static void multiThread(){
        float[] arr = new float[SIZE];
        Arrays.fill(arr, 1);

        long a = System.currentTimeMillis();

        float[] arr1 = new float[HALF];
        System.arraycopy(arr, 0, arr1, 0, HALF);
        float[] arr2 = new float[HALF];
        System.arraycopy(arr, HALF, arr2, 0, HALF);

        Thread t1 = new Thread(() -> {
            formula(arr1, 0);
        });

        Thread t2 = new Thread(() -> {
            formula(arr2, HALF);
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.arraycopy(arr1, 0, arr, 0, HALF);
        System.arraycopy(arr2, 0, arr, HALF, HALF);

        System.currentTimeMillis();
        System.out.println("multiThread time: " + (System.currentTimeMillis() - a));
    }

   public static float[] formula(float[] arr, int shift){
        for (int i = 0; i < arr.length; i++){
            arr[i] = (float)(arr[i] * Math.sin(0.2f + (i+shift) / 5) * Math.cos(0.2f + (i+shift) / 5) * Math.cos(0.4f + (i+shift) / 2));
        }
        return arr;
    }
}
