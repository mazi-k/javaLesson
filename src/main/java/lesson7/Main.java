package lesson7;

public class Main {
    public static void main(String[] args) {
        Cat cat1 = new Cat("Barsik", 50);
        Cat cat2 = new Cat("Musya", 15);
        Cat cat3 = new Cat("Tom", 20);
        Cat cat4 = new Cat("Azazel", 45);
        Plate plate = new Plate(100);

        Cat[] cats = new Cat[] {cat1, cat2, cat3, cat4};

        plate.info();
        for (int i = 0; i < cats.length; i++){
            cats[i].eat(plate);
            cats[i].catSatisfied();
        }

        plate.increaseFood(30);
        plate.increaseFood(300);

    }
}
