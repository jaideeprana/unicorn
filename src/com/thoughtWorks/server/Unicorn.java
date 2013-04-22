package com.thoughtWorks.server;

import java.net.ServerSocket;
import java.net.Socket;

public class Unicorn {
    public static void main(String[] args) {
        try{
            ServerSocket serverSocket= new ServerSocket(9090);
            Request request=new Request();
            Socket socket=request.connect(serverSocket);
            request.read();
            Response response= new Response();
            response.sendResponse("./src/spike/index.html",socket);
            serverSocket.close();
        }
        catch(Exception e){
            System.out.println("connection not found");
        }
    }
}
