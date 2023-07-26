package mindswap.academy.sims.houses.rooms;

public enum RoomManager {

    BEDROOM(new Bedroom()),
    KITCHEN(new Kitchen()),
    LIVING(new Living()),
    OFFICE(new Office());

    private final RoomHandler roomHandler;

    RoomManager(RoomHandler roomHandler) {
        this.roomHandler = roomHandler;
    }

    public RoomHandler getRoomHandler() {
        return roomHandler;
    }
}
