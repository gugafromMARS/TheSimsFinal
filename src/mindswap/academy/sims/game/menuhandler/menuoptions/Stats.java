package mindswap.academy.sims.game.menuhandler.menuoptions;

import mindswap.academy.sims.game.exceptions.HouseDontExistException;
import mindswap.academy.sims.game.exceptions.DontHaveHouseException;
import mindswap.academy.sims.game.handlers.ActivityHandler;
import mindswap.academy.sims.game.handlers.HouseHandler;
import mindswap.academy.sims.game.handlers.RoomMenuHandler;
import mindswap.academy.sims.game.maid.Maid;
import mindswap.academy.sims.game.menuhandler.MenuHandler;
import mindswap.academy.sims.game.messages.Messages;
import mindswap.academy.sims.game.player.SimsChar;

public class Stats implements MenuHandler {


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

                simsChar.getPlayerHandler().sendMessage("-".repeat(10) + " "+ Messages.STATS + " " + "-".repeat(12)+"\n" + energyStats);
                simsChar.getPlayerHandler().sendMessage(houseStats +"\n");
                return;
            }
            simsChar.getPlayerHandler().sendMessage("-".repeat(10) + " " + Messages.STATS + " " + "-".repeat(12) +"\n" + energyStats +"\n");
            simsChar.getPlayerHandler().sendMessage(Messages.NO_HOUSE_STATS);
        } catch (HouseDontExistException | DontHaveHouseException e) {
            System.out.println(e.getMessage());
        }
    }
}
