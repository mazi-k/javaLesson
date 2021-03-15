package lesson8;

public class Test {

    public static void main(String[] args) {
        printObstacleCourse();
        System.out.println();
        startCompetition();
    }


    public static void printObstacleCourse() {
        System.out.println("Welcome to the competition. List of obstacles:");
        for (Obstacle obstacle: makeObstacleCourse()){
            obstacle.printInfo();
        }
    }

    public static Obstacle[] makeObstacleCourse() {
        Obstacle obstacle1 = new Wall(5);
        Obstacle obstacle2 = new Track(15);
        Obstacle obstacle3 = new Wall(2);
        Obstacle obstacle4 = new Wall();
        Obstacle obstacle5 = new Track();

        Obstacle[] obstacleCourse = new Obstacle[] {obstacle1, obstacle2, obstacle3, obstacle4, obstacle5};
        return obstacleCourse;
    }

    public static Member[] makeParticipants() {
        Human human = new Human("Josef");
        Human human2 = new Human("Doppio", 12, 7);
        Robot robot = new Robot("Diamond");
        Cat cat = new Cat("Murzilka");

        Member[] members = new Member[] {human, human2, robot, cat};
        return members;
    }

    public static void startCompetition() {
        for (Member member: makeParticipants()){
            for (int j = 0; j < makeObstacleCourse().length; j++){
                if(member.Is_alive()){
                    makeObstacleCourse()[j].printInfo();
                    makeObstacleCourse()[j].overcomeObstacle(member);
                    if(j == makeObstacleCourse().length-1 && member.Is_alive())
                        System.out.println("This participant is completed\n");
                } else
                    break;
            }
        }
    }
}
