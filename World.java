import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/**
 * This class represents the entire world that makes up the "The Ghost Game"
 * application. "The Ghost Game" is a very simple, text based adventure game.
 * Users can walk around some scenery. That's all. It should really be extended
 * to make it more interesting!
 *
 * This world class creates the world where the game takes place.
 *
 * @author ahmed
 * @version 2018-04-04
 */
public class World {
    /**
     * The rooms in the world.
     */
    private HashMap<String, Room> rooms;
    /**
     * The items in the world.
     */
    private List<Item> items;

    /**
     * Constructor for the world.
     */
    public World() {
        rooms = new HashMap<String, Room>();
        this.items = new ArrayList<Item>();
        createRooms();
        createItems();
        createCharactes();
    }

    /**
     * This method takes care of creating all of the aspects of the world for
     * the "The Ghost Game" application.
     *
     * @param name The provided name of the room.
     * @return The room associated with the provided name
     */
    public Room getRoom(String name) {
        return rooms.get(name.toLowerCase());
    }

    /////////////////////////////////////////////////////////////////////////////////////
    // Start of private helper methods
    /**
     * Helper method for recreating a Room. Ensure that the room is created and
     * installed in to the collection of Rooms
     *
     * @param theRoom The room to add to the world.
     */
    private void addRoom(Room theRoom) {
        rooms.put(theRoom.getName().toLowerCase(), theRoom);
    }

    /**
     * H elp e r method f o r c r e a t i n g d o o r s between rooms .
     *
     * @param from The room where the door originates .
     * @param direction The direction of the door in the from room .
     * @param to The room where the door goes .
     */
    private void createDoor(Room from, String direction, Room to) {
        Door door = new Door(to);
        from.setExit(direction, door);
    }

    /**
     * main method .
     *
     * @param args args
     */
    public static void main(String args[]) {
        // Room world = new Room();
    }

    /**
     * This method creates all of the individual places in this world and all
     * the doors connecting them.
     */
    private void createRooms() {
        //Room setPoints = new Room(5);
        // Creating all the rooms.// 5 floor
        Room classRoom1 = new Room("ClassRoom1", "4 doors, 10 computers,10 tables,a board, touch a computer,show direction,use key.");
        classRoom1.setPoints(5);

        Room classRoom2 = new Room("ClassRoom2", "4 doors, 10 computers,10 tables,a board, touch a computer,show direction,use key.");
        classRoom2.setPoints(5);

        Room wc1 = new Room("wc1", "bathroom");

        Room office1 = new Room("Office1", "five tables and one printer, 3 laptops, 3 doors,touch the laptop.");
        office1.setPoints(5);

        Room classRoom3 = new Room("classRoom3", "4 doors, 10 computers,10 tables,a board, touch a computer,show direction,use ke.");
        classRoom3.setPoints(5);

        Room classRoom4 = new Room("classRoom4 ", " 4 doors, 10 computers,10 tables,a board, touch a computer,show direction,use key.");
        classRoom4.setPoints(5);

        // 4 floor
        Room classRoom5 = new Room("classRoom", "4 doors, 9 computers,8 tables,a board,a projector,touch table show direction.");
        classRoom5.setPoints(5);

        Room library = new Room("library", "20 computers, 5 printers, 3 blackboards,100 books, printer show direction .");
        library.setPoints(5);

        Room office2 = new Room("office2", "five tables,a printer,3 laptops,files,3 doors,touch one laptop.");
        office2.setPoints(5);

        Room classRoom6 = new Room("classroom6", "4 doors, the class contains 6 computers, 12 tables, one board.");
        classRoom6.setPoints(5);

        Room closet1 = new Room("closet1", "storage has some extra chairs and tables ");
        // classRoom1.setPoints(5);
        Room classRoom7 = new Room("classroom7", " 3 doors,9 computers,8 tables,a board,a projector.");
        classRoom7.setPoints(5);

        // F -3      1
        Room classRoom8 = new Room("classroom8", "3 doors,2 windows, 20 tables,20 chairs, blackboard, a computer.");
        classRoom8.setPoints(5);
        // 2      //Room closet = new Room("closet","storage has some extra chairs and tables ");
        // 3
        Room closet2 = new Room("closet2", "3 sofas , 2 tables, soda machine.");
        // closet2.setPoints(5);
        // 5
        Room coffee = new Room("café", "coffee machine , 10 tables, 12 lights, 15 chairs.");
        coffee.setPoints(5);

        Room wc2 = new Room("bathroom2", "bathroom");
        // 4
        Room classRoom9 = new Room("classroom9", "2 doors,one window ,5 tables,6 chairs,a projector.");
        classRoom9.setPoints(5);

        //waitingRoom : window (
        Room waitingRoom = new Room("waitingRoom", "colder water, 5 chairs .");
        waitingRoom.setPoints(5);

        // second f 
        Room classRoom10 = new Room("classRoom10", "3 doors, one window, 10 tables 12 chairs, blackboard.");
        classRoom10.setPoints(5);

        Room closet3 = new Room("closet2", "3 sofas , 2 tables, soda machine.");

        Room computerLab = new Room("computerlab", "progector,10 tables, 10 chairs, printer, 10 speakers.");
        computerLab.setPoints(5);

        Room classRoom11 = new Room("classRoom11", "2 doors, 5 tables, 7 chairs.");
        classRoom11.setPoints(5);

        Room classRoom12 = new Room("classRoom12", "3 doors,2 window,5 tables,7 chairs,blackboard.");
        classRoom12.setPoints(5);
        Room classRoom13 = new Room("classRoom13", "8 tables 12 chairs, projector.");
        classRoom13.setPoints(5);
        // 1
        // Room classRoom14 = new Room("classRoom14","8 tables 12 chairs, projector.");
        //classRoom14.setPoints(5);
        //Room classRoom15 = new Room("classRoom15","4 windows, 10 tables, 12 chairs, soda machine, coffee machine.");
        //classRoom15.setPoints(5);

        // Room exit = new Room("exit", "4 doors, 3 windows, 10 chairs, 4 flags .");
        Room exit = new Room("exit", "Congratulations, you win !");
        exit.setPoints(5);
        // Adding all the rooms to the world.
        this.addRoom(classRoom1);
        this.addRoom(classRoom2);
        this.addRoom(wc1);
        this.addRoom(office1);
        this.addRoom(classRoom3);
        this.addRoom(classRoom4);
        this.addRoom(classRoom5);
        this.addRoom(library);
        this.addRoom(office2);
        this.addRoom(classRoom6);
        this.addRoom(closet1);
        this.addRoom(classRoom7);
        this.addRoom(classRoom8);
        this.addRoom(closet2);
        this.addRoom(coffee);
        this.addRoom(wc2);
        //this.addRoom(lounge2);          
        this.addRoom(classRoom9);

        this.addRoom(waitingRoom);
        this.addRoom(classRoom10);
        this.addRoom(closet3);
        this.addRoom(computerLab);
        this.addRoom(classRoom11);

        this.addRoom(classRoom12);
        this.addRoom(classRoom13);
        this.addRoom(exit);

        // Creating all the doors between the rooms.
        this.createDoor(classRoom1, "east", classRoom2);
        this.createDoor(classRoom2, "west", classRoom1);
        this.createDoor(classRoom2, "south", wc1);
        this.createDoor(wc1, "north", classRoom2);

        this.createDoor(classRoom2, "east", office1);
        this.createDoor(office1, "west", classRoom2);

        this.createDoor(office1, "east", classRoom3);
        this.createDoor(classRoom3, "west", office1);

        this.createDoor(classRoom3, "east", classRoom4);
        this.createDoor(classRoom4, "west", classRoom3);

        this.createDoor(classRoom4, "south", classRoom5);
        this.createDoor(classRoom5, "north", classRoom4);

        this.createDoor(classRoom5, "east", library);
        this.createDoor(library, "west", classRoom5);

        this.createDoor(library, "east", office2);
        this.createDoor(office2, "west", library);

        this.createDoor(office2, "east", classRoom6);
        this.createDoor(classRoom6, "west", office2);

        this.createDoor(classRoom6, "south", closet1);
        this.createDoor(closet1, "north", classRoom6);

        this.createDoor(closet1, "west", classRoom7);
        this.createDoor(classRoom7, "east", closet1);

        this.createDoor(classRoom7, "west", classRoom8); //lounge2
        this.createDoor(classRoom8, "east", classRoom7);
        this.createDoor(classRoom8, "east", closet2);

        this.createDoor(classRoom8, "south", coffee);
        this.createDoor(coffee, "north", classRoom8);
        this.createDoor(coffee, "west", wc2);
        this.createDoor(wc2, "east", coffee);
        this.createDoor(coffee, "east", classRoom9);
        this.createDoor(classRoom9, "west", coffee);

        this.createDoor(classRoom9, "east", waitingRoom);
        this.createDoor(waitingRoom, "west", classRoom9);

        this.createDoor(waitingRoom, "south", classRoom10);
        this.createDoor(classRoom10, "north", waitingRoom);

        this.createDoor(classRoom10, "east", closet3);
        this.createDoor(closet3, "west", classRoom10);

        this.createDoor(classRoom10, "west", computerLab);
        this.createDoor(computerLab, "east", classRoom10);

        this.createDoor(computerLab, "west", classRoom11);
        this.createDoor(classRoom11, "east", computerLab);

        this.createDoor(classRoom11, "south", classRoom12);
        this.createDoor(classRoom12, "north", classRoom11);

        this.createDoor(classRoom12, "east", classRoom13);
        this.createDoor(classRoom13, "west", classRoom12);
        this.createDoor(classRoom13, "east", exit);
    }

    /**
     * This method creates all of the items and places them in this world.
     */
    public void createItems() {
        Item item1 = new Item("Book", "a written or printed work consisting of pages of many pages.", 10, 30);
        Item item2 = new Item("Calculator", "Used to add, substract,multiply and divide numbers", 2, 14);
        Item item3 = new Item("Watch", "Hand watch.", 32, 20);
        Item item4 = new Item("Glasses", "Used to correct or assist defective eyesight.", 32, 20);
        Item item5 = new Item("picture", "");

        Item banana = new Food("Banana", "fresh banana", 2, 2);
        Item sandwich = new Food("sandwich", "sandwich", 3, 3);
        Item knife = new Weapon("knife", "knife", 15, 6);
        Item flashlight = new LightSource("flashlight", "flashlight", 10, 4);
        Item lightSaber = new LightSaber("Light Saber", "Light Saber", 20, 5);

        Container container = new Container("Balls", "", 2, 4);
        Item tennis = new Item("Tennis", "Tennis", 2, 3);
        Item baseball = new Item("Baseball", "Tennis", 2, 4);
        Item football = new Item("Football", "Tennis", 2, 7);
        Item basketball = new Item("Basketball", "Basketball", 2, 8);
        Item golf = new Item("Golf", "Golf", 2, 3);

        items.add(item1);
        items.add(item2);
        items.add(item3);
        items.add(item4);
        items.add(item5);

        container.addItem(tennis);
        container.addItem(baseball);
        container.addItem(football);
        container.addItem(basketball);
        container.addItem(golf);

        rooms.get("ClassRoom1".toLowerCase()).addItem(container);
        rooms.get("ClassRoom1".toLowerCase()).addItem(item1);
        rooms.get("ClassRoom1".toLowerCase()).addItem(item2);
        rooms.get("ClassRoom1".toLowerCase()).addItem(item5);
        Weapon gun = new Weapon("Gun", "Gun", 20, 4);
        rooms.get("ClassRoom1".toLowerCase()).addItem(gun);
        rooms.get("Office1".toLowerCase()).addItem(item3);

    }

    /**
     * This method creates all of the NPC and places them in this world.
     */
    public void createCharactes() {
        Conversation conversation = new Conversation("Ahmed", "goodbye");
        conversation.addReply("Hi", "Welcome to the Conversation Class. What can I help you\n"
                + "with?\n"
                + "a) I want to have a conversation.\n"
                + "b) I don’t understand which class should store my conversation.\n"
                + "c) I have no idea what is going on");
        conversation.addReply("hia", "So you want to have a conversation, huh? Do you want to\n"
                + "talk about why the sky is blue?\n"
                + "a) Not really.\n"
                + "b) If you really want to.");
        conversation.addReply("hiab", "Did you know that the sky is blue because molecules in the\n"
                + "air scatter blue light from the sun more than they scatter red light?\n"
                + "a) No I didn’t.\n"
                + "b) Yes I did.");
        conversation.addReply("hiabb", "Wow, you are smart, aren’t you. ");
        conversation.addReply("hiabbgoodbye", "You can use the final key to cause something to\n"
                + "happen in your game if the right thread was followed.goodbye");
        conversation.addReply("hiaa", "goodbye");
        conversation.addReply("hiaba", "goodbye");
        conversation.addReply("hib", "Conversation class. goodbye.");
        conversation.addReply("hic", "goodbye.");
        NPC npc1 = new NPC("Robot", "Talking robot.", conversation);
        Merchant shop = new Merchant("shop", "Sells items.");
        Item banana = new Food("Banana", "fresh banana", 2, 10);
        shop.addItem(banana, 20);
        rooms.get("ClassRoom1".toLowerCase()).addCharacter(npc1);
        rooms.get("ClassRoom1".toLowerCase()).addCharacter(shop);
        Enemy enemy = new Thief("Thief", "Can steal players.");
        NPC adviser  = new Adviser("Adviser", "Knows about the room.");        
        
        rooms.get("ClassRoom1".toLowerCase()).addCharacter(enemy);
        rooms.get("ClassRoom1".toLowerCase()).addCharacter(adviser);
        
    }
}
