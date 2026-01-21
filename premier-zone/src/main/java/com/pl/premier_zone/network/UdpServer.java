package com.pl.premier_zone.network;

import com.pl.premier_zone.player.PlayerRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

@Component
public class UdpServer {

    private final PlayerRepository playerRepository;

    public UdpServer(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    @PostConstruct
    public void startUdpServer() {
        new Thread(() -> {
            try (DatagramSocket socket = new DatagramSocket(9999)) {
                System.out.println("UDP server started on port 9999");

                byte[] buffer = new byte[1024];

                while (true) {
                    // Odbieranie pakietu
                    DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
                    socket.receive(packet);

                    String message = new String(packet.getData(), 0, packet.getLength()).trim();
                    System.out.println("Received UDP message: " + message);

                    // Logika odpowiedzi
                    if ("GET_COUNT".equalsIgnoreCase(message)) {
                        long count = playerRepository.count();
                        String response = "Total players in DB: " + count;
                        byte[] responseData = response.getBytes();

                        // Wysyłamy odpowiedź z powrotem do nadawcy
                        DatagramPacket responsePacket = new DatagramPacket(
                                responseData,
                                responseData.length,
                                packet.getAddress(),
                                packet.getPort()
                        );
                        socket.send(responsePacket);
                        System.out.println("Sent response: " + response);
                    }
                }
            } catch (Exception e) {
                System.err.println("UDP Server Error: " + e.getMessage());
            }
        }).start();
    }
}