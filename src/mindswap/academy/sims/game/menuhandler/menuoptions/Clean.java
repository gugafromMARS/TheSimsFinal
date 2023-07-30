package mindswap.academy.sims.game.menuhandler.menuoptions;

import mindswap.academy.sims.game.exceptions.HouseDontExistException;
import mindswap.academy.sims.game.handlers.ActivityHandler;
import mindswap.academy.sims.game.handlers.HouseHandler;
import mindswap.academy.sims.game.handlers.RoomMenuHandler;
import mindswap.academy.sims.game.maid.Maid;
import mindswap.academy.sims.game.menuhandler.MenuHandler;
import mindswap.academy.sims.game.messages.Messages;
import mindswap.academy.sims.game.player.SimsChar;

public class Clean implements MenuHandler {


    @Override
    public void execute(SimsChar simsChar, HouseHandler houseHandler, RoomMenuHandler roomMenuHandler, ActivityHandler activityHandler, Maid maid) {
        try {
            if(simsChar.haveHouse()) {
                maid.cleanHouseFor(simsChar);
                return;
            }
            simsChar.getPlayerHandler().sendMessage(Messages.NO_HOUSE);
            } catch (HouseDontExistException e) {
            System.out.println(e.getMessage());;
        }
    }

}
