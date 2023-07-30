package mindswap.academy.sims.game.houses.rooms;

import mindswap.academy.sims.game.exceptions.DontHaveHouseException;
import mindswap.academy.sims.game.messages.Messages;
import mindswap.academy.sims.game.player.SimsChar;

public class Office extends Room {


    @Override
    public void execute(SimsChar simsChar) {
        try {
            if(simsChar.getEnergyLevel() >= 20){
                if(simsChar.getHouse().getLevelOfCleanness() >= 100 && getLevelOfCleanliness() >= 20){
                    simsChar.consumeEnergy(20);
                    simsChar.getPlayerHandler().sendMessage(Messages.WORK);
                    simsChar.increaseMoney(200);
                    decreaseCleanness(50);
                    simsChar.getHouse().decreaseCleanness(20);
                    return;
                }
                simsChar.getPlayerHandler().sendMessage(Messages.YOU_CANT_USE_ROOM);
                return;
            }
            simsChar.getPlayerHandler().sendMessage(Messages.YOU_NEED_TO_REST);
        } catch (DontHaveHouseException e) {
            System.out.println(e.getMessage());
        }

    }


}
