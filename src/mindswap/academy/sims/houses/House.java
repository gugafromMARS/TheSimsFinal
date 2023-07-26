package mindswap.academy.sims.houses;

import mindswap.academy.sims.houses.rooms.Kitchen;
import mindswap.academy.sims.houses.rooms.Room;

import java.util.ArrayList;
import java.util.List;

public class House {

    private boolean occupied;
    private double price;
    private int maxOfCleanness;
    private int levelOfCleanness;
    private final List<Room> rooms;
    public House() {
        occupied = false;
        price = 15000;
        maxOfCleanness = 100;
        levelOfCleanness = 100;
        rooms = new ArrayList<>();
    }

    public boolean isOccupied() {
        return occupied;
    }

    public void setOccupied(boolean occupied) {
        this.occupied = occupied;
    }


}
