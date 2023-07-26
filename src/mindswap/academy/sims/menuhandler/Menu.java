package mindswap.academy.sims.menuhandler;

public enum Menu {

    BUY(new Buy()),
    MOVE(new Move()),
    DO(new Do()),
    QUIT(new Quit());

    private final MenuHandler menuHandler;

    Menu(MenuHandler menuHandler) {
        this.menuHandler = menuHandler;
    }

    public MenuHandler getMenuHandler() {
        return menuHandler;
    }
}
