package mindswap.academy.sims.exceptions;

import mindswap.academy.sims.messages.Messages;

public class HouseDontExist extends Exception{
    public HouseDontExist() {
        super(Messages.HOUSE_NO_EXIST);
    }
}
