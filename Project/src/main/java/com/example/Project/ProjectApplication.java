package com.example.Project;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.net.URI;
import com.example.Project.coindcx.CoinDCXClient;

@SpringBootApplication
public class ProjectApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ProjectApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Running WebSocket connection...");
		CoinDCXClient client = new CoinDCXClient(new URI("wss://stream.coindcx.com"));
		client.connect();
	}
}
