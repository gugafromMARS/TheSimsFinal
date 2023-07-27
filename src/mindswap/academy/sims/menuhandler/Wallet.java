package mindswap.academy.sims.menuhandler;

import mindswap.academy.sims.handlers.ActivityHandler;
import mindswap.academy.sims.handlers.HouseHandler;
import mindswap.academy.sims.handlers.RoomMenuHandler;
import mindswap.academy.sims.maid.Maid;
import mindswap.academy.sims.player.SimsChar;

public class Wallet implements MenuHandler {


    @Override
    public void execute(SimsChar simsChar, HouseHandler houseHandler, RoomMenuHandler roomMenuHandler, ActivityHandler activityHandler, Maid maid) {
        simsChar.getPh().sendMessage("-".repeat(10) + " WALLET " + "-".repeat(12) + "\n" +
                "YOU HAVE " + simsChar.getWallet() + "$ IN YOUR WALLET!\n");
    }
}
