/**
 * CommandEnum relace the command words and 
 * gives access the the available commands.
 * @author ahmed
 * @version 05-01-2018
 */
public enum CommandEnum {
    /** go.*/
    GO("go"), 
    /** quit.*/
    QUIT("quit"),
        /** help.*/
    HELP("help"), 
        /** look.*/
    LOOK("look"),
        /** status.*/
    STATUS("status"),
        /** back.*/
    BACK("back"),
        /** examine.*/
    EXAMINE("examine"),
    /** take.*/
    TAKE("take"),
        /** drop.*/
    DROP("drop"), 
        /** inventory.*/
    INVENTORY("inventory"),
        /** .*/
    UNLOCK("unlock"),
        /** look.*/
    LOCK("lock"),
        /** pack.*/
    PACK("pack"),
        /** unpack.*/
    UNPACK("unpack") ,
        /** eat.*/
    EAT("eat"),
        /** equip.*/
    EQUIP("equip"),
        /** unequip.*/
    UNEQUIP("unequip"),
        /** switch on.*/
    SWITCHON("switchon"),
        /** switch off.*/
    SWITCHOFF("switchoff"),
     /** talk to.*/
    TALK("talk"),
    /** buy.*/
    SHOP("shop"),
    /** buy.*/
    KILL("kill");
    
    /** command in string format. */ 
    private String command;
    /** Constructor for the enum type .
       * @param command command
       */
    private CommandEnum(String command) {
        this.command = command;
    }
    /** getter for command string .
       * @return command command
       */
    public String getCommand() {
        return command;
    }
}