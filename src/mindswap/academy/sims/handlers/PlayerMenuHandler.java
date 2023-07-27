package mindswap.academy.sims.handlers;

import mindswap.academy.sims.maid.Maid;
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
    private Maid maid;

    public PlayerMenuHandler(Server.PlayerHandler playerHandler, HouseHandler houseHandler, SimsChar simsChar, Maid maid) {
        this.playerHandler = playerHandler;
        this.houseHandler = houseHandler;
        this.simsChar = simsChar;
        roomMenuHandler = new RoomMenuHandler(simsChar);
        activityHandler = new ActivityHandler(simsChar, roomMenuHandler);
        this.maid = maid;
    }

    public void playerMenu(){
        playerHandler.sendMessage("-".repeat(30) +"\n" +playerHandler.getUsername() + " " + Messages.OPTIONS_MENU);
        String option = playerHandler.readMessageFromPlayer();
        switch (option.trim().toUpperCase()) {
            case "BUY" -> {
                Menu.BUY.getMenuHandler().execute(simsChar, houseHandler, roomMenuHandler, activityHandler, maid);
                playerMenu();
            }
            case "MOVE" -> {
                Menu.MOVE.getMenuHandler().execute(simsChar, houseHandler, roomMenuHandler, activityHandler, maid);
                playerMenu();
            }
            case "STATS" ->{
                Menu.STATS.getMenuHandler().execute(simsChar, houseHandler, roomMenuHandler, activityHandler, maid);
                playerMenu();
            }
            case "CLEAN"->{
                Menu.CLEAN.getMenuHandler().execute(simsChar, houseHandler, roomMenuHandler, activityHandler, maid);
                playerMenu();
            }
            case "WALLET"->{
                Menu.WALLET.getMenuHandler().execute(simsChar, houseHandler, roomMenuHandler, activityHandler, maid);
                playerMenu();
            }
            case "QUIT" -> Menu.QUIT.getMenuHandler().execute(simsChar, houseHandler, roomMenuHandler, activityHandler, maid);
            default -> {
                Menu.DO.getMenuHandler().execute(simsChar, houseHandler, roomMenuHandler, activityHandler, maid);
                playerMenu();
            }
        }
    }
}
