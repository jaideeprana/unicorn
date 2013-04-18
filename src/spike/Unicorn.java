package spike;

import java.net.ServerSocket;

public class Unicorn {
    public static void main(String[] args) {
        try{
            ServerSocket serverSocket= new ServerSocket(8080);
        }
        catch(Exception e){
            System.out.println("conncection not found");
        }
    }
}
