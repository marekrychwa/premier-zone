package com.pl.premier_zone.network;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

@Component
public class UdpServer {

    @PostConstruct
    public void startUdpServer() {
        new Thread(() -> {
            try (DatagramSocket socket = new DatagramSocket(9999)) {
                System.out.println("UDP server started on port 9999");

                byte[] buffer = new byte[1024];

                while (true) {
                    DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
                    socket.receive(packet);

                    String message = new String(
                            packet.getData(),
                            0,
                            packet.getLength()
                    );

                    System.out.println("Received UDP message: " + message);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
    }
}