package mindswap.academy.sims.houses;

import mindswap.academy.sims.houses.rooms.Kitchen;
import mindswap.academy.sims.houses.rooms.Room;
import mindswap.academy.sims.houses.rooms.RoomManager;

import java.util.ArrayList;
import java.util.List;

public class House {

    private boolean occupied;
    private double price;
    private final int maxOfCleanness;
    private int levelOfCleanness;
    private List<Room> rooms;
    public House() {
        occupied = false;
        price = 15000;
        maxOfCleanness = 400;
        levelOfCleanness = 400;
        buildRooms();
    }
    private void buildRooms() {
        rooms = new ArrayList<>();
        for (RoomManager rm: RoomManager.values()) {
            rooms.add(rm.getRoom());
        }
    }

    public boolean isOccupied() {
        return occupied;
    }

    public void setOccupied(boolean occupied) {
        this.occupied = occupied;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public int getLevelOfCleanness() {
        return levelOfCleanness;
    }

    public void setLevelOfCleanness(int levelOfCleanness) {
        this.levelOfCleanness = levelOfCleanness;
    }

    public void decreaseCleanness(int levelOfDirt){
        levelOfCleanness -= levelOfDirt;
    }

    public int getMaxOfCleanness() {
        return maxOfCleanness;
    }
}
