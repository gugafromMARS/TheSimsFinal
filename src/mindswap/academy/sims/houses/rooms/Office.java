package mindswap.academy.sims.houses.rooms;

import mindswap.academy.sims.exceptions.DontHaveHouse;
import mindswap.academy.sims.messages.Messages;
import mindswap.academy.sims.player.SimsChar;

public class Office extends Room {


    @Override
    public void execute(SimsChar simsChar) {
        try {
            if(simsChar.getEnergyLevel() >= 20){
                if(simsChar.getHouse().getLevelOfCleanness() >= 100 && getLevelOfCleanliness() >= 20){
                    simsChar.consumeEnergy(20);
                    simsChar.getPh().sendMessage(Messages.WORK);
                    simsChar.increaseMoney(200);
                    decreaseCleanness(50);
                    simsChar.getHouse().decreaseCleanness(20);
                    return;
                }
                simsChar.getPh().sendMessage(Messages.YOU_CANT_USE_ROOM);
                return;
            }
            simsChar.getPh().sendMessage(Messages.YOU_NEED_TO_REST);
        } catch (DontHaveHouse e) {
            System.out.println(e.getMessage());
        }

    }


}
