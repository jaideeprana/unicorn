package spike;

import java.io.IOException;
import java.net.ServerSocket;

public class Unicorn {
    public static void main(String[] args) {
        try{
            ServerSocket serverSocket = new ServerSocket(8080);
        }
        catch(IOException e) {
            System.out.println("Could not listen on port: 8080");
            e.printStackTrace();
        }
    }


}
