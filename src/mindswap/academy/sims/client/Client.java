package mindswap.academy.sims.client;

import mindswap.academy.sims.game.messages.Messages;

import java.io.*;
import java.net.Socket;

public class Client {
    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;

    public static void main(String[] args) {
        Client client = new Client();
        client.startReader();
        client.handleClient();
    }

    private void startReader() {
        in = new BufferedReader(new InputStreamReader(System.in));
    }

    private void handleClient() {
        connectToServer();
        startListeningServer();
        communicateWithServer();
    }

    private void connectToServer() {
        String host = "localhost";
        int port = 8080;
        try {
            socket = new Socket(host, port);
            out = new PrintWriter(socket.getOutputStream(), true);
        } catch (IOException e) {
            System.out.println(Messages.SERVER_DEAD);
            connectToServer();
        }
    }

    private void startListeningServer() {
        new Thread(new ServerListener(socket)).start();
    }

    private void communicateWithServer() {
        try {
            sendMessage();
            communicateWithServer();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void sendMessage() throws IOException {
        String message = in.readLine();
        out.println(message);
    }


    private class ServerListener implements Runnable {

        private Socket clientSocket;
        private  BufferedReader in;

        public ServerListener(Socket clientSocket) {
            this.clientSocket = clientSocket;
            startBuffer();
        }

        private void startBuffer() {
            try {
                in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        @Override
        public void run() {
            try {
                readFromServer();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }

        private void readFromServer() throws IOException {
            String message = in.readLine();
            if(message == null) {
                System.out.println("Disconnected!");
                System.exit(1);
            }
            System.out.println(message);
            readFromServer();
        }
    }

}
