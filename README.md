# CoinDCX-WebSocket-API
## Features
- Connects to the CoinDCX WebSocket API for real-time market data.
- Allows users to input a trigger price via CLI.
- Displays prepared buy/sell payloads based on the current market price and trigger price.

## Prerequisites
- Java Development Kit (JDK) 8 or higher.
- Apache Maven (for dependency management and building the project).

 ## Usage
When prompted, enter the trigger price you wish to monitor.
The application will connect to the CoinDCX WebSocket API and listen for depth updates.
It will display the current market price and the prepared buy/sell payload based on the trigger price.

## Design Decisions
The application utilizes the Java-WebSocket library for establishing a WebSocket connection and handling messages. This library is lightweight and provides a simple API for WebSocket operations.
JSON is used for message formatting and parsing, which allows for easy handling of market data received from the CoinDCX API.
The design follows the Model-View-Controller (MVC) pattern to some extent, separating the WebSocket client logic and user input handling.
A CLI interface is implemented for simplicity, providing immediate feedback for monitoring real-time market data without the overhead of a graphical user interface.

### Customization:
- Make sure to replace `https://github.com/yourusername/CoinDCXWebSocketClient.git` with the actual URL of your GitHub repository.

## Libraries Used
Java-WebSocket: A Java library for WebSocket client and server implementations.
JSON: A simple library for parsing and creating JSON objects.
Contributing
Contributions are welcome! Please submit a pull request or open an issue to discuss improvements or bugs.
