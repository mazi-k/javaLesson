package lesson7;

public class Plate {
    private int food;
    private int PLATE_SIZE = 500;

    public Plate(int food) {
        this.food = food; }

    public boolean decreaseFood(int n) {
        if(food >=n){
            food -= n;
            return true;
        }
        else{
            return false;
        }
    }

    public void info() {
        System.out.println("plate: " + food);
    }

    public void increaseFood(int n){
        if((food + n) <= PLATE_SIZE){
            food += n;
            System.out.println("The plate is refilled with " + n);
            info();
        }
        else{
            food = PLATE_SIZE;
            System.out.print("The plate is full! ");
            info();
        }

    }
}
