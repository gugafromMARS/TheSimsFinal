package mindswap.academy.sims.game.handlers;

import mindswap.academy.sims.game.messages.Messages;
import mindswap.academy.sims.server.PlayerHandler;
import mindswap.academy.sims.server.Server;

public class UsernameHandler {
    private PlayerHandler playerHandler;

    public UsernameHandler(PlayerHandler playerHandler) {
        this.playerHandler = playerHandler;
    }

    public void createUsername() {
            playerHandler.sendMessage(Messages.CREATE_USERNAME);
            String user = playerHandler.readMessageFromPlayer();
            playerHandler.setUsername(user);
    }
}
