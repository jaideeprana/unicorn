package com.thoughtWorks.server;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Response {
    private DataOutputStream dataOutputStream;
    private DataInputStream dataInputStream;

    public List<String> sendResponse(String filePath,Socket socket) throws IOException {
        return write(filePath,socket);
    }

    private List<String> write(String filePath,Socket socket) throws IOException {
        dataOutputStream= new DataOutputStream(socket.getOutputStream());

        FileInputStream fileInputStream = new FileInputStream(filePath);
        dataInputStream = new DataInputStream(fileInputStream);
        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(dataInputStream));
        List<String> lines= new ArrayList<String>();
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            lines.add(line);

            dataOutputStream.writeBytes(line);
        }
        dataInputStream.close();
        dataOutputStream.close();

        return lines;
    }

}
