package mindswap.academy.sims.game.menuhandler.menuoptions;

import mindswap.academy.sims.game.handlers.ActivityHandler;
import mindswap.academy.sims.game.handlers.HouseHandler;
import mindswap.academy.sims.game.handlers.RoomMenuHandler;
import mindswap.academy.sims.game.maid.Maid;
import mindswap.academy.sims.game.menuhandler.MenuHandler;
import mindswap.academy.sims.game.messages.MessageHandler;
import mindswap.academy.sims.game.messages.Messages;
import mindswap.academy.sims.game.player.SimsChar;

public class Quit implements MenuHandler {

    private MessageHandler messageHandler;

    public Quit() {
        messageHandler = new MessageHandler();
    }

    @Override
    public void execute(SimsChar simsChar, HouseHandler houseHandler, RoomMenuHandler roomMenuHandler, ActivityHandler activityHandler, Maid maid) {
        simsChar.getPlayerHandler().sendMessage(messageHandler.manageMessage("src/mindswap/academy/sims/game/messages/resources/quit.txt"));
        simsChar.getPlayerHandler().closeConnection();
    }
}
