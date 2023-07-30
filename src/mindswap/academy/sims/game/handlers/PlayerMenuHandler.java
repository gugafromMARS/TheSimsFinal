package mindswap.academy.sims.game.handlers;

import mindswap.academy.sims.game.maid.Maid;
import mindswap.academy.sims.game.menuhandler.Menu;
import mindswap.academy.sims.game.messages.Messages;
import mindswap.academy.sims.game.player.SimsChar;
import mindswap.academy.sims.server.PlayerHandler;
import mindswap.academy.sims.server.Server;

public class PlayerMenuHandler {

    private PlayerHandler playerHandler;
    private SimsChar simsChar;
    private HouseHandler houseHandler;
    private RoomMenuHandler roomMenuHandler;
    private ActivityHandler activityHandler;
    private Maid maid;

    public PlayerMenuHandler(PlayerHandler playerHandler, HouseHandler houseHandler, SimsChar simsChar, Maid maid) {
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
        for (Menu v: Menu.values()) {
                if(option.trim().toUpperCase().equals(v.toString())) {
                    v.getMenuHandler().execute(simsChar, houseHandler,roomMenuHandler,activityHandler,maid);
                    playerMenu();
                }
        }
        simsChar.getPlayerHandler().sendMessage(Messages.WRONG_OPTION);
        playerMenu();
    }
}
