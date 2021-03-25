package lesson11.task3;

import java.util.ArrayList;

public class Box <T extends Fruit>{
    ArrayList<T> fruitBox = new ArrayList<T>();
    private float boxWeight;

    public Box() {
        boxWeight = 0.0f;
    }

    public float getWeight(){
        return boxWeight;
    }

    public boolean compare(Box<T> otherBox){
        return this.getWeight() == otherBox.getWeight();
    }

    public void addFruit(T fruit){
        fruitBox.add(fruit);
        boxWeight += fruit.getWeight();
    }

    public void pour(Box<T> otherBox){
        if(otherBox.boxWeight == 0f){
            for (int i = 0; i < this.fruitBox.size(); i++){
                otherBox.addFruit(this.fruitBox.get(i));
                this.boxWeight -= this.fruitBox.get(i).getWeight();
            }
            this.fruitBox.clear();
        } else if(otherBox.boxWeight != 0f){
            System.out.println("the other box is not empty");
        } else if(this.boxWeight == 0f){
            System.out.println("the box is empty");
        }
    }
}
