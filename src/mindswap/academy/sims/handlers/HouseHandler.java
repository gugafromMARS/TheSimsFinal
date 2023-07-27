package mindswap.academy.sims.handlers;

import mindswap.academy.sims.exceptions.DontHaveHouse;
import mindswap.academy.sims.exceptions.HouseDontExist;
import mindswap.academy.sims.houses.House;
import mindswap.academy.sims.messages.Messages;
import mindswap.academy.sims.player.SimsChar;

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
        } catch (HouseDontExist hde) {
            System.out.println(hde.getMessage());
        }
        return false;
    }

    public void sellHouse() {
        try {
            if(simsChar.haveHouse()){
                simsChar.getPh().sendMessage(Messages.HOMELESS);
                simsChar.increaseMoney(simsChar.getHouse().getPrice());
                simsChar.getHouse().setOccupied(false);
                simsChar.setHouse(null);
                return;
            }
            simsChar.getPh().sendMessage(Messages.NO_HOUSE);
            } catch (HouseDontExist | DontHaveHouse hde) {
            System.out.println(hde.getMessage());
        }
    }

}
