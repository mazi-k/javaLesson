package lesson6;

public class Main {
    public static void main(String[] args) {
        Cat cat = new Cat("Муся");
        Dog dog = new Dog("Арнольд");
        Cat cat2 = new Cat("Дуся", 500);
        Dog dog2 = new Dog("Костян", 400, 20);

        Animal[] animals = {cat, dog, cat2, dog2};

        System.out.println("Animal count: " + Animal.getAnimalCount());
        System.out.println("Cat count: " + Cat.getCatCount());
        System.out.println("Dog count: " + Dog.getDogCount());

        for (int i = 0; i < animals.length; i++){
            animals[i].run(500);
            animals[i].swim(12);
        }
    }
}
