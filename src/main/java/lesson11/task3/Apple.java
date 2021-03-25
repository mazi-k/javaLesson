package lesson11.task3;

public class Apple extends Fruit{
    private float weight;

    public Apple(float weight) {
        this.weight = weight;
    }

    public Apple() {
        weight = 1.0f;
    }

    @Override
    public float getWeight() {
        return weight;
    }
}
