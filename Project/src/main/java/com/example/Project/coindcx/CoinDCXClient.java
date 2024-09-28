package com.example.Project.coindcx;

import org.cloudinary.json.JSONObject;
import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;
import java.net.URI;
import java.util.Scanner;

public class CoinDCXClient extends WebSocketClient {

    private double triggerPrice;

    // Constructor to initialize WebSocketClient with a WebSocket URL
    public CoinDCXClient(URI serverUri) {
        super(serverUri);
    }

    @Override
    public void onOpen(ServerHandshake handshakedata) {
        System.out.println("Connected to WebSocket!");
        // Emit a 'join' message to subscribe to the orderbook
        JSONObject joinMessage = new JSONObject();
        joinMessage.put("channelName", "B-BTC_USDT@orderbook@20");
        send(joinMessage.toString());
    }

    @Override
    public void onMessage(String message) {
        // Process 'depth-update' messages from the WebSocket server
        System.out.println("Received depth-update: " + message);

        // Display prepared payload based on the trigger price
        JSONObject marketData = new JSONObject(message);
        double marketPrice = marketData.getDouble("price"); // Adjust based on actual structure
        displayPayload(marketPrice);
    }

    @Override
    public void onClose(int code, String reason, boolean remote) {
        System.out.println("WebSocket closed: " + reason);
    }

    @Override
    public void onError(Exception ex) {
        System.err.println("WebSocket Error: " + ex.getMessage());
        ex.printStackTrace();
    }

    // Method to display the prepared payload based on the trigger price
    private void displayPayload(double marketPrice) {
        System.out.println("Market Price: " + marketPrice);

        if (marketPrice <= triggerPrice) {
            System.out.println("Prepared Buy Payload: {\"type\":\"buy\", \"price\":" + marketPrice + "}");
        } else if (marketPrice >= triggerPrice) {
            System.out.println("Prepared Sell Payload: {\"type\":\"sell\", \"price\":" + marketPrice + "}");
        } else {
            System.out.println("No action required for the current market price.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter trigger price: ");
        double triggerPrice = scanner.nextDouble();

        try {
            URI serverUri = new URI("wss://stream.coindcx.com");
            CoinDCXClient client = new CoinDCXClient(serverUri);
            client.triggerPrice = triggerPrice; // Set the trigger price
            client.connect();

            // Keep the client running and listen for depth updates
            while (client.isOpen()) {
                Thread.sleep(1000); // Keep the connection alive
            }

        } catch (Exception e) {
            System.err.println("Error connecting to the server: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
