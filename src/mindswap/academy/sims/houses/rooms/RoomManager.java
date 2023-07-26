package mindswap.academy.sims.houses.rooms;

public enum RoomManager {

    BEDROOM(new Bedroom()),
    KITCHEN(new Kitchen()),
    LIVING(new Living()),
    OFFICE(new Office());

    private final Room room;

    RoomManager(Room room) {
        this.room = room;
    }
    public Room getRoom() {
        return room;
    }
}
