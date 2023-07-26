package mindswap.academy.sims.player;

import mindswap.academy.sims.houses.House;

public interface Player {

    int getEnergyLevel();
    void setEnergyLevel(int energyLevel);
    void consumeEnergy(int energy);
    void addEnergy(int energy);

}
