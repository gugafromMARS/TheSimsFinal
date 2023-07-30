package mindswap.academy.sims.game.handlers;

import mindswap.academy.sims.game.houses.rooms.Room;
import mindswap.academy.sims.game.houses.rooms.RoomManager;
import mindswap.academy.sims.game.messages.Messages;
import mindswap.academy.sims.game.player.SimsChar;

public class RoomMenuHandler {

    private SimsChar simsChar;
    private Room previousRoom;

    public RoomMenuHandler(SimsChar simsChar) {
        this.simsChar = simsChar;
        previousRoom = RoomManager.LIVING.getRoom();
    }


    public void menu() {
        simsChar.getPlayerHandler().sendMessage(simsChar.getPlayerHandler().getUsername() + " " + Messages.ROOMS_MENU);
        manageRoomOption();
    }

    private void manageRoomOption() {
        String option = simsChar.getPlayerHandler().readMessageFromPlayer();
        for (RoomManager rm: RoomManager.values()) {
            if(option.trim().toUpperCase().equals(rm.toString())){
                if(canMove(rm.getRoom())){
                    simsChar.getPlayerHandler().sendMessage(Messages.MOVED_TO + rm.toString());
                    previousRoom = rm.getRoom();
                    return;
                }
                simsChar.getPlayerHandler().sendMessage(Messages.CANT_MOVE);
                return;
            }
        }
        simsChar.getPlayerHandler().sendMessage(Messages.WRONG_ROOM);
        menu();
    }

    private boolean canMove(Room roomOption){
        if(roomOption.equals(previousRoom)){
            return false;
        }
        return true;
    }

    public Room getPreviousRoom() {
        return previousRoom;
    }
}
