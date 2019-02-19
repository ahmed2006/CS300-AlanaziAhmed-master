
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author a
 */
public class RoomTest {

    public RoomTest() {
    }

    /**
     * Test of getName method, of class Room.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        Room instance = new Room("name", "description");
        String expResult = "name";
        String result = instance.getName();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDescription method, of class Room.
     */
    @Test
    public void testGetDescription() {
        System.out.println("getDescription");
        Room instance = new Room("name", "description");
        String expResult = "description";
        String result = instance.getDescription();
        assertEquals(expResult, result);
    }

    /**
     * Test of getExit method, of class Room.
     */
    @Test
    public void testGetExit() {
        System.out.println("getExit");
        String direction = "west";
        Room instance1 = new Room("name1", "description");
        Door door = new Door(instance1);
        instance1.setExit(direction, door);
        Door result = instance1.getExit(direction);
        assertEquals(door, result);
    }
}
