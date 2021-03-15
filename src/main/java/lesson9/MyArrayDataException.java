package lesson9;

public class MyArrayDataException extends Exception{
    public MyArrayDataException(int i, int j){
        super("The contents of the cell [" + i + "][" + j + "] could not be converted to the required type");
    }
}
