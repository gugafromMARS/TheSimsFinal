package mindswap.academy.sims.game.exceptions;

import mindswap.academy.sims.game.messages.Messages;

public class DontHaveHouseException extends Exception{

    public DontHaveHouseException() {
        super(Messages.DONT_HAVE_HOUSE);
    }
}
