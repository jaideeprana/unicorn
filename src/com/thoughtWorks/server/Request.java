package com.thoughtWorks.server;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;


public class Request {
    private Socket connectionSocket;

    public String getClientIp(ServerSocket serversocket) throws IOException {
        connectionSocket = serversocket.accept();
        InetAddress clientAddress = connectionSocket.getInetAddress();
        return String.valueOf(clientAddress);
    }
}
