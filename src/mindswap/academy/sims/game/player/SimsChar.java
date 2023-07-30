package mindswap.academy.sims.game.player;
import mindswap.academy.sims.game.exceptions.DontHaveHouseException;
import mindswap.academy.sims.game.exceptions.HouseDontExistException;
import mindswap.academy.sims.game.houses.House;
import mindswap.academy.sims.server.PlayerHandler;
import mindswap.academy.sims.server.Server;

public class SimsChar implements Player{

    private PlayerHandler playerHandler;
    private House house;
    private int energyMaxLevel;
    private int energyLevel;
    private double wallet;

    public SimsChar(PlayerHandler playerHandler) {
        this.playerHandler = playerHandler;
        energyMaxLevel = 100;
        energyLevel = 100;
        wallet = 25000.0;
    }

    public PlayerHandler getPlayerHandler() {
        return playerHandler;
    }

    public House getHouse() throws DontHaveHouseException {
        if(house != null){
            return house;
        }
        throw new DontHaveHouseException();
    }

    public void setHouse(House house) {
        this.house = house;
    }

    public boolean haveHouse() throws HouseDontExistException {
        if (house != null) {
            return true;
        }
        if(house == null) {
            return false;
        }
        throw new HouseDontExistException();
    }
    @Override
    public int getEnergyLevel() {
        return energyLevel;
    }
    @Override
    public void setEnergyLevel(int energyLevel) {
        this.energyLevel = energyLevel;
    }
    @Override
    public void consumeEnergy(int energy) {
        boolean limitOfEnergy = this.energyLevel - energy <= 0;
        if(limitOfEnergy){
            this.energyLevel = 0;
            return;
        }
        this.energyLevel -= energy;
    }
    @Override
    public void addEnergy(int energy) {
        boolean limitOfEnergy = this.energyLevel + energy >= energyMaxLevel;
        if(limitOfEnergy){
            this.energyLevel = energyMaxLevel;
            return;
        }
        this.energyLevel += energy;
    }

    public double getWallet() {
        return wallet;
    }

    public void increaseMoney(double money){
        wallet += money;
    }

    public void decreaseMoney(double money){
        wallet -= money;
    }


}
