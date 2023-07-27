package mindswap.academy.sims.messages;

public class Messages {

    public static final String CREATE_USERNAME = "INSERT YOUR USERNAME: ";
    public static final String WELCOME = """
                        
             __      __  ___   _       ___    ___    __  __   ___                                  \s
             \\ \\    / / | __| | |     / __|  / _ \\  |  \\/  | | __|                                 \s
              \\ \\/\\/ /  | _|  | |__  | (__  | (_) | | |\\/| | | _|                                  \s
               \\_/\\_/   |___| |____|  \\___|  \\___/  |_|  |_| |___|                                 \s
                                                                                                   \s
                                  _____    ___                                                     \s
                                 |_   _|  / _ \\                                                    \s
                                   | |   | (_) |                                                   \s
                                   |_|    \\___/                                                    \s
                                                                                                   \s
                            ___   ___   __  __   ___                                               \s
                           / __| |_ _| |  \\/  | / __|                                              \s
                           \\__ \\  | |  | |\\/| | \\__ \\                                              \s
                           |___/ |___| |_|  |_| |___/                                              \s
                                                                                                   \s
                        
            """;
    public static final String ALREADY_HAVE_HOUSE = "YOU ALREADY HAVE A HOUSE!";
    public static final String BUY_HOUSE = """
                        
                          ██████████             \s
                        ██▓▓▓▓▓▓▓▓▓▓██           \s
                      ██▓▓▓▓▓▓▓▓▓▓▓▓▓▓██         \s
                    ██▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓██       \s
                  ██▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓██     \s
                ██▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓██   \s
              ██▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓██ \s
            ██▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓██
            ██████████████████████████████████████
                ██                          ██   \s
                ██                          ██   \s
                ██                          ██   \s
                ████████  ██████████        ██   \s
                ████  ██  ██▓▓▓▓▓▓██        ██   \s
                ████████  ██▓▓▓▓▓▓██        ██   \s
                ██        ██▓▓▓▓  ██        ██   \s
                ██        ██▓▓▓▓▓▓██        ██   \s
                ██████████████████████████████   \s
                                  
                        
            YOU BOUGHT YOUR HOUSE, CONGRATS!
            """;
    public static final String SERVER_DEAD = "MAYBE SERVER IS DEAD!";
    public static final String FINISH_GAME = "YOU QUIT THE GAME!";
    public static final String YOU_MOVED_TO = "YOU MOVED TO ";
    public static final String CANT_MOVE = "YOU ALREADY ARE IN THAT ROOM";
    public static final String NO_HOUSE = "YOU DON'T HAVE A HOUSE YET, BUY ONE!";
    public static final String NO_HOUSE_STATS = "YOU DON'T HAVE A HOUSE YET, YOU CAN'T SEE HOUSE STATS, BUY ONE!";
    public static final String HOUSE_NO_EXIST = "SOMETHING WRONG WITH HOUSE!";
    public static final String DONT_HAVE_HOUSE = "CAN'T CLEAN BECAUSE MAYBE HOUSE IS NULL!";
    public static final String NO_MONEY = "YOU DON'T HAVE MONEY TO PAY, YOU NEED TO WORK FIRST!";
    public static final String SLEEPING = "IM SLEEPING zZzZz";
    public static final String WORK = "I'M FULL FOCUS ON WORKING...";
    public static final String COOKING = "I'M COOKING SOMETHING!";
    public static final String TV = "I'M WATCHING A PROGRAM ABOUT DESIGN PATTERNS ON TV";
    public static final String YOU_CANT_USE_ROOM = "YOU CAN'T USE THIS ROOM, NO NEED TO CLEAN IT FIRST!";
    public static final String YOU_NEED_TO_REST = "YOU DONT HAVE ANY ENERGY, YOU NEED TO TAKE A REST!";
    public static final String HOMELESS = "I SOLD MY HOUSE AND NOW I DON'T HAVE ONE!";
    public static final String STATS = "STATS";
    public static final String STATS_ENERGY = "YOUR ENERGY | ";
    public static final String STATS_HOUSE = "YOUR HOUSE CLEANLINESS LEVEL | ";
public static final String MAID_CLEANING = """
                                                                                         \s
                                    ░░░░░░░░░░░░░░                                       \s
                                  ░░░░░░░░░░░░░░░░░░                                     \s
                                ▒▒▒▒▒▒▒▒░░▒▒▒▒▒▒▒▒░░░░                                   \s
                              ▒▒▒▒    ▒▒▒▒▒▒    ▒▒▒▒░░░░                                 \s
                              ▒▒    ██  ▒▒  ██    ▒▒████                                 \s
                              ▒▒        ▒▒        ▒▒████                                 \s
                              ▒▒▒▒    ▒▒▒▒▒▒    ▒▒▒▒░░░░    ▒▒    ▒▒                     \s
                              ░░▒▒▒▒▒▒▒▒░░▒▒▒▒▒▒▒▒░░░░░░    ▒▒▒▒▒▒                       \s
                              ░░░░░░░░░░░░░░░░░░░░░░░░░░    ▒▒▒▒▒▒▒▒▒▒                   \s
                              ░░░░░░░░░░░░░░░░░░░░░░░░░░    ▒▒▒▒▒▒▒▒                     \s
                              ░░░░░░░░░░░░░░██░░░░░░░░░░    ▒▒▒▒▒▒▒▒▒▒▒▒                 \s
                              ░░░░░░░░██████░░░░░░░░░░░░  ▒▒▒▒▒▒▒▒▒▒▒▒                   \s
                              ░░░░░░░░░░░░░░░░░░░░██████  ▒▒▒▒▒▒                         \s
                            ░░████░░░░  ░░░░██████████░░░░▒▒▒▒                           \s
                          ░░░░██████      ██████████░░░░░░░░                             \s
                          ░░░░██████████████████████░░██░░░░                             \s
                          ░░░░                          ░░                               \s
                            ░░████          ████████████                                 \s
                              ██              ██████████                                 \s
                            ▓▓██              ████████████                               \s
                          ▓▓████▓▓          ▓▓████▓▓████▓▓██                             \s
                        ████████████████████████████                                     \s
                            ████████████                                                 \s
                                          ▒▒▒▒                                           \s
                                    ▒▒▒▒  ▒▒▒▒                                           \s
                                  ██████  ██▓▓██                                         \s

                
        YOUR HOUSE IS CLEAN!
        """;
    public static final String OPTIONS_MENU = """
            YOUR OPTIONS ARE :
                              BUY,
                              SELL,
                              MOVE,
                              DO,
                              STATS,
                              CLEAN,
                              WALLET,
                              QUIT
            --------------------------------
            """;
    public static final String ROOMS_MENU = """
            YOUR ROOMS ARE : 
                            LIVING,
                            KITCHEN,
                            BEDROOM,
                            OFFICE
            ---------------------------------
            """;



}
