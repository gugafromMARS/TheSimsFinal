package mindswap.academy.sims.menuhandler;

import mindswap.academy.sims.exceptions.HouseDontExist;
import mindswap.academy.sims.handlers.ActivityHandler;
import mindswap.academy.sims.handlers.HouseHandler;
import mindswap.academy.sims.handlers.RoomMenuHandler;
import mindswap.academy.sims.maid.Maid;
import mindswap.academy.sims.messages.Messages;
import mindswap.academy.sims.player.SimsChar;

public class Stats implements MenuHandler{


    @Override
    public void execute(SimsChar simsChar, HouseHandler houseHandler, RoomMenuHandler roomMenuHandler, ActivityHandler activityHandler, Maid maid) {
        try {
            int energy = simsChar.getEnergyLevel();
            String energyStats = Messages.STATS_ENERGY + "#".repeat(energy / 10) + " | " + energy +"%";
            if(simsChar.haveHouse()){
                int houseCleanliness = simsChar.getHouse().getLevelOfCleanness();
                int houseMaxCleanliness = simsChar.getHouse().getMaxOfCleanness();
                int convertTo100perCent = (houseCleanliness * 100) / houseMaxCleanliness;
                String houseStats = Messages.STATS_HOUSE + "#".repeat(convertTo100perCent / 10) + " | " + convertTo100perCent +"%";

                simsChar.getPh().sendMessage("-".repeat(10) + " "+ Messages.STATS + " " + "-".repeat(12)+"\n" + energyStats);
                simsChar.getPh().sendMessage(houseStats +"\n");
                return;
            }
            simsChar.getPh().sendMessage("-".repeat(10) + " " + Messages.STATS + " " + "-".repeat(12) +"\n" + energyStats +"\n");
            simsChar.getPh().sendMessage(Messages.NO_HOUSE_STATS);
        } catch (HouseDontExist e) {
            System.out.println(e.getMessage());
        }
    }
}
