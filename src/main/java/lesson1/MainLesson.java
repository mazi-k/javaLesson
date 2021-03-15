package lesson1;

public class MainLesson {
    public static void main(String[] args) {
        byte myByte = 0xA;
        short myShort = 15;
        int myInt = 7;
        double myDouble = 3.0;
        float myFloat = 5;
        char myChar = 'c';
        boolean myBoolean = true;

        System.out.println(calculateValue(myByte, myShort, myInt, myDouble));
        System.out.println(isSumInBetween(12, 7));
        findNumberPosOrNeg(0);
        System.out.println(isNumberNeg(-6));
        helloSomeone("Den");
        isYearLeap(2020);
        isYearLeap(1900);

    }

    public static int calculateValue(byte a, short b, int c, double d) {
        int result = (int)(a * (b + (c / d)));
        return result;
    }

    public static boolean isSumInBetween(int a, int b){
    int sum = a + b;
    if(sum >= 10 && sum <= 20)
        return true;
    else
        return false;

    }

    public static void findNumberPosOrNeg(int number){
        if (number >= 0)
            System.out.println("number is positive");
        else
            System.out.println("number is negative");
    }

    public static boolean isNumberNeg(int number){
        if(number < 0)
            return true;
        else
            return false;
    }

    public static void helloSomeone(String name){
        System.out.println("Hello, " + name + "!");
    }

    public static void isYearLeap(int year){
        if(year % 4 == 0 && year % 100 != 0 || year % 400 == 0){
            System.out.println("this year (" + year + ") is lean");
        } else
            System.out.println("this year (" + year + ") is not lean");
    }
}
