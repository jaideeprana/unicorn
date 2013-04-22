package com.thoughtWorks.server;

import org.junit.After;
import org.junit.Before;

import java.io.IOException;
import java.net.ServerSocket;

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

//    @Test
//    public void shouldReadFromFile() throws IOException {
//        Response response = new Response();
//        new Socket("localhost",8080);
//        assertTrue(response.sendResponse("./src/spike/test.txt", serverSocket).contains("sample page for test ."));
//    }
}
