package mindswap.academy.sims.menuhandler;

import mindswap.academy.sims.handlers.HouseHandler;
import mindswap.academy.sims.player.SimsChar;

public interface MenuHandler {

    void execute(SimsChar simsChar, HouseHandler houseHandler);
}
