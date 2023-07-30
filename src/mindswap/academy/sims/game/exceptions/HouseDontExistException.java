package mindswap.academy.sims.game.exceptions;

import mindswap.academy.sims.game.messages.Messages;

public class HouseDontExistException extends Exception{
    public HouseDontExistException() {
        super(Messages.HOUSE_NO_EXIST);
    }
}
