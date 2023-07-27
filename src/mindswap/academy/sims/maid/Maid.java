package mindswap.academy.sims.maid;

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
        simsChar.getHouse().setLevelOfCleanness(simsChar.getHouse().getMaxOfCleanness());
        simsChar.getPh().sendMessage(Messages.MAID_CLEANING);
    }
}
