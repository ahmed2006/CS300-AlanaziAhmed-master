import java.util.HashMap;
import java.util.Map;
/**
 * This class is part of the "The Ghost" application. "The Ghost" is
 * a very simple, text based adventure game.
 *
 * This class holds an enumeration of all command words known to the game. It is
 * used to recognize commands as they are typed in.
 *
 * @author ahmed
 * @version 2018. 3.3
 */
public class CommandWords {

    /**
     * A map that holds all valid command words.
     */
    private static Map<String, CommandEnum> validCommands = new HashMap<String, CommandEnum>();

    /**
     * Static block to initialize 
     * the fields of CommandWords.
     */
    static {
        for (CommandEnum value : CommandEnum.values()) {
            validCommands.put(value.getCommand(), value);
        }
    }

    /**
     * Check whether a given String is a valid command word.
     * @param aString The string to determine whether it is a valid command.
     * @return true if a given string is a valid command, false if it isn't.
     */
    public static boolean isCommand(String aString) {
        // if we get here, the string was not found in the commands
        return validCommands.containsKey(aString);
    }

    /**
     * Returns a list of the available commands , of the form : Your command
     * words are : look go quit help
     *
     * @return A string containing the list of available commands .
     */
    public static String getCommandString() {
        String string = "";
        for (String validCommand : validCommands.keySet()) {
            string += " " + validCommand;
        }
        return string;
    }

    /**
     * Converts a String into a CommandEnum object .
     *
     * @param theString The String containing the command word .
     * @return The CommandEnum object representing the command , or null if the
     * command does not exist .
     */
    public static CommandEnum getCommand(String theString) {
        return validCommands.get(theString);
    }
}
