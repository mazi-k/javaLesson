package lesson13;

public class Car implements Runnable {
    private static int CARS_COUNT;
    private Race race;
    private int speed;
    private String name;
    public boolean isFinish;

    public String getName() {
        return name;
    }

    public int getSpeed() {
        return speed;
    }

    public Car(Race race, int speed) {
        this.race = race;
        this.speed = speed;
        CARS_COUNT++;
        this.name = "Участник #" + CARS_COUNT;
        isFinish = false;
    }

    @Override
    public void run() {
        System.out.println(this.name + " готовится");
        try {
            Thread.sleep(500 + (int) (Math.random() * 800));
            MainClass.cdl.countDown();
            System.out.println(this.name + " готов");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            try {
                MainClass.cdl.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        for (int i = 0; i < race.getStages().size(); i++) {
            race.getStages().get(i).go(this);
            if((1+i) == race.getStages().size()){
                isFinish = true;
            }
        }
        System.out.println(name + " завершил трассу");
    }
}
