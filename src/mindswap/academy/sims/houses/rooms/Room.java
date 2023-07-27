package mindswap.academy.sims.houses.rooms;

import mindswap.academy.sims.messages.Messages;
import mindswap.academy.sims.player.SimsChar;

public abstract class Room implements RoomHandler{

    private int maxLevelOfCleanliness;
    private int levelOfCleanliness;

    public Room() {
        this.maxLevelOfCleanliness = 100;
        this.levelOfCleanliness = 100;
    }

    @Override
    public void execute(SimsChar simsChar) {
        if(simsChar.getHouse().getLevelOfCleanness() >= 100 && getLevelOfCleanliness() >= 20){
            simsChar.setEnergyLevel(100);
            simsChar.getPh().sendMessage(Messages.SLEEPING);
            decreaseCleanness(50);
            simsChar.getHouse().decreaseCleanness(20);
            return;
        }
        simsChar.getPh().sendMessage(Messages.YOU_CANT_USE_ROOM);
    }

    public void setLevelOfCleanliness(int cleanliness){
        levelOfCleanliness = cleanliness;
    }
    public int getLevelOfCleanliness(){
        return levelOfCleanliness;
    }
    public void decreaseCleanness(int levelOfDirt){
        levelOfCleanliness -= levelOfDirt;
    }
    public void cleanRoom() {
        setLevelOfCleanliness(maxLevelOfCleanliness);
    }
}
