package lesson8;

public class Wall implements Obstacle{
    private int wallHeight;

    public Wall(int height) {
        this.wallHeight = height;
    }

    public Wall() {
        wallHeight = 10;
    }

    @Override
    public void overcomeObstacle(Member member) {
        member.jump(wallHeight);
    }

    @Override
    public void printInfo(){
        System.out.println("Wall, height " + wallHeight);
    }


}
