package lesson6;

public class Cat extends Animal{
    private int MAX_LENGTH_RUN = 200;
    private static int catCount = 0;

    public Cat(String name) {
        super(name);
        catCount++;
    }

    public Cat(String name, int maxLengthRun) {
        super(name);
        MAX_LENGTH_RUN = maxLengthRun;
        catCount++;
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
        System.out.println(name + ": Зачем ты бросил меня в воду?");
    }

    public static int getCatCount() {
        return catCount;
    }
}
