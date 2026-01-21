package com.pl.premier_zone.network;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UdpClientTest {
    public static void main(String[] args) {
        // Używamy try-with-resources, aby gniazdo zamknęło się automatycznie
        try (DatagramSocket socket = new DatagramSocket()) {
            InetAddress address = InetAddress.getByName("localhost");
            int port = 9999;

            // 1. Przygotowanie i wysłanie zapytania
            String message = "GET_COUNT";
            byte[] sendData = message.getBytes();
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, address, port);

            System.out.println("Sending request to UDP Server: " + message);
            socket.send(sendPacket);

            // 2. Odbieranie odpowiedzi (opcjonalne, jeśli serwer odsyła dane)
            byte[] receiveBuffer = new byte[1024];
            DatagramPacket receivePacket = new DatagramPacket(receiveBuffer, receiveBuffer.length);

            // Ustawiamy timeout, żeby klient nie czekał wiecznie, jeśli serwer nie odpowie
            socket.setSoTimeout(3000);

            try {
                socket.receive(receivePacket);
                String response = new String(receivePacket.getData(), 0, receivePacket.getLength());
                System.out.println("Response from Server: " + response);
            } catch (java.net.SocketTimeoutException e) {
                System.out.println("No response from server (timeout) - check if UdpServer sends data back.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}