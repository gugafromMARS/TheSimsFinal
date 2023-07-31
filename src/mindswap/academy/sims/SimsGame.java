package mindswap.academy.sims;

import mindswap.academy.sims.game.handlers.HouseHandler;
import mindswap.academy.sims.game.handlers.PlayerMenuHandler;
import mindswap.academy.sims.game.handlers.UsernameHandler;
import mindswap.academy.sims.game.maid.Maid;
import mindswap.academy.sims.game.messages.MessageHandler;
import mindswap.academy.sims.game.messages.Messages;
import mindswap.academy.sims.game.player.SimsChar;
import mindswap.academy.sims.server.PlayerHandler;
import mindswap.academy.sims.server.Server;

public class SimsGame implements Game, Runnable{

    private MessageHandler messageHandler;
    private PlayerHandler playerHandler;
    private SimsChar simsChar;
    private UsernameHandler usernameHandler;
    private PlayerMenuHandler playerMenuHandler;
    private HouseHandler houseHandler;
    private Maid maid;
    private boolean isPlaying = true;

    public SimsGame(PlayerHandler playerHandler) {
        this.playerHandler = playerHandler;
        simsChar = null;
        usernameHandler = null;
        maid = new Maid();
    }

    @Override
    public void startGame() {
        greetPlayer();
        createUsername();
        play();
    }

    private void play(){
        while (isPlaying) {
            playerMenuHandler.playerMenu();
            isPlaying = false;
        }
    }
    @Override
    public void greetPlayer() {
        playerHandler.sendMessage(messageHandler.manageMessage("src/mindswap/academy/sims/game/messages/resources/welcome.txt"));
    }
    private void createUsername() {
        usernameHandler.createUsername();
    }

    private void startHandlers() {
        usernameHandler = new UsernameHandler(playerHandler);
        houseHandler = new HouseHandler(simsChar);
        playerMenuHandler = new PlayerMenuHandler(playerHandler, houseHandler, simsChar, maid);
        messageHandler = new MessageHandler();
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
