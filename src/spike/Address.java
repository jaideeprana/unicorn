package spike;


import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Address {
    private Socket connectionSocket;

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
        try{
            FileInputStream fileInputStream = new FileInputStream("./src/spike/a.html");
            DataInputStream dataInputStream = new DataInputStream(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(dataInputStream));
            String line;
            while ((line = bufferedReader.readLine()) != null)   {
                output.writeBytes(line);
            }
            dataInputStream.close();
        }
        catch (Exception e){
            System.err.println("Error: " + e.getMessage());
        }
    }
}
