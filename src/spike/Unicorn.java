package spike;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Unicorn {
    public static void main(String[] args) {
        ServerSocket serverSocket;
        try {
            serverSocket = new ServerSocket(8080);
            Socket clientSocket = null;
            try {
                clientSocket = serverSocket.accept();
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                BufferedReader in =
                        new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                String inputLine, outputLine;

            }
            catch (IOException e) {
                System.out.println("Accept failed: 4444");
                System.exit(-1);
            }
        }
        catch (IOException e) {
            System.out.println("Could not listen on port: 4444");
            System.exit(-1);
        }
    }
}
