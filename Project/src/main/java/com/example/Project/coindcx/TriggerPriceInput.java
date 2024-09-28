package com.example.Project.coindcx;

import java.net.URI;
import java.util.Scanner;

public class TriggerPriceInput {

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter trigger price: ");
        double triggerPrice = scanner.nextDouble();
        System.out.println("Trigger Price set to: " + triggerPrice);

        // Connect to WebSocket and handle real-time market data
        CoinDCXClient client = new CoinDCXClient(new URI("wss://coindcx.com/api/socket"));
        client.connect();

        // The client will handle market data and trigger order payloads based on the trigger price
    }
}
