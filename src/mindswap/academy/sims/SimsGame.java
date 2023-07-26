package mindswap.academy.sims;

import mindswap.academy.sims.handlers.HouseHandler;
import mindswap.academy.sims.handlers.PlayerMenuHandler;
import mindswap.academy.sims.handlers.UsernameHandler;
import mindswap.academy.sims.messages.Messages;
import mindswap.academy.sims.player.SimsChar;
import mindswap.academy.sims.server.Server;

public class SimsGame implements Game, Runnable{

    private Server.PlayerHandler playerHandler;
    private SimsChar simsChar;
    private UsernameHandler usernameHandler;
    private PlayerMenuHandler playerMenuHandler;
    private HouseHandler houseHandler;

    private boolean isPlaying = true;

    public SimsGame(Server.PlayerHandler playerHandler) {
        this.playerHandler = playerHandler;
        simsChar = null;
        usernameHandler = null;
    }

    @Override
    public void startGame() {
        greetPlayer();
        createUsername();

        while (isPlaying) {
            playerMenuHandler.playerMenu();
            isPlaying = false;
        }
        finishGame();
    }
    @Override
    public void greetPlayer() {
        playerHandler.sendMessage(Messages.WELCOME);
    }
    private void createUsername() {
        usernameHandler.createUsername();
    }

    private void startHandlers() {
        usernameHandler = new UsernameHandler(playerHandler);
        houseHandler = new HouseHandler(simsChar);
        playerMenuHandler = new PlayerMenuHandler(playerHandler, houseHandler, simsChar);

    }

    @Override
    public void finishGame() {
        System.out.println("Game ended");
    }

    @Override
    public void run() {
        simsChar = new SimsChar(playerHandler);
        startHandlers();
        startGame();
        finishGame();
    }
}
