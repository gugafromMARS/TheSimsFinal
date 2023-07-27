package mindswap.academy.sims.menuhandler;

import mindswap.academy.sims.handlers.ActivityHandler;
import mindswap.academy.sims.handlers.HouseHandler;
import mindswap.academy.sims.handlers.RoomMenuHandler;
import mindswap.academy.sims.maid.Maid;
import mindswap.academy.sims.messages.Messages;
import mindswap.academy.sims.player.SimsChar;

public class Sell implements MenuHandler{

    @Override
    public void execute(SimsChar simsChar, HouseHandler houseHandler, RoomMenuHandler roomMenuHandler, ActivityHandler activityHandler, Maid maid) {
        if(simsChar.haveHouse()){
            simsChar.getPh().sendMessage(Messages.HOMELESS);
            simsChar.increaseMoney(simsChar.getHouse().getPrice());
            simsChar.getHouse().setOccupied(false);
            simsChar.setHouse(null);
            return;
        }
        simsChar.getPh().sendMessage(Messages.NO_HOUSE);
    }
}
