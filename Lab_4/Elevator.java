import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Elevator implements Runnable{
    public enum Status{AFK,GOING_DOWN,GOING_UP}
    private int currentFloor=1;
    private final int minFloor = 1;
    private final int maxFloor;
    private final int id;
    private final List<Integer> requestedFloors = new ArrayList<>();
    private Status status = Status.AFK;
    private final List<Client>  clients = new ArrayList<>();
    Elevator(int id,int maxFloor){
        this.id = id;
        this.maxFloor = maxFloor;
    }
    @Override
    public void run() {
        if (currentFloor >= requestedFloors.get(0)){
            status = Status.GOING_DOWN;
            for (int i = currentFloor; i > requestedFloors.get(0); i--) {
                System.out.println(Thread.currentThread().getName() + " now on " + i + " floor");
                decrementFloor();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            requestedFloors.remove(0);
            System.out.println(Thread.currentThread().getName() + " someone is coming on " + currentFloor +" floor");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        } else if (currentFloor <= requestedFloors.get(0)) {
            status = Status.GOING_UP;
            for (int i = currentFloor; i < requestedFloors.get(0); i++) {
                System.out.println(Thread.currentThread().getName() + " now on " + i + " floor");
                incrementFloor();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            requestedFloors.remove(0);
            System.out.println(Thread.currentThread().getName() + " someone is coming on " + currentFloor +" floor");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        if(clients.get(clients.size()-1).getDirection()==Status.GOING_UP){
            status = Status.GOING_UP;
            for(int i=currentFloor;i<maxFloor;i++){
                if(requestedFloors.size()!=0){
                    run();
                    return;
                }
                incrementFloor();
                System.out.println(Thread.currentThread().getName() + " now on " + i + " floor");
                try{
                    Thread.sleep(1000);
                }
                catch (InterruptedException e){
                    System.out.println("InterruptedThread");
                }
            }
            clients.clear();
            status = Status.AFK;
            System.out.println(Thread.currentThread().getName() + " now is stopped on " + currentFloor);
        }
        else if (clients.get(clients.size()-1).getDirection()==Status.GOING_DOWN) {
            status = Status.GOING_DOWN;
            for(int i=currentFloor;i>minFloor;i--){
                if(requestedFloors.size()!=0){
                    run();
                    return;
                }
                decrementFloor();
                System.out.println(Thread.currentThread().getName() + " now on " + i + " floor");
                try{
                    Thread.sleep(1000);
                }
                catch (InterruptedException e){
                    System.out.println("InterruptedThread");
                }
            }
            clients.clear();
            status = Status.AFK;
            System.out.println(Thread.currentThread().getName() + " now is stopped on " + currentFloor);
        }
    }
    private void decrementFloor(){
        currentFloor--;
    }
    private void incrementFloor(){
        currentFloor++;
    }
    public int getCurrentFloor() {
        return currentFloor;
    }
    public Status getStatus() {
        return status;
    }
    public int getId(){
        return id;
    }
    public void addClient(Client client){
        clients.add(client);
        if(requestedFloors.size()==0
                || status==Status.GOING_UP && client.getFromFloor()>requestedFloors.get(0)
                || status==Status.GOING_DOWN && client.getFromFloor()<requestedFloors.get(0)){
            requestedFloors.add(client.getFromFloor());
        }
        else if(status==Status.GOING_UP && client.getFromFloor() < requestedFloors.get(0)){
            requestedFloors.add(client.getFromFloor());
            Collections.sort(requestedFloors);
        }else if(status==Status.GOING_DOWN && client.getFromFloor() > requestedFloors.get(0)){
            requestedFloors.add(client.getFromFloor());
            Collections.sort(requestedFloors);
            Collections.reverse(requestedFloors);
        }
    }
    public Status getClientsDirection(){
        return clients.get(0).getDirection();
    }
}
