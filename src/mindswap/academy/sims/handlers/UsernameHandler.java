package mindswap.academy.sims.handlers;

import mindswap.academy.sims.messages.Messages;
import mindswap.academy.sims.server.Server;

public class UsernameHandler {
    private Server.PlayerHandler playerHandler;

    public UsernameHandler(Server.PlayerHandler playerHandler) {
        this.playerHandler = playerHandler;
    }

    public void createUsername() {
            playerHandler.sendMessage(Messages.CREATE_USERNAME);
            String user = playerHandler.readMessageFromPlayer();
            playerHandler.setUsername(user);
    }
}
