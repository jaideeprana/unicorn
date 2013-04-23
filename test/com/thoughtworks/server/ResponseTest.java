package com.thoughtworks.server;

import com.thoughtWorks.server.Response;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import static org.junit.Assert.assertTrue;

public class ResponseTest {

    private ServerSocket serverSocket;

    @Before
    public void setUp() throws IOException {
        serverSocket =new ServerSocket(8080);
    }

    @After
    public void tearDown() throws IOException {
        serverSocket.close();
    }
    @Test
    public void shouldReadFromFile() throws IOException {
        Response response = new Response();
        Socket socket=new Socket("localhost",8080);
        assertTrue(response.sendResponse("./src/spike/test.txt", socket).contains("sample page for test ."));
    }

    @Test (expected = FileNotFoundException.class)
    public void shouldThrowExceptionIfFileDoesNotExist() throws IOException {
        Response response = new Response();
        Socket socket=new Socket("localhost",8080);
        assertTrue(response.sendResponse("./src/spike/wrongFileName.txt", socket).contains("sample page for test ."));
    }
     @Test
    public void shouldReturnAllTheContentOfTheFile() throws IOException {
        Response response = new Response();
        Socket socket=new Socket("localhost",8080);
        assertTrue(response.sendResponse("./src/spike/test.txt", socket).contains("sample page for test ."));
    }

    @Test
    public void shouldReturnListIfFileHasMultipleLines() throws IOException {
        Response response = new Response();
        Socket socket=new Socket("localhost",8080);
        assertTrue(response.sendResponse("./src/spike/test.txt", socket).size()==4);
    }
}
