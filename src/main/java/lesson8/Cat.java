package lesson8;

public class Cat implements Member{
    protected String name;
    protected int distance;
    protected int jumpHeight;
    protected boolean is_alive;

    public Cat(String name){
        this.name = name;
        distance = 15;
        jumpHeight = 10;
        is_alive = true;
    }

    public Cat(String name, int distance, int jumpHeight){
        this.name = name;
        this.distance = distance;
        this.jumpHeight = jumpHeight;
        is_alive = true;
    }

    @Override
    public void run(int trackDistance){
        if (distance >= trackDistance){
            System.out.println(name + ": ran");
        }
        else {
            System.out.println(name + ": did not run");
            is_alive = false;
            System.out.println("___" + name + " retires___\n");
        }
    }

    @Override
    public void jump(int wallHeight){
        if (jumpHeight >= wallHeight){
            System.out.println(name + ": jumped over");
        }
        else {
            System.out.println(name + ": did not jump over");
            is_alive = false;
            System.out.println("___" + name + " retires___\n");
        }
    }

    @Override
    public boolean Is_alive() {
        return is_alive;
    }
}
