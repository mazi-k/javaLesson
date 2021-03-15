package lesson8;

public class Track implements Obstacle{
    private int trackDistance;

    public Track(int distance) {
        this.trackDistance = distance;
    }

    public Track() {
        trackDistance = 20;
    }

    @Override
    public void overcomeObstacle(Member member) {
        member.run(trackDistance);
    }

    @Override
    public void printInfo(){
        System.out.println("Track, distance " + trackDistance);
    }
}
