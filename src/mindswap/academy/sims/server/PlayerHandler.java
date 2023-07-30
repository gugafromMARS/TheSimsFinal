package mindswap.academy.sims.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class PlayerHandler {

    private Socket clientSocket;
    private BufferedReader in;
    private PrintWriter out;
    private String username;
    private boolean isRunning = true;

    public PlayerHandler(Socket clientSocket) {
        this.clientSocket = clientSocket;
        startBuffers();
    }

    private void startBuffers() {
        try {
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            out = new PrintWriter(clientSocket.getOutputStream(), true);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void sendMessage(String message) {
        out.println(message);
    }

    public String readMessageFromPlayer() {
        String message = null;
        try {
            message = in.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return message;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void closeConnection() {
        try {
            clientSocket.close();
            isRunning = false;
            System.out.println("Client disconnected!");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
