package mindswap.academy.sims.handlers;

import mindswap.academy.sims.menuhandler.Menu;
import mindswap.academy.sims.messages.Messages;
import mindswap.academy.sims.player.SimsChar;
import mindswap.academy.sims.server.Server;

public class PlayerMenuHandler {

    private Server.PlayerHandler playerHandler;
    private SimsChar simsChar;
    private HouseHandler houseHandler;


    public PlayerMenuHandler(Server.PlayerHandler playerHandler, HouseHandler houseHandler, SimsChar simsChar) {
        this.playerHandler = playerHandler;
        this.houseHandler = houseHandler;
        this.simsChar = simsChar;
    }

    public void playerMenu(){
        playerHandler.sendMessage(playerHandler.getUsername() + " " + Messages.MENU);
        String option = playerHandler.readMessageFromPlayer();
        switch (option.trim()) {
            case "buy" -> {
                Menu.BUY.getMenuHandler().execute(simsChar, houseHandler);
                playerMenu();
            }
            case "move" -> {
                Menu.MOVE.getMenuHandler().execute(simsChar, houseHandler);
                playerMenu();
            }
            case "quit" -> Menu.QUIT.getMenuHandler().execute(simsChar, houseHandler);
            default -> {
                Menu.DO.getMenuHandler().execute(simsChar, houseHandler);
                playerMenu();
            }
        }
    }
}
