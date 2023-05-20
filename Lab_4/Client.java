public class Client {
    private int fromFloor;
    private Elevator.Status direction;
    Client(int fromFloor,Elevator.Status direction){
        this.fromFloor = fromFloor;
        this.direction = direction;
    }
    public int getFromFloor() {
        return fromFloor;
    }
    public Elevator.Status getDirection() {
        return direction;
    }
    public static int getRandomFloor(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }
    public static Elevator.Status getRandomDirection(int fromSomeFloor,int minFloor,int maxFloor){
        if(fromSomeFloor==minFloor){
            return Elevator.Status.GOING_UP;
        }
        else if(fromSomeFloor==maxFloor){
            return Elevator.Status.GOING_DOWN;
        }
        else{
            double randomNumber = Math.random();
            if(randomNumber>0.5){
                return Elevator.Status.GOING_DOWN;
            } else{
                return Elevator.Status.GOING_UP;
            }
        }
    }
    @Override
    public String toString() {
        String directionTemp;
        directionTemp = direction== Elevator.Status.GOING_UP? "up" : "down";
        return "New client at "+fromFloor+" floor wants to go "+directionTemp;
    }
}

