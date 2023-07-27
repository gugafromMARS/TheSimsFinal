package mindswap.academy.sims.handlers;

import mindswap.academy.sims.menuhandler.Menu;
import mindswap.academy.sims.messages.Messages;
import mindswap.academy.sims.player.SimsChar;
import mindswap.academy.sims.server.Server;

public class PlayerMenuHandler {

    private Server.PlayerHandler playerHandler;
    private SimsChar simsChar;
    private HouseHandler houseHandler;
    private RoomMenuHandler roomMenuHandler;
    private ActivityHandler activityHandler;


    public PlayerMenuHandler(Server.PlayerHandler playerHandler, HouseHandler houseHandler, SimsChar simsChar) {
        this.playerHandler = playerHandler;
        this.houseHandler = houseHandler;
        this.simsChar = simsChar;
        roomMenuHandler = new RoomMenuHandler(simsChar);
        activityHandler = new ActivityHandler(simsChar, roomMenuHandler);
    }

    public void playerMenu(){
        playerHandler.sendMessage(playerHandler.getUsername() + " " + Messages.OPTIONS_MENU);
        String option = playerHandler.readMessageFromPlayer();
        switch (option.trim()) {
//            clean
            case "buy" -> {
                Menu.BUY.getMenuHandler().execute(simsChar, houseHandler, roomMenuHandler, activityHandler);
                playerMenu();
            }
            case "move" -> {
                Menu.MOVE.getMenuHandler().execute(simsChar, houseHandler, roomMenuHandler, activityHandler);
                playerMenu();
            }
            case "stats" ->{
                Menu.STATS.getMenuHandler().execute(simsChar, houseHandler, roomMenuHandler, activityHandler);
                playerMenu();
            }
            case "quit" -> Menu.QUIT.getMenuHandler().execute(simsChar, houseHandler, roomMenuHandler, activityHandler);
            default -> {
                Menu.DO.getMenuHandler().execute(simsChar, houseHandler, roomMenuHandler, activityHandler);
                playerMenu();
            }
        }
    }
}
