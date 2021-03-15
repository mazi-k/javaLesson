package lesson9;

public class MyArraySizeException extends Exception {
    public MyArraySizeException(){
        super("Array sizes do not match the standard ones");
    }
}
