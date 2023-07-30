package mindswap.academy.sims.game.handlers;

import mindswap.academy.sims.game.exceptions.HouseDontExistException;
import mindswap.academy.sims.game.exceptions.DontHaveHouseException;
import mindswap.academy.sims.game.houses.House;
import mindswap.academy.sims.game.messages.Messages;
import mindswap.academy.sims.game.player.SimsChar;

public class HouseHandler {

    private House house;
    private SimsChar simsChar;

    public HouseHandler(SimsChar simsChar) {
       house = new House();
       this.simsChar = simsChar;
    }
    
    public boolean buy() {
        if(checkIfPossible()) {
            simsChar.setHouse(house);
            house.setOccupied(true);
            return true;
        }
        return false;
    }

    private boolean checkIfPossible() {
        try {
            if(!simsChar.haveHouse()){
                return true;
            }
        } catch (HouseDontExistException hde) {
            System.out.println(hde.getMessage());
        }
        return false;
    }

    public void sell() {
        try {
            if(simsChar.haveHouse()){
                simsChar.getPlayerHandler().sendMessage(Messages.HOMELESS);
                simsChar.increaseMoney(simsChar.getHouse().getPrice());
                simsChar.getHouse().setOccupied(false);
                simsChar.setHouse(null);
                return;
            }
            simsChar.getPlayerHandler().sendMessage(Messages.NO_HOUSE);
            } catch (HouseDontExistException | DontHaveHouseException hde) {
            System.out.println(hde.getMessage());
        }
    }

}
