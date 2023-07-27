package mindswap.academy.sims.maid;

import mindswap.academy.sims.exceptions.DontHaveHouse;
import mindswap.academy.sims.houses.rooms.Room;
import mindswap.academy.sims.messages.Messages;
import mindswap.academy.sims.player.SimsChar;

public class Maid {

    private String name;
    private double price;

    public Maid() {
        name = "Maria";
        price = 500.0;
    }

    public void cleanHouseFor(SimsChar simsChar) {
        try {
            simsChar.getHouse().setLevelOfCleanness(simsChar.getHouse().getMaxOfCleanness());
            for (Room room: simsChar.getHouse().getRooms()) {
                room.setLevelOfCleanliness(100);
            }
            simsChar.decreaseMoney(price);
            simsChar.getPh().sendMessage(Messages.MAID_CLEANING);
        } catch (DontHaveHouse e) {
            System.out.println(e.getMessage());
        }
    }
}
