package mindswap.academy.sims.menuhandler;

import mindswap.academy.sims.handlers.HouseHandler;
import mindswap.academy.sims.handlers.RoomMenuHandler;
import mindswap.academy.sims.messages.Messages;
import mindswap.academy.sims.player.SimsChar;

public class Move implements MenuHandler{

    @Override
    public void execute(SimsChar simsChar, HouseHandler houseHandler, RoomMenuHandler roomMenuHandler) {
        if(simsChar.haveHouse()){
            roomMenuHandler.menu();
            return;
        }
        simsChar.getPh().sendMessage(Messages.NO_HOUSE);
    }
}
