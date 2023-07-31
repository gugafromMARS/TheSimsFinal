package mindswap.academy.sims.game.maid;

import mindswap.academy.sims.game.exceptions.DontHaveHouseException;
import mindswap.academy.sims.game.houses.rooms.Room;
import mindswap.academy.sims.game.messages.MessageHandler;
import mindswap.academy.sims.game.messages.Messages;
import mindswap.academy.sims.game.player.SimsChar;

public class Maid {

    private MessageHandler messageHandler;
    private String name;
    private double price;

    public Maid() {
        name = "Maria";
        price = 500.0;
        messageHandler = new MessageHandler();
    }
    public void cleanHouseFor(SimsChar simsChar) {
        try {
            if(simsChar.getWallet() >= 500) {
                simsChar.getHouse().setLevelOfCleanness(simsChar.getHouse().getMaxOfCleanness());
                for (Room room: simsChar.getHouse().getRooms()) {
                    room.setLevelOfCleanliness(100);
                }
                simsChar.decreaseMoney(price);
                simsChar.getPlayerHandler().sendMessage(messageHandler.manageMessage("src/mindswap/academy/sims/game/messages/resources/maid.txt"));
                return;
            }
            simsChar.getPlayerHandler().sendMessage(Messages.NO_MONEY);
        } catch (DontHaveHouseException e) {
            System.out.println(e.getMessage());
        }
    }
}
