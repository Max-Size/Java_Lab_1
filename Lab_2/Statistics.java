import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Scanner;
public class Statistics {
    private final HashMap <Character, Integer> stats = new HashMap<>();
    private FileInputStream fin = null;
    private FileOutputStream fos = null;
    private boolean scanned=false;
    Statistics(){
        for(char i='A';i<='Z';i++){
            stats.put(i,0);
        }
        for(char i='a';i<='z';i++){
            stats.put(i,0);
        }
    }
    private boolean open_fin() {
        Scanner in = new Scanner(System.in);
        System.out.println("Please input full path of file for reading");
        String path = in.nextLine();
        try {
            fin = new FileInputStream(path);
        }
        catch (FileNotFoundException e){
            System.out.println("There is no such file or directory");
            return false;
        }
        return true;
    }
    private boolean open_fos() {
        Scanner in = new Scanner(System.in);
        System.out.println("Please input full path of file for writing stats");
        String path = in.nextLine();
        try {
            fos = new FileOutputStream(path);
        }
        catch (FileNotFoundException e){
            System.out.println("There is no such file or directory");
            return false;
        }
        return true;
    }
    private void putIn(char i){
        if(stats.containsKey(i)){
            stats.put(i,stats.get(i)+1);
        }
    }
    public void makeStatFromFile(){
        if(!open_fin()){
            return;
        }
        int i;
        try {
            while ((i = fin.read()) != -1) {
                this.putIn((char) i);
            }
            scanned = true;
        }
        catch (IOException e){
            System.out.println("Problems with inputting or outputting");
        }
        try {
           fin.close();
        }
        catch (IOException e){
            System.out.println("Error while closing");
        }
    }
    public void writeStatToFile(){
        if(!scanned || !open_fos()){
            return;
        }
        for(Character i : stats.keySet()){
            String str = i+": "+stats.get(i)+"\n";
            try {
                fos.write(str.getBytes(StandardCharsets.UTF_8));
            }
            catch (IOException e){
                System.out.println("Some problems emerged when writing stats");
            }
        }
        try{
            fos.close();
        }
        catch (IOException e){
            System.out.println("Error while closing");
        }
    }
}
