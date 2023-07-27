package mindswap.academy.sims.player;
import mindswap.academy.sims.houses.House;
import mindswap.academy.sims.server.Server;

public class SimsChar implements Player{

    private Server.PlayerHandler ph;
    private House house;
    private int energyMaxLevel;
    private int energyLevel;
    private double wallet;

    public SimsChar(Server.PlayerHandler ph) {
        this.ph = ph;
        energyMaxLevel = 100;
        energyLevel = 100;
        wallet = 25000.0;
    }

    public Server.PlayerHandler getPh() {
        return ph;
    }

    public House getHouse() {
        return house;
    }

    public void setHouse(House house) {
        this.house = house;
    }

    public boolean haveHouse() {
        return house != null;
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
