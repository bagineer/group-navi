package com.example.connect;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

public class MainActivity extends AppCompatActivity {

    private static final String host = "192.168.1.4";
    private static final int port = 8080;

    private Socket s;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        s = new Socket();
        InetSocketAddress addr = new InetSocketAddress(host, port);
        MyThread thread = new MyThread(addr);
        thread.setDaemon(true);
        thread.start();
    }

    class MyThread extends Thread {

        InetSocketAddress addr;

        public MyThread(InetSocketAddress address) {
            addr = address;
        }

        @Override
        public void run() {
            try {
                s.connect(addr);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}