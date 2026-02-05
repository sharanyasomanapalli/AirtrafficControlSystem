package aircraft;

public class InputValidator {

    public static boolean isValidNumber(String input) {
        if (input == null || input.isEmpty()) return false;
        for (int i = 0; i < input.length(); i++) {
            if (!Character.isDigit(input.charAt(i))) return false;
        }
        return true;
    }

    public static boolean isValidAltitude(int altitude) {
        return altitude >= 0 && altitude <= 45000;
    }
    
    public static boolean isValidCount(int count)
    {
	return count>=0;
    }

    public static boolean isValidWeight(int weight)
    {
	return weight>0;
    }

    public static boolean isValidSpeed(int speed) {
        return speed >= 0 && speed <= 1000;
    }
}