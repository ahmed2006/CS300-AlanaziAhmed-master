
/**
 * This class is the main class of the "The Ghost" application. "The
 * Ghost" is a very simple, text based adventure game. Users can walk around
 * some scenery. That's all. It should really be extended to make it more
 * interesting!
 *
 * This game class creates and initializes all the others: it creates all rooms,
 * creates the parser and starts the game. It also evaluates and executes the
 * commands that the parser returns.
 *
 * @author ahmed alanazi
 * @version 2018.04.01
 */
public class Game {

    /**
     * The world where the game takes place.
     */
    private World world;

    /**
     * The number of movements that the player has made.
     */
    private int turns;
    /**
     * The score that the player earns.
     */
    private int score;
    /**
     * This is an object for getting the room from the Player class.
     */
    private Player playerClass;

    /**
     * Create the game and initialize its internal map.
     */
    public Game() {
        world = new World();
        playerClass = new Player(world.getRoom("ClassRoom1"));
        score = 0;
        turns = 0;
        //character = character;

    }

    /**
     * Main play routine. Loops until end of play.
     */
    public void play() {
        printWelcome();

        // Enter the main game loop. Here we repeatedly read commands and
        // execute them until the game is over.
        boolean wantToQuit = false;

        do {
            Room currentRoom = playerClass.getRoom();
            for (Character character : currentRoom.getCharacters()) {
                if (character instanceof Enemy) {
                    ((Enemy) character).attack(playerClass);
                    Writer.println("Enemy " + character.getName() + " is attacking...");
                }
            }
            Command command = Reader.getCommand();
            wantToQuit = processCommand(command);
            // other stuff that needs to happen every turn can be added here.
            //
            turns++;
        } while (!wantToQuit);
        printGoodbye();
    }

    /**
     * Printsoutthecurrentlocationandexits.
     */
    private void printLocationInformation() {
        Writer.println(playerClass.getRoom().toString());
        // other stuff that needs to happen every turn can be added here.
    }

    ///////////////////////////////////////////////////////////////////////////
    // Helper methods for processing the commands
    /**
     * Given a command, process (that is: execute) the command.
     *
     * @param command The command to be processed.
     * @return true If the command ends the game, false otherwise.
     */
    private boolean processCommand(final Command command) {
        boolean wantToQuit = false;

        if (command.isUnknown()) {
            Writer.println("I don't know what you mean...");
        } 
        else {

            CommandEnum commandWord = command.getCommandWord();
            switch (commandWord) {
                case HELP:
                    printHelp();
                    break;
                case GO:
                    goRoom(command);
                    break;
                case QUIT:
                    wantToQuit = quit(command);
                    break;
                case LOOK:
                    look();
                    break;
                case STATUS:
                    status();
                    break;
                case BACK:
                    back();
                    break;
                case EXAMINE:
                    examine(command);
                    break;
                case TAKE:
                    take(command);
                    break;
                case DROP:
                    drop(command);
                    break;
                case INVENTORY:
                    inventory();
                    break;
                case LOCK:
                    lock(command);
                    break;
                case UNLOCK:
                    unlock(command);
                    break;
                case PACK:
                    pack(command);
                    break;
                case UNPACK:
                    unpack(command);
                    break;
                case EAT:
                    eat(command);
                    break;
                case EQUIP:
                    equip(command);
                    break;
                case UNEQUIP:
                    unequip(command);
                    break;
                case SWITCHOFF:
                    switchoff(command);
                    break;
                case SWITCHON:
                    switchon(command);
                    break;
                case TALK:
                    talk(command);
                    break;
                case SHOP:
                    shop(command);
                    break;
                case KILL:
                    kill(command);
                    break;

                default:
                    Writer.println(commandWord + " is not implemented yet!");

            }
        }
        return wantToQuit;
    }

    ///////////////////////////////////////////////////////////////////////////
    // Helper methods for implementing all of the commands.
    // It helps if you organize these in alphabetical order.
    /**
     * Try to go to one direction. If there is an exit, enter the new room,
     * otherwise print an error message.
     *
     * @param command The command to be processed.
     */
    private void goRoom(final Command command) {
        Room currentRoom = playerClass.getRoom();
        if (!command.hasSecondWord()) {
            // if there is no second word, we don't know where to go...
            Writer.println("Go where?");
        } 
        else {
            String direction = command.getRestOfLine();
            // Try to leave current.
            Door doorway = null;
            doorway = currentRoom.getExit(direction);

            if (doorway == null) {
                Writer.println("There is no door!");
            } 
            else {
                if (doorway.isLocked()) {
                    Writer.println("The door to the " + direction + " is locked");
                } 
                else {
                    Room newRoom = doorway.getDestination();
                    playerClass.setRoom(newRoom);

                    score += newRoom.getPoints();
                    printLocationInformation();
                    Writer.println();
                }
            }
        }
    }

    /**
     * Print out the closing message for the player.
     */
    private void printGoodbye() {
        Writer.println("I hope you weren't too bored here on the Ghost Game!");
        Writer.println("Thank you for playing.  Good bye.");
        Writer.println("You have earned" + " " + score + "  " + "points in" + " " + turns + " " + "turns.");
    }

    /**
     * Print out some help information. Here we print some stupid, cryptic
     * message and a list of the command words.
     */
    private void printHelp() {
        Writer.println("You are lost. You are alone. You wander");
        Writer.println("around at the university.");
        Writer.println();
        Writer.println("Your command words are:");
        Writer.println("   " + CommandWords.getCommandString());
    }

    /**
     * Print out the opening message for the player.
     */
    private void printWelcome() {
        Room currentRoom = playerClass.getRoom();
        Writer.println();
        Writer.println("Welcome to the Ghost Game!");
        Writer.println("The Ghost Game is a new, incredibly boring adventure game.");
        Writer.println("Type 'help' if you need help.");
        Writer.println();
        // Writer.println(currentRoom.getName() + ":");
        Writer.println();
        printLocationInformation();
    }

    /**
     * "Quit" wasI entered. Check the rest of the command to see whether we
     * really quit the game.
     *
     * @param command The command to be processed.
     * @return true, if this command quits the game, false otherwise.
     */
    private boolean quit(final Command command) {
        boolean wantToQuit = true;
        if (command.hasSecondWord()) {
            Writer.println("Quit what?");
            wantToQuit = false;
        }
        return wantToQuit;
    }

    /**
     * Prints out the location information.
     */
    private void look() {
        printLocationInformation();
    }

    /**
     * Prints status : score, number of turns and location informations.
     */
    private void status() {
        Writer.println("Current state of the game\n"
                + "\tScore : "
                + score + "\n\tNumber of turns :"
                + turns + "\n");
        printLocationInformation();
        Writer.println("Balance : " + playerClass.getMoney());
    }

    /**
     * Takes the player into the previous room he/she was in.
     */
    private void back() {
        if (playerClass.getRoom() == playerClass.getPrevious()) {
            Writer.println("You just started the game no previuos location yet.");
        } 
        else {
            playerClass.setRoom(playerClass.getPrevious());
        }
        printLocationInformation();

    }

    /**
     * Examines Items taken by the player and items in the current room.
     *
     * @param command command
     */
    private void examine(final Command command) {
        Room currentRoom = playerClass.getRoom();
        if (!command.hasSecondWord()) {
            // if there is no second word, we don't know where to go...
            Writer.println("Which item?");
        } 
        else {
            String itemName = command.getRestOfLine();
            if (playerClass.getItem(itemName) == null && currentRoom.getItem(itemName) == null
                    && currentRoom.getCharacter(itemName) == null)
                    {
                        Writer.println("No such item");
            } 
            else {
                if (currentRoom.getCharacter(itemName) == null) {
                    if (playerClass.getItem(itemName) != null) {
                        Writer.println(playerClass.getItem(itemName));
                    } 
                    else {
                        Writer.println(currentRoom.getItem(itemName));
                    }
                }
                else {
                    Writer.println(currentRoom.getCharacter(itemName));
                }
            }
        }
    }

    /**
     * Makes the player take an item.
     *
     * @param command command
     */
    private void take(final Command command) {
        Room currentRoom = playerClass.getRoom();
        if (!command.hasSecondWord()) {
            // if there is no second word, we don't know where to go...
            Writer.println("Take what?");
        } 
        else {
            String itemName = command.getRestOfLine();
            if (currentRoom.getItem(itemName) == null) {
                Writer.println("No such item");
            }
            else {
                Item item = currentRoom.getItem(itemName);
                if (item.getWeight() > Player.MAX_CARRY_WEIGHT) {
                    Writer.println("Item too heavy to lift");
                } 
                else {
                    if (item.isPlaying()) {
                        if (playerClass.addItem(item)) {
                            currentRoom.removeItem(itemName);
                            Writer.println("You took the item");
                        } 
                        else {
                            Writer.println("Carrying too much");
                        }
                    } 
                    else {
                        Writer.println("You can't carry not playing item.");
                    }
                }
            }
        }
    }

    /**
     * Makes the player drop an item.
     *
     * @param command command
     */
    private void drop(final Command command) {
        Room currentRoom = playerClass.getRoom();
        if (!command.hasSecondWord()) {
            // if there is no second word, we don't know where to go...
            Writer.println("Drop what?");
        } 
        else {
            String itemName = command.getRestOfLine();
            if (playerClass.getItem(itemName) == null) {
                Writer.println("You don't have it");
            } 
            else {
                Item item = playerClass.getItem(itemName);
                playerClass.removeItem(itemName);
                currentRoom.addItem(item);
                Writer.println("You dropped the item");
            }
        }
    }

    /**
     * Prints player inventory of items taken.
     */
    private void inventory() {
        String inventory = playerClass.getInventoryString();
        if (inventory.isEmpty()) {
            Writer.println("No item carried.");
        } 
        else {
            Writer.println(inventory);
        }
    }

    /**
     * Unpack an item from container.
     *
     * @param command command
     */
    private void unpack(Command command) {
        Room currentRoom = playerClass.getRoom();
        if (!command.hasSecondWord()) {
            // if there is no second word, we don't know where to go...
            Writer.println("Unpack what?");
        } 
        else {
            String containerName = command.getRestOfLine();
            if (currentRoom.getItem(containerName) == null) {
                Writer.println("No such item");
            } 
            else {
                Item containerInRoom = currentRoom.getItem(containerName);
                Item containerWithPlayer = playerClass.getItem(containerName);
                if (containerInRoom == null && containerWithPlayer == null) {
                    Writer.println("you don't have it");
                } 
                else {
                    Item notNullContainer;
                    if (containerInRoom == null) {
                        notNullContainer = containerWithPlayer;
                    }
                    else {
                        notNullContainer = containerInRoom;
                    }
                    if (notNullContainer instanceof Container) {
                        Writer.println("What do you want to unpack from " + containerName + "?");
                        String itemString = Reader.getResponse();
                        Item item = ((Container) notNullContainer).getItem(itemString);
                        if (item == null) {
                            Writer.println("you don't find it");
                        } 
                        else {
                            ((Container) notNullContainer).removeItem(itemString);
                            currentRoom.addItem(item);
                        }

                    } 
                    else {
                        Writer.println("that's not a container");
                    }
                }

            }
        }
    }

    /**
     * Pack an item into a container.
     *
     * @param command command
     */
    private void pack(Command command) {
        Room currentRoom = playerClass.getRoom();
        if (!command.hasSecondWord()) {
            // if there is no second word, we don't know where to go...
            Writer.println("Pack what?");
        } 
        else {
            String itemName = command.getRestOfLine();
            if (currentRoom.getItem(itemName) == null) {
                Writer.println("No such item");
            } 
            else {
                Item itemInRoom = currentRoom.getItem(itemName);
                Item itemWithPlayer = playerClass.getItem(itemName);
                if (itemInRoom == null && itemWithPlayer == null) {
                    Writer.println("you don't have it");
                } 
                else {
                    Item notNullItem;
                    if (itemWithPlayer == null) {
                        notNullItem = itemInRoom;
                    } 
                    else {
                        notNullItem = itemWithPlayer;
                    }
                    if (notNullItem != null) {
                        if (notNullItem.getWeight() > Player.MAX_CARRY_WEIGHT) {
                            Writer.println("too heavy");
                        }
                        else {

                            if (playerClass.carriedWeight() + notNullItem.getWeight() <= Player.MAX_CARRY_WEIGHT) {
                                Writer.print("Which container you want to put on : ");
                                String containerString = Reader.getResponse();
                                Item containerInRoom = currentRoom.getItem(containerString);
                                Item containerWithPlayer = playerClass.getItem(containerString);
                                if (containerInRoom == null && containerWithPlayer == null) {
                                    Writer.println("you don't see the container");
                                } 
                                else {
                                    if (containerInRoom instanceof Container || containerWithPlayer instanceof Container) {
                                        Container container;
                                        if (containerInRoom instanceof Container) {
                                            container = (Container) containerInRoom;
                                        }
                                        else {
                                            container = (Container) containerWithPlayer;
                                        }

                                        // add item to the conainer
                                        container.addItem(notNullItem);
                                        // remove item from player or current room
                                        if (playerClass.getItem(notNullItem.getName()) != null) {
                                            playerClass.removeItem(notNullItem.getName());
                                        } 
                                        else {
                                            currentRoom.removeItem(notNullItem.getName());
                                        }

                                        Writer.println("Packed");
                                    } 
                                    else {
                                        Writer.println("that's not a container");
                                    }
                                }
                            }
                            else {
                                Writer.println("carrying too much");
                            }

                        }
                    }
                }

            }
        }

    }

    /**
     * Unlock a door.
     *
     * @param command command
     */
    private void unlock(Command command) {
        Room currentRoom = playerClass.getRoom();
        if (!command.hasSecondWord()) {
            Writer.println("Unlock what?");
        } 
        else {
            String direction = command.getRestOfLine();
            Door doorway = null;
            doorway = currentRoom.getExit(direction);
            if (doorway == null) {
                Writer.println("no door");
            } 
            else {
                if (!doorway.isLocked()) {
                    Writer.println("door is not locked");
                } 
                else {
                    if (doorway.getKey().equals("")) {
                        Writer.println("door cannot be locked");
                    } 
                    else {
                        Writer.println("With what?");
                        String key = Reader.getResponse();
                        if (doorway.getKey().equals(key)) {
                            doorway.setLocked(false);
                        }
                        else {
                            Writer.println("Incorrect key.");
                        }
                    }
                }
            }
        }

    }

    /**
     * Lock a door with a key.
     *
     * @param command command
     */
    private void lock(Command command) {
        Room currentRoom = playerClass.getRoom();
        if (!command.hasSecondWord()) {
            Writer.println("Lock what?");
        } 
        else {
            String direction = command.getRestOfLine();
            Door doorway = null;
            doorway = currentRoom.getExit(direction);
            if (doorway == null) {
                Writer.println("no door");
            } 
            else {
                if (doorway.isLocked()) {
                    Writer.println("door is already locked");
                } 
                else {
                    if (doorway.getKey().equals("")) {
                        Writer.println("door cannot be locked");
                    } 
                    else {
                        Writer.println("With what?");
                        String key = Reader.getResponse();
                        if (doorway.getKey().equals(key)) {
                            doorway.setLocked(true);
                        }
                        else {
                            Writer.println("Incorrect key.");
                        }
                    }
                }
            }

        }

    }

    /**
     * eat a food item.
     *
     * @param command command
     */
    private void eat(Command command) {
        Room currentRoom = playerClass.getRoom();
        if (!command.hasSecondWord()) {
            Writer.println("eat what?");
        } 
        else {
            String itemName = command.getRestOfLine();
            if (currentRoom.getItem(itemName) == null) {
                Writer.println("No such item");
            } 
            else {
                Item itemInRoom = currentRoom.getItem(itemName);
                Item itemWithPlayer = playerClass.getItem(itemName);
                if (itemInRoom == null && itemWithPlayer == null) {
                    Writer.println("you don't have it");
                } 
                else {
                    Item notNullItem;
                    if (itemWithPlayer == null) {
                        notNullItem = itemInRoom;
                    } 
                    else {
                        notNullItem = itemWithPlayer;
                    }
                    if (notNullItem instanceof Edible) {
                        ((Edible) notNullItem).eat(playerClass);
                        Writer.println(notNullItem.getName() + " eaten");
                    } 
                    else {
                        Writer.println("Not a food");
                    }
                }

            }

        }
    }

    /**
     * Equip a weapon item.
     *
     * @param command command
     */
    private void equip(Command command) {
        Room currentRoom = playerClass.getRoom();
        if (!command.hasSecondWord()) {
            Writer.println("equip what?");
        } 
        else {
            String itemName = command.getRestOfLine();
            if (playerClass.getItem(itemName) == null && currentRoom.getItem(itemName) == null) {
                Writer.println("No such item");
            } 
            else {
                Item itemInRoom = currentRoom.getItem(itemName);
                Item itemWithPlayer = playerClass.getItem(itemName);
                if (itemInRoom == null && itemWithPlayer == null) {
                    Writer.println("you don't have it");
                }
                else {
                    Item notNullItem;
                    if (itemWithPlayer == null) {
                        notNullItem = itemInRoom;
                    } 
                    else {
                        notNullItem = itemWithPlayer;
                    }
                    if (notNullItem instanceof Weapon) {
                        if (((Weapon) notNullItem).isEquiped()) {
                            Writer.println("Already equiped");
                        } 
                        else {
                            ((Weapon) notNullItem).equip();
                            Writer.println("Equiped");
                        }
                    } 
                    else {
                        Writer.println("Not a weapon");
                    }
                }

            }

        }
    }

    /**
     * Unequip a weapon item.
     *
     * @param command command
     */
    private void unequip(Command command) {
        Room currentRoom = playerClass.getRoom();
        if (!command.hasSecondWord()) {
            Writer.println("eat what?");
        } 
        else {
            String itemName = command.getRestOfLine();
            if (currentRoom.getItem(itemName) == null) {
                Writer.println("No such item");
            } 
            else {
                Item itemInRoom = currentRoom.getItem(itemName);
                Item itemWithPlayer = playerClass.getItem(itemName);
                if (itemInRoom == null && itemWithPlayer == null) {
                    Writer.println("you don't have it");
                } 
                else {
                    Item notNullItem;
                    if (itemWithPlayer == null) {
                        notNullItem = itemInRoom;
                    } 
                    else {
                        notNullItem = itemWithPlayer;
                    }
                    if (notNullItem instanceof Equippable) {
                        if (!((Equippable) notNullItem).isEquiped()) {

                            Writer.println("Already unequiped");
                        } 
                        else {
                            ((Equippable) notNullItem).equip();
                            Writer.println("Unequiped");
                        }
                    } 
                    else {
                        Writer.println("Not a weapon");
                    }
                }

            }

        }
    }

    /**
     * Switch off a switchable item.
     *
     * @param command command
     */
    private void switchoff(Command command) {
        Room currentRoom = playerClass.getRoom();
        if (!command.hasSecondWord()) {
            Writer.println("switchoff what?");
        }
        else {
            String itemName = command.getRestOfLine();
            if (currentRoom.getItem(itemName) == null) {
                Writer.println("No such item");
            } 
            else {
                Item itemInRoom = currentRoom.getItem(itemName);
                Item itemWithPlayer = playerClass.getItem(itemName);
                if (itemInRoom == null && itemWithPlayer == null) {
                    Writer.println("you don't have it");
                }
                else {
                    Item notNullItem;
                    if (itemWithPlayer == null) {
                        notNullItem = itemInRoom;
                    } 
                    else {
                        notNullItem = itemWithPlayer;
                    }
                    if (notNullItem instanceof Switchable) {
                        if (!((Switchable) notNullItem).isOn()) {

                            Writer.println("Already off.");
                        }
                        else {
                            ((Switchable) notNullItem).switchOff();
                            Writer.println("Switched off");
                        }
                    }
                    else {
                        Writer.println("Not a switchable");
                    }
                }

            }

        }
    }

    /**
     * Switch on a switchable item.
     *
     * @param command command
     */
    private void switchon(Command command) {
        Room currentRoom = playerClass.getRoom();
        if (!command.hasSecondWord()) {
            Writer.println("switchoff what?");
        } 
        else {
            String itemName = command.getRestOfLine();
            if (currentRoom.getItem(itemName) == null) {
                Writer.println("No such item");
            } 
            else {
                Item itemInRoom = currentRoom.getItem(itemName);
                Item itemWithPlayer = playerClass.getItem(itemName);
                if (itemInRoom == null && itemWithPlayer == null) {
                    Writer.println("you don't have it");
                } 
                else {
                    Item notNullItem;
                    if (itemWithPlayer == null) {
                        notNullItem = itemInRoom;
                    } 
                    else {
                        notNullItem = itemWithPlayer;
                    }
                    if (notNullItem instanceof Switchable) {
                        if (((Switchable) notNullItem).isOn()) {

                            Writer.println("Already off.");
                        }
                        else {
                            ((Switchable) notNullItem).switchOn();
                            Writer.println("Switched on");
                        }
                    }
                    else {
                        Writer.println("Not a switchable");
                    }
                }

            }

        }
    }

    /**
     * Talk to a npc who can talk.
     *
     * @param command command
     */
    private void talk(Command command) {
        Room currentRoom = playerClass.getRoom();
        if (!command.hasSecondWord()) {
            Writer.println("talk to what?");
        } 
        else {
            String name = command.getRestOfLine();
            if (currentRoom.getCharacter(name) == null) {
                Writer.println("No such character.");
            } 
            else {
                // character change to character1
                Character character1 = currentRoom.getCharacter(name);
                if (character1.isCanTalk()) {
                    NPC npc = (NPC) character1;
                    if (npc instanceof Adviser) {
                        Writer.println(((Adviser) npc).advice(currentRoom, playerClass));
                    } 
                    else {
                        Conversation conversation = npc.getConversation();
                        conversation.startConversation("hi");
                    }

                }
                else {
                    Writer.println(name + " can't talk.");
                }

            }

        }
    }

    /**
     * Shop method.
     *
     * @param command for command
     */
    private void shop(Command command) {
        Room currentRoom = playerClass.getRoom();
        if (!command.hasSecondWord()) {
            Writer.println("shop what?");
        } 
        else {
            String name = command.getRestOfLine();
            Character character1 = currentRoom.getCharacter(name);
            if (character1 == null) {
                Writer.println("No such merchant.");
            } 
            else {
                if (character1 instanceof Merchant) {
                    Writer.println(((Merchant) character1).toString());
                    String item = Reader.getResponse();
                    Item item1 = ((Merchant) character1).getItem(item.toLowerCase());
                    if (item1 == null) {
                        Writer.println("Item not available.");
                    } 
                    else {
                        if (((Merchant) character1).getPrice(item.toLowerCase()) <= playerClass.getMoney()) {
                            if (playerClass.carriedWeight() + item1.getWeight() <= Player.MAX_CARRY_WEIGHT) {
                                playerClass.addItem(item1);
                            } 
                            else {
                                currentRoom.addItem(item1);
                            }
                            playerClass.setMoney(playerClass.getMoney() - ((Merchant) character1).getPrice(item.toLowerCase()));
                            Writer.println("You bought the item.");
                            if (playerClass.carriedWeight() + item1.getWeight() > Player.MAX_CARRY_WEIGHT) {
                                playerClass.addItem(item1);
                            } 
                            else {
                                currentRoom.addItem(item1);
                            }
                            ((Merchant) character1).removeItem(item1);
                        } 
                        else {
                            Writer.println("Sorry you don't have enough money.");
                        }
                    }
                } 
                else {
                    Writer.println(name + " is not a merchant.");
                }

            }

        }
    }

    /**
     * kill method: make possible for the player to kill an enemy with a weapon.
     * @param command 
     */
    private void kill(Command command) {
        Room currentRoom = playerClass.getRoom();
        if (!command.hasSecondWord()) {
            Writer.println("kill what?");
        } 
        else {
            String name = command.getRestOfLine();
            Character character = currentRoom.getCharacter(name);
            if (character == null) {
                Writer.println("No such enemy.");
            } 
            else {
                if (character instanceof Enemy) {
                    Weapon weapon = playerClass.getEquippedWeapon();
                    if (weapon == null) {
                        Writer.println("You don't have any weapon to kill the enemy.");
                    } 
                    else {
                        if (weapon.isEquiped()) {
                            if (character instanceof Thief) {
                                for (Item item : ((Thief) character).getStolen()) {
                                    currentRoom.addItem(weapon);
                                }
                                playerClass.setMoney(playerClass.getMoney() + ((Thief) character).getMoney());
                                currentRoom.kill(character);
                                Writer.println("You killed one enenmy.");
                            }
                        } 
                        else {
                            Writer.println("Please equip your weapon to be able to kill the enemy.");
                        }
                    }
                }
                else {
                    Writer.println("Character is not an enemy.");
                }
            }
        }
    }

}
