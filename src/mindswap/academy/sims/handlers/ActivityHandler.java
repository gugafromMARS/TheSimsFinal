package mindswap.academy.sims.handlers;

import mindswap.academy.sims.player.SimsChar;

public class ActivityHandler {
    private SimsChar simsChar;
    private RoomMenuHandler roomMenuHandler;

    public ActivityHandler(SimsChar simsChar, RoomMenuHandler roomMenuHandler) {
        this.simsChar = simsChar;
        this.roomMenuHandler = roomMenuHandler;
    }


    public void doTask() {
        roomMenuHandler.getPreviousRoom().execute(simsChar);
    }
}
