package mindswap.academy.sims.menuhandler;

import mindswap.academy.sims.handlers.ActivityHandler;
import mindswap.academy.sims.handlers.HouseHandler;
import mindswap.academy.sims.handlers.RoomMenuHandler;
import mindswap.academy.sims.maid.Maid;
import mindswap.academy.sims.messages.Messages;
import mindswap.academy.sims.player.SimsChar;

public class Buy implements MenuHandler{
    @Override
    public void execute(SimsChar simsChar, HouseHandler houseHandler, RoomMenuHandler roomMenuHandler, ActivityHandler activityHandler, Maid maid) {
        if(houseHandler.buy()){
            simsChar.getPh().sendMessage(Messages.BUY_HOUSE);
            simsChar.decreaseMoney(simsChar.getHouse().getPrice());
            return;
        }
        simsChar.getPh().sendMessage(Messages.ALREADY_HAVE_HOUSE);
    }
}
