package mindswap.academy.sims.menuhandler;

import mindswap.academy.sims.handlers.ActivityHandler;
import mindswap.academy.sims.handlers.HouseHandler;
import mindswap.academy.sims.handlers.RoomMenuHandler;
import mindswap.academy.sims.player.SimsChar;

public interface MenuHandler {

    void execute(SimsChar simsChar, HouseHandler houseHandler, RoomMenuHandler roomMenuHandler, ActivityHandler activityHandler);
}
