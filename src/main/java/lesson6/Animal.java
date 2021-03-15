package lesson6;

public abstract class Animal {
    String name;
    private static int animalCount = 0;

    public Animal(String name) {
        this.name = name;
        animalCount++;
    }

    public void run(int length) {
        System.out.println(name + " пробежал(а) " + length + " метров!");
    }

    public void swim(int length){
        System.out.println(name + " проплыл(а) " + length + " метров!");
    }

    public static int getAnimalCount(){
        return animalCount;
    }

}
