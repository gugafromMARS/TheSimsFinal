package mindswap.academy.sims.houses.rooms;

import mindswap.academy.sims.messages.Messages;
import mindswap.academy.sims.player.SimsChar;

public class Living implements Room {

    private int maxLevelOfCleanliness;
    private int levelOfCleanliness;

    public Living() {
        maxLevelOfCleanliness = 100;
        levelOfCleanliness = 100;
    }
    @Override
    public void execute(SimsChar simsChar) {
        if(simsChar.getEnergyLevel() >= 20){
            if(simsChar.getHouse().getLevelOfCleanness() >= 100 && getLevelOfCleanliness() >= 20){
                simsChar.consumeEnergy(20);
                simsChar.getPh().sendMessage(Messages.TV);
                decreaseCleanness(50);
                simsChar.getHouse().decreaseCleanness(20);
                return;
            }
            simsChar.getPh().sendMessage(Messages.YOU_CANT_USE_ROOM);
            return;
        }
        simsChar.getPh().sendMessage(Messages.YOU_NEED_TO_REST);
    }

    @Override
    public void setLevelOfCleanliness(int cleanliness) {
        levelOfCleanliness = cleanliness;
    }

    @Override
    public int getLevelOfCleanliness() {
        return levelOfCleanliness;
    }

    @Override
    public void decreaseCleanness(int levelOfDirt) {
        levelOfCleanliness -= levelOfDirt;
    }

    @Override
    public void cleanRoom() {
        setLevelOfCleanliness(maxLevelOfCleanliness);
    }
}
