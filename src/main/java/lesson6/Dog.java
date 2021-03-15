package lesson6;

public class Dog extends Animal{
    private int MAX_LENGTH_RUN = 500;
    private int MAX_LENGTH_SWIM = 10;
    private static int dogCount = 0;

    public Dog(String name) {
        super(name);
        dogCount++;
    }

    public Dog(String name, int maxLengthRun) {
        super(name);
        MAX_LENGTH_RUN = maxLengthRun;
        dogCount++;
    }
    public Dog(String name, int maxLengthRun, int maxLengthSwim) {
        super(name);
        MAX_LENGTH_RUN = maxLengthRun;
        MAX_LENGTH_SWIM = maxLengthSwim;
        dogCount++;
    }

    @Override
    public void run(int length) {
        if(length <= MAX_LENGTH_RUN)
            super.run(length);
        else
            System.out.println(name + ": Я столько не побегу. Мой предел - " + MAX_LENGTH_RUN);
    }

    @Override
    public void swim(int length) {
        if(length <= MAX_LENGTH_SWIM)
            super.swim(length);
        else
            System.out.println(name + ": Я столько не поплыву. Мой предел - " + MAX_LENGTH_SWIM);
    }

    public static int getDogCount() {
        return dogCount;
    }
}
