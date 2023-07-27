package mindswap.academy.sims.exceptions;

import mindswap.academy.sims.messages.Messages;

public class DontHaveHouse extends Exception{

    public DontHaveHouse() {
        super(Messages.DONT_HAVE_HOUSE);
    }
}
