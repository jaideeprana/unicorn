package spike;

import java.net.ServerSocket;

public class Unicorn {
    public static void main(String[] args) {
        try{
            ServerSocket serverSocket= new ServerSocket(9090);
            Address address=new Address();
            address.get(serverSocket);
            address.read();
            address.write();
            serverSocket.close();
        }
        catch(Exception e){
            System.out.println("conncection not found");
        }
    }
}
