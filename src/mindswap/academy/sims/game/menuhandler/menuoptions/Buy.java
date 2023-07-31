package mindswap.academy.sims.game.menuhandler.menuoptions;

import mindswap.academy.sims.game.handlers.ActivityHandler;
import mindswap.academy.sims.game.exceptions.DontHaveHouseException;
import mindswap.academy.sims.game.handlers.HouseHandler;
import mindswap.academy.sims.game.handlers.RoomMenuHandler;
import mindswap.academy.sims.game.maid.Maid;
import mindswap.academy.sims.game.menuhandler.MenuHandler;
import mindswap.academy.sims.game.messages.MessageHandler;
import mindswap.academy.sims.game.messages.Messages;
import mindswap.academy.sims.game.player.SimsChar;

public class Buy implements MenuHandler {

    private MessageHandler messageHandler;

    public Buy() {
        messageHandler = new MessageHandler();
    }

    @Override
    public void execute(SimsChar simsChar, HouseHandler houseHandler, RoomMenuHandler roomMenuHandler, ActivityHandler activityHandler, Maid maid) {
        try{
            if(houseHandler.buy()){
                simsChar.getPlayerHandler().sendMessage(messageHandler.manageMessage("src/mindswap/academy/sims/game/messages/resources/buyhouse.txt"));
                simsChar.decreaseMoney(simsChar.getHouse().getPrice());
                return;
            }
            simsChar.getPlayerHandler().sendMessage(Messages.ALREADY_HAVE_HOUSE);
        } catch (DontHaveHouseException e) {
            System.out.println(e.getMessage());
        }

    }
}
