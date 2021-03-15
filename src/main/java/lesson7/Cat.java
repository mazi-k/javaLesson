package lesson7;

public class Cat {
    private String name;
    private int appetite;
    private boolean isSatisfied;


    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
        isSatisfied = false;
    }

    public void eat(Plate p) {
        if (isSatisfied){
            System.out.println("Do not overfeed the cat " + name);
        }
        if (p.decreaseFood(appetite)) {
            isSatisfied = true;
        }
    }

    public void catSatisfied(){
        if(isSatisfied){
            System.out.println("The cat " + name + " is well fed");
        }
        else
            System.out.println("The cat " + name + " is hungry");
    }
}
