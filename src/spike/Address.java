package spike;


import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Address {

    private Socket connectionSocket;

    public Address() {
    }

    public void  get(ServerSocket serversocket) throws IOException {
        connectionSocket = serversocket.accept();
           InetAddress client = connectionSocket.getInetAddress();
           System.out.println(client);
       }
    public void read() throws IOException {
        BufferedReader input =
                new BufferedReader(new InputStreamReader(connectionSocket.
                        getInputStream()));
        System.out.println(input.readLine());
    }

    public void write() throws IOException {
        DataOutputStream output =
                new DataOutputStream(connectionSocket.getOutputStream());
        output.writeBytes("not found");
    }


}
