package mindswap.academy.sims.menuhandler;

import mindswap.academy.sims.handlers.HouseHandler;
import mindswap.academy.sims.messages.Messages;
import mindswap.academy.sims.player.SimsChar;

public class Buy implements MenuHandler{
    @Override
    public void execute(SimsChar simsChar, HouseHandler houseHandler) {
        if(houseHandler.buy()){
            simsChar.getPh().sendMessage(Messages.BUY_HOUSE);
            return;
        }
        simsChar.getPh().sendMessage(Messages.ALREADY_HAVE_HOUSE);
    }
}
