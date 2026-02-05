package color;

public class ConsoleStyle {

    // ANSI escape codes
    public static final String RESET = "\u001B[0m";
    public static final String BOLD = "\u001B[1m";
    public static final String UNDERLINE = "\u001B[4m";
    public static final String BLINK = "\u001B[5m";

    // Text colors
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";
    public static final String CYAN = "\u001B[36m";
    public static final String WHITE = "\u001B[37m";
    public static final String BRIGHT_GREEN = "\u001B[92m";
    public static final String GRAY = "\u001B[90m";


    // Background colors
    public static final String BG_RED = "\u001B[41m";
    public static final String BG_GREEN = "\u001B[42m";
    public static final String BG_YELLOW = "\u001B[43m";
    public static final String BG_BLUE = "\u001B[44m";
    public static final String BG_CYAN = "\u001B[46m";
    public static final String BG_WHITE = "\u001B[47m";

    public static String getRESET()
    {
        return RESET;
    }
    public static String getBOLD(){
        return BOLD;
    }
    public static String getUNDERLINE() {
        return UNDERLINE;
    }
    public static String getBLINK() {
        return BLINK;
    }
    public static String getRED() {
        return RED;
    }
    public static String getGREEN() {
        return GREEN;
    }
    public static String getYELLOW() {
        return YELLOW;
    }
    public static String getBLUE() {
        return BLUE;
    }


public static String getCYAN() {
        return CYAN;
    }
    public static String getWHITE() {
        return WHITE;
    }
    public static String getBG_RED() {
        return BG_RED;
    }
    public static String getBG_GREEN() {
        return BG_GREEN;
    }
    public static String getBG_YELLOW() {
        return BG_YELLOW;
    }
    public static String getBG_BLUE() {
        return BG_BLUE;
    }
    public static String getBG_CYAN() {
        return BG_CYAN;
    }
    public static String getBG_WHITE() {
        return BG_WHITE;
    
}

public static String getBRIGHT_GREEN()
{
		return BRIGHT_GREEN;

}
public static String getGRAY()
{
		return GRAY;
}
}
