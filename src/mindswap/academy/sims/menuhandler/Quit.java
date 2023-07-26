package mindswap.academy.sims.menuhandler;

import mindswap.academy.sims.handlers.HouseHandler;
import mindswap.academy.sims.messages.Messages;
import mindswap.academy.sims.player.SimsChar;

public class Quit implements MenuHandler{
    @Override
    public void execute(SimsChar simsChar, HouseHandler houseHandler) {
        simsChar.getPh().sendMessage(Messages.FINISH_GAME);
        simsChar.getPh().closeConnection();
    }
}
