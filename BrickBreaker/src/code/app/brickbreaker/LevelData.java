package code.app.brickbreaker;

import java.util.Arrays;

import javafx.collections.ObservableList;

/**
 * This class contains all of the Level data for a level of the game
 */
public class LevelData {

    private static final String NEXT_LEVEL = "---";

    private static final String[] LEVELS_DATA = new String[] {
    		
            "",
            "",
            "",
            "",
            "WWWEWWEEEWWEWWW",
            "WYYWYYWYWYYWYYW",
            "WWWWWWWWWWWWWWW",
            "OOECCEO OECCEOO",
            "RWRWRWRWRWRWRWR",
            "WRWRWRWRWRWRWRW",
            "WWEWWEWWWEWWEWW",
            "LLLLLLLLLLLLLLL",

            NEXT_LEVEL,

            "",
            "E              ",
            "WO             ",
            "WOG            ",
            "EOGR           ",
            "WOGRB          ",
            "WOGREC         ",
            "EOGRBCL        ",
            "WOGRBCLV       ",
            "WOGRECLVY      ",
            "EOGRBCLVYM     ",
            "WOGRBCLVYMW    ",
            "WOGRECLVYMWE   ",
            "EOGRBCLVYMWEG  ",
            "WOGRBCLVYMWEGR ",
            "22222222222222B",

            NEXT_LEVEL,

            "",
            "VLREVLRERLVERLV",
            "",
            "    222 222 222",
            "    2V2 2V2 2V2",
            "    222 222 222",
            "    E E E E E  ",
            "  222 222 222  ",
            "  2R2 2R2 2R2  ",
            "  222 222 222  ",
            "  E   E   E    ",
            "222 222 222 222",
            "2L2 2L2 2L2 2L2",
            "222 222 222 222",

            NEXT_LEVEL,

            "RRRRR22222RRRRR",
            "RWLWLWLWLWLWLWR",
            "LW22RRELERR22WL",
            "RERWWW222WWWRER",
            "RWLWRRLELRRWLWR",
            "LWRWR     RWRWL",
            "RWRER     RERWR",
            "RWRWR     RWRWR",
            "LEBWR     RWLEL",
            "RWRWR     RWRWR",
            "RWEW2222222WEWR",
            "",
            "",
            "222222222222222",

            NEXT_LEVEL,

        	"",
            "    Y     Y    ",
            "    Y     Y    ",
            "     Y   Y     ",
            "     Y   Y     ",
            "    2222222    ",
            "   B2E222E2B   ",
            "   BELE2ELEB   ",
            "  B2ELE2ELE2B  ",
            " B222E222E222B ",
            " B2222RRR2222B ",
            " B2222RRR2222B ",
            " 2 B2BBBBB2B 2 ",
            " 2 B       B 2 ",
            " 2 B       B 2 ",
            "    222 222    ",
            "    222 222    ",

            NEXT_LEVEL,

            "OOOVOOOVOOOVOOO",
            "OVOOOVOEOVOOOVO",
            "OOOOOOOOOOOOOOO",
            "",
            "",
            "GCGCGCGCGCGCGCG",
            "GGGGGGGEGGGGGGG",
            "GGCGGCGCGCGGCGG",
            "",
            "",
            "YYEYYYWEWYYYEYY",
            "222222WEW222222",
            "YYYYYYW2WYYYYYY",
            "YYYE       EYYY",
            "YY           YY",
            "Y             Y",

            NEXT_LEVEL,

            "",
            "2 2 2 2 2 2 2 2",
            "R C Y W G L O M",
            "R C Y W G L O M",
            "R C Y W G L O M",
            "R C Y W G L O M",
            "R C Y W G L O M",
            "2 2 2 2 2 2 2 2",
            "   E   E   E   ",
            "2 2 2 2 2 2 2 2",
            "R C Y W G L O M",
            "R C Y W G L O M",
            "R C Y W G L O M",
            "R C Y W G L O M",
            "R C Y W G L O M",
            "2 2 2 2 2 2 2 2",

            NEXT_LEVEL,

            "",
            "",
            "RRR YYY GGG RRR",
            "R2R Y Y G G R2R",
            "R R Y2Y G G R R",
            "R R Y Y G2G R R",
            "R R Y Y G G R R",
            "R2R Y2Y G2G R2R",
            "R  E Y E G E  R",
            "",
            "22           22",
            " 22         22 ",
            "  22       22  ",
            "   22     22   ",
            "    22   22    ",
            "     22 22     ",
            "      222      ",
            
            NEXT_LEVEL,

            "2 O Y W G B C M",
            "M C B G W Y O R",
            "R L 2 V G B V M",
            "M C B G W Y O R",
            "R O Y W 2 2 C M",
            "M C B G W Y O R",
            "E L E V E B E M",
            "M E B E W E O E",
            "R O Y W 2 B C M",
            "M C B G W Y O R",
            "R L 2 V G 2 V M",
            "M C B G W Y O R",
            "R O Y W G B C M",
            "2 2 2 2 2 2 2 2",
            
            NEXT_LEVEL,

            "",
            "    O     O    ",
            "   R2R   R2R   ",
            "  MMM M M MMM  ",
            " EE   E E   EE ",
            "MM     V     MM",
            "22      V    22",
            " 2B    V    B2 ",
            "  2O  V    O2  ",
            "   2O  V  O2   ",
            "    B   V B    ",
            "     2 V 2     ",
            "      2 2      ",
            "       2       ",
    };

    private static ObservableList<Integer> levelsOffsets;

    /**
     * Retrieve the levels count
     * 
     * @return
     *         The levels count
     */
    public static int getLevelsCount() {
        initLevelsOffsets();
        return levelsOffsets.size() - 1;
    }

    /**
     * Retrieve level data for a given level
     * 
     * @param level
     *            The level desired
     * @return
     *         The level data
     */
    public static String[] getLevelData(int level) {
        initLevelsOffsets();

        if ((level < 1) || (level > getLevelsCount())) {
            return null;
        } else {
            return Arrays.copyOfRange(LEVELS_DATA, levelsOffsets.get(level - 1) + 1, levelsOffsets.get(level));
        }
    }

    /**
     * Initializes level offsets
     */
    private static void initLevelsOffsets() {
        if (levelsOffsets == null) {
            levelsOffsets = javafx.collections.FXCollections.<Integer> observableArrayList();
            levelsOffsets.add(-1);

            for (int i = 0; i < LEVELS_DATA.length; i++) {
                if (LEVELS_DATA[i].equals(NEXT_LEVEL)) {
                    levelsOffsets.add(i);
                }
            }

            levelsOffsets.add(LEVELS_DATA.length + 1);
        }
    }
}