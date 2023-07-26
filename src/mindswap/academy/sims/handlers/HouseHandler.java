package mindswap.academy.sims.handlers;

import mindswap.academy.sims.houses.House;
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
        if(!simsChar.haveHouse()){
            return true;
        }
        return false;
    }

    private void sellHouse() {
        /*
        if(simsChar.haveHouse()){

        }
         */
    }
}
