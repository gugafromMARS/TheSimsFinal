package mindswap.academy.sims.server;

import mindswap.academy.sims.Game;
import mindswap.academy.sims.SimsGame;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {

    private ServerSocket serverSocket;
    private PlayerHandler playerHandler;

    public static void main(String[] args) {
        Server server = new Server();
        server.start(8080);
        server.acceptClients();
    }

    private void start(int port) {
        try {
            serverSocket = new ServerSocket(port);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.printf("Server start running on port %d \n", port);
    }


    private void acceptClients() {
        try {
            Socket clientSocket = serverSocket.accept(); //blocking method!
            System.out.println("New client connected!");
            managePlayerHandler(clientSocket);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        acceptClients();
    }

    private void managePlayerHandler(Socket clientSocket){
        playerHandler = new PlayerHandler(clientSocket);
        ExecutorService service = Executors.newCachedThreadPool();
        service.submit(playerHandler);
        service.submit(new SimsGame(playerHandler));
        playerHandler = null;
    }

    public class PlayerHandler implements Runnable {

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

        @Override
        public void run() {
            while (isRunning){

            }
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

}
