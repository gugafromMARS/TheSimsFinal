package mindswap.academy.sims.game.player;

public interface Player {

    int getEnergyLevel();
    void setEnergyLevel(int energyLevel);
    void consumeEnergy(int energy);
    void addEnergy(int energy);

}
