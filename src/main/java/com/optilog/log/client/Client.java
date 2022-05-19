package com.optilog.log.client;

import com.optilog.log.Optilog;

import java.io.IOException;
import java.net.*;

public class Client {
    public static DatagramSocket ddd;
    
    public Client() {
    }
    
    public static void startClient(Optilog instance) {
        if (instance.allSetting.startClient) {
            try {
                ddd = new DatagramSocket();
                ddd.setSoTimeout(1000);
                ddd.connect(InetAddress.getByName("localhost"), instance.allSetting.socketNumber);
            } catch (UnknownHostException | SocketException var1) {
                var1.printStackTrace();
            }
        }
        
    }
    
    public static void send(String msg) {
        try {
            byte[] data = msg.getBytes();
            DatagramPacket packet = new DatagramPacket(data, data.length);
            ddd.send(packet);
        } catch (IOException var3) {
            var3.printStackTrace();
        }
        
    }
}
