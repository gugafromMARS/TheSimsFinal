package mindswap.academy.sims.houses.rooms;

import mindswap.academy.sims.messages.Messages;
import mindswap.academy.sims.player.SimsChar;

public class Kitchen implements Room {


    @Override
    public void execute(SimsChar simsChar) {
        simsChar.getPh().sendMessage(Messages.COOKING);
    }

    @Override
    public void setLevelOfCleanliness(int cleanliness) {

    }

    @Override
    public int getLevelOfCleanliness() {
        return 0;
    }
}
