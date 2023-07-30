package mindswap.academy.sims.game.menuhandler.menuoptions;

import mindswap.academy.sims.game.handlers.ActivityHandler;
import mindswap.academy.sims.game.handlers.HouseHandler;
import mindswap.academy.sims.game.handlers.RoomMenuHandler;
import mindswap.academy.sims.game.maid.Maid;
import mindswap.academy.sims.game.menuhandler.MenuHandler;
import mindswap.academy.sims.game.player.SimsChar;

public class Wallet implements MenuHandler {


    @Override
    public void execute(SimsChar simsChar, HouseHandler houseHandler, RoomMenuHandler roomMenuHandler, ActivityHandler activityHandler, Maid maid) {
        simsChar.getPlayerHandler().sendMessage("-".repeat(10) + " WALLET " + "-".repeat(12) + "\n" +
                "YOU HAVE " + simsChar.getWallet() + "$ IN YOUR WALLET!\n");
    }
}
