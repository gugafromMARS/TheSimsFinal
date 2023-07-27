package mindswap.academy.sims.menuhandler;

public enum Menu {

    BUY(new Buy()),
    SELL(new Sell()),
    MOVE(new Move()),
    DO(new Do()),
    STATS(new Stats()),
    CLEAN(new Clean()),
    WALLET(new Wallet()),
    QUIT(new Quit());

    private final MenuHandler menuHandler;

    Menu(MenuHandler menuHandler) {
        this.menuHandler = menuHandler;
    }

    public MenuHandler getMenuHandler() {
        return menuHandler;
    }
}
