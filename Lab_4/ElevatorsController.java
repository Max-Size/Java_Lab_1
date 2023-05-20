import static java.lang.Math.abs;

public class ElevatorsController{
    public static Elevator defineElevator(Elevator elevator1,Elevator elevator2, Client client){
        if(elevator1.getStatus()== Elevator.Status.AFK && elevator2.getStatus()== Elevator.Status.AFK){
            if(abs(elevator1.getCurrentFloor() - client.getFromFloor())>abs(elevator2.getCurrentFloor() - client.getFromFloor())){
                return elevator2;
            }
            else{
                return elevator1;
            }
        }
        else if(elevator1.getStatus()== Elevator.Status.AFK && elevator2.getStatus()!= Elevator.Status.AFK ||
                elevator2.getStatus()== Elevator.Status.AFK && elevator1.getStatus()!= Elevator.Status.AFK) {
            if (elevator2.getStatus() == Elevator.Status.GOING_DOWN) {
                if(client.getDirection()==elevator2.getClientsDirection() && elevator2.getCurrentFloor() > client.getFromFloor() &&
                        (abs(elevator2.getCurrentFloor()- client.getFromFloor())<=abs(elevator1.getCurrentFloor()- client.getFromFloor()))){
                    return elevator2;
                }
                else{
                    return elevator1;
                }
            }
            else if (elevator2.getStatus() == Elevator.Status.GOING_UP) {
                if(client.getDirection()==elevator2.getClientsDirection() && elevator2.getCurrentFloor() < client.getFromFloor() &&
                        (abs(elevator2.getCurrentFloor()- client.getFromFloor())<=abs(elevator1.getCurrentFloor()- client.getFromFloor()))){
                    return elevator2;
                }
                else{
                    return elevator1;
                }
            }
            else if (elevator1.getStatus() == Elevator.Status.GOING_DOWN) {
                if(client.getDirection()==elevator1.getClientsDirection() && elevator1.getCurrentFloor() > client.getFromFloor() &&
                        (abs(elevator1.getCurrentFloor()- client.getFromFloor())<=abs(elevator2.getCurrentFloor()- client.getFromFloor()))){
                    return elevator1;
                }
                else{
                    return elevator2;
                }
            }else if (elevator1.getStatus() == Elevator.Status.GOING_UP) {
                if(client.getDirection()==elevator1.getClientsDirection() && elevator1.getCurrentFloor() < client.getFromFloor() &&
                        (abs(elevator1.getCurrentFloor()- client.getFromFloor())<=abs(elevator2.getCurrentFloor()- client.getFromFloor()))){
                    return elevator1;
                }
                else{
                    return elevator2;
                }
            }
        }else if(elevator1.getStatus()!= Elevator.Status.AFK && elevator2.getStatus()!= Elevator.Status.AFK) {
            if (elevator2.getStatus() == Elevator.Status.GOING_DOWN && client.getDirection() == elevator2.getClientsDirection() && elevator2.getCurrentFloor() > client.getFromFloor()) {
                    return elevator2;
            } else if (elevator2.getStatus() == Elevator.Status.GOING_UP && client.getDirection() == elevator2.getClientsDirection() && elevator2.getCurrentFloor() < client.getFromFloor()) {
                    return elevator2;
            } else if (elevator1.getStatus() == Elevator.Status.GOING_DOWN && client.getDirection() == elevator1.getClientsDirection() && elevator1.getCurrentFloor() > client.getFromFloor()) {
                    return elevator1;
            } else if (elevator1.getStatus() == Elevator.Status.GOING_UP && client.getDirection() == elevator1.getClientsDirection() && elevator1.getCurrentFloor() < client.getFromFloor()) {
                    return elevator1;
            }else{
                try {
                    Thread.sleep(100);
                }catch (InterruptedException e){
                    return  null;
                }
                return defineElevator(elevator1,elevator2,client);
            }
        }
        return defineElevator(elevator1,elevator2,client);
    }
}
