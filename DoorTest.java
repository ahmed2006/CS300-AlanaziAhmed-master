
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author a
 */
public class DoorTest {

    public DoorTest() {
    }

    /**
     * Test of getDestination method, of class Door.
     */
    @Test
    public void testGetDestination() {
        System.out.println("getDestination");
        Door instance = new Door(new Room("Room1", "Some description"));
        Room expResult = new Room("Room1", "Some description");
        Room result = instance.getDestination();
        assertEquals(expResult.getName(), result.getName());
        assertEquals(expResult.getDescription(), result.getDescription());
    }

    /**
     * Test of isLocked method, of class Door.
     */
    @Test
    public void testIsLocked() {
        System.out.println("isLocked");
        Door instance = new Door(new Room("1", "desc"), true, "d");
        boolean expResult = true;
        boolean result = instance.isLocked();
        assertEquals(expResult, result);
    }

    /**
     * Test of setLocked method, of class Door.
     */
    @Test
    public void testSetLocked() {
        System.out.println("setLocked");
        boolean locked = false;
        Door instance = new Door(new Room("1", "desc"), true, "d");
        instance.setLocked(locked);
        assertEquals(instance.isLocked(), locked);
    }

    /**
     * Test of getKey method, of class Door.
     */
    @Test
    public void testGetKey() {
        System.out.println("getKey");
        Door instance = new Door(new Room("1", "desc"), true, "daa");
        String expResult = "daa";
        String result = instance.getKey();
        assertEquals(expResult, result);
    }

}
