package mindswap.academy.sims.handlers;

import mindswap.academy.sims.houses.rooms.Room;
import mindswap.academy.sims.houses.rooms.RoomManager;
import mindswap.academy.sims.messages.Messages;
import mindswap.academy.sims.player.SimsChar;

import java.util.List;

public class RoomMenuHandler {

    private SimsChar simsChar;
    private Room previousRoom;
    private String previousRoomOption;

    public RoomMenuHandler(SimsChar simsChar) {
        this.simsChar = simsChar;
        previousRoom = RoomManager.LIVING.getRoom();
        previousRoomOption = "living";
    }


    public void menu() {
        simsChar.getPh().sendMessage(simsChar.getPh().getUsername() + " " + Messages.ROOMS_MENU);
        manageRoomOption();
    }

    private void manageRoomOption() {
        String option = simsChar.getPh().readMessageFromPlayer();
        switch (option.trim()) {
            case "kitchen" -> {
                if (manageAnswer(option)) {
                    previousRoom = RoomManager.KITCHEN.getRoom();
                }
            }
            case "bedroom" -> {
                if (manageAnswer(option)) {
                    previousRoom = RoomManager.BEDROOM.getRoom();
                }
            }
            case "office" -> {
                if (manageAnswer(option)) {
                    previousRoom = RoomManager.OFFICE.getRoom();
                }
            }
            default -> {
                if (manageAnswer(option)) {
                    previousRoom = RoomManager.LIVING.getRoom();
                }
            }
        }
    }

    private boolean canMove(String playerOption){
        if(playerOption.contains(previousRoomOption)){
            return false;
        }
        return true;
    }

    private boolean manageAnswer(String playerOption) {
        if(canMove(playerOption)) {
            for (RoomManager rm : RoomManager.values()) {
                if(rm.name().contains(playerOption.toUpperCase())) {
                    previousRoomOption = playerOption;
                    simsChar.getPh().sendMessage(Messages.YOU_MOVED_TO + playerOption.toUpperCase());
                    return true;
                }
            }
            previousRoomOption = "living";
            simsChar.getPh().sendMessage(Messages.YOU_MOVED_TO + previousRoomOption.toUpperCase());
            return true;
        }
        simsChar.getPh().sendMessage(Messages.CANT_MOVE);
        return false;
    }

    public Room getPreviousRoom() {
        return previousRoom;
    }
}
