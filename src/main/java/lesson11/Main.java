package lesson11;

import lesson11.task3.Apple;
import lesson11.task3.Box;
import lesson11.task3.Orange;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        testFirst();
        testThird();


    }

    public static void testFirst(){
        MyType<Integer> arr1 = new MyType<>(1, 2, 3, 4, 5);
        MyType<Double> arr2 = new MyType<>(1.1, 2.2, 3.3, 4.4, 5.5);
        MyType<String> arr3 = new MyType<>("1", "2", "3", "4", "5");
        MyType<Apple> arr4 = new MyType<>(new Apple(), new Apple());

        arr1.print();
        arr1.swap(1, 3);
        arr1.print();

        arr2.print();
        arr2.swap(1, 3);
        arr2.print();

        arr3.print();
        arr3.swap(1, 3);
        arr3.print();

        arr4.print();
        arr4.swap(0, 1);
        arr4.print();

        System.out.println(arr1.arrayToArrayList());
    }

    public static void testThird(){
        Apple a1 = new Apple();
        Orange o1 = new Orange();
        Apple a2 = new Apple();
        Orange o2 = new Orange();
        Apple a3 = new Apple();
        Orange o3 = new Orange();

        Box box1 = new Box<>();
        box1.addFruit(a1);
        box1.addFruit(a2);

        Box box2 = new Box<>();
        box2.addFruit(o1);
        box2.addFruit(o2);

        Box box3 = new Box<>();
        box3.addFruit(o3);
        box3.addFruit(a3);

        Box box4 = new Box<>();

        System.out.println("box1: "+box1.getWeight());
        System.out.println("box2: "+box2.getWeight());
        System.out.println("box3: "+box3.getWeight());
        System.out.println("box4: "+box4.getWeight());
        System.out.println(box1.compare(box2));
        box3.pour(box4);
        System.out.println("box3: "+box3.getWeight());
        System.out.println("box4: "+box4.getWeight());


    }
}
