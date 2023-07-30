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
        PlayerHandler playerHandler = new PlayerHandler(clientSocket);
        ExecutorService service = Executors.newCachedThreadPool();
        service.submit(new SimsGame(playerHandler));
    }
}
