import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        System.out.print("Please input amount of floors in the house:");
        Scanner in = new Scanner(System.in);
        int amountOfFloors = in.nextInt();
        in.nextLine();
        System.out.print("Please input interval between each client request in second:");
        int interval = in.nextInt();
        in.nextLine();
        System.out.print("Please input amount of client requests:");
        int amountOfRequests = in.nextInt();
        in.nextLine();
        Elevator elevator1 = new Elevator(1,amountOfFloors);
        Elevator elevator2 = new Elevator(2,amountOfFloors);
        while (amountOfRequests>0){
            int fromFloor = Client.getRandomFloor(1,amountOfFloors);
            Elevator.Status direction = Client.getRandomDirection(fromFloor,1,amountOfFloors);
            Client client = new Client(fromFloor,direction);
            System.out.println(client);
            Elevator elevator = ElevatorsController.defineElevator(elevator1,elevator2,client);
            if(elevator.getStatus() == Elevator.Status.AFK){
                elevator.addClient(client);
                Thread thread = new Thread(elevator,"Elevator-"+elevator.getId());
                thread.start();
            }else{
                elevator.addClient(client);
            }
            amountOfRequests--;
            try {
                Thread.sleep(interval* 1000);
            }catch (InterruptedException e){
                throw new RuntimeException();
            }
        }
    }
}
