package mindswap.academy.sims.houses.rooms;

public interface Room extends RoomHandler {


    void setLevelOfCleanliness(int cleanliness);
    int getLevelOfCleanliness();
    void decreaseCleanness(int levelOfDirt);
    void cleanRoom();

}
