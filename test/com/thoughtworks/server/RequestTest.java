package com.thoughtworks.server;

import com.thoughtWorks.server.Request;
import org.hamcrest.core.IsEqual;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.net.ServerSocket;

import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class RequestTest {

    private Request request;
    private ServerSocket serverSocket;

    @Before
    public void setUp() throws IOException {
        serverSocket = new ServerSocket(8080);
        this.request = new Request();
    }

    @After
    public void tearDown() throws IOException {
        serverSocket.close();
    }

    @Test
    public void shouldReturnIpAddressOfClient() throws IOException {
        Request mockRequest= Mockito.mock(Request.class);
        when(mockRequest.getClientIp(serverSocket)).thenReturn("/127.0.0.1");
        assertThat(String.valueOf(mockRequest.getClientIp(serverSocket)), IsEqual.equalTo("/127.0.0.1"));
        verify(mockRequest).getClientIp(serverSocket);
    }


}
