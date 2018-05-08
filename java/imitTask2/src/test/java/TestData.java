
import org.testng.annotations.Test;

import java.util.ArrayList;

import static org.testng.Assert.*;

public class TestData {

    @Test
    public static void testConstruct() {
        Data obj = new Data("1",new Group(1,1,2));
        assertNotNull(obj);
        assertEquals(obj.getId(), "1");
        Group[] groups = {new Group(1,1,2)};
        assertEquals(obj.getGroups(), groups );
    }



    @Test
    public static void testConstructCopy(){
        Data obj = new Data("Jhonny", new Group(1,1,2),
                new Group(1, 1, 2, 3), new Group(2, 2, 8));
        Data copyObj = new Data(obj);
        assertNotNull(copyObj);
        assertEquals(obj.getGroups(), copyObj.getGroups());
        assertEquals(copyObj.getId(), obj.getId());
    }

    @Test
    public static void testSetters() {
        Data obj = new Data("1", new Group(1,1,2));
        obj.setId("Polly");
        Group[] groups = {new Group(1,1,1,1,1), new Group(2,2,2,2), new Group(3,3)};
        assertEquals(obj.getId(), "Polly");
        obj.setGroup(new Group(1,1,1,1,1), new Group(2,2,2,2), new Group(3,3));
        assertEquals(obj.getGroups(), groups);
    }

    @Test
    public static void testLength(){
        Data obj = new Data("1");
        assertEquals(obj.getSize(), 0);
        Group[] groups = {new Group(1,1,1,1,1), new Group(2,2,2,2), new Group(3,3)};
        obj.setGroup(groups);
        assertEquals(obj.getSize(), 3);
    }

    @Test
    public static void testIterator(){
        Data obj = new Data("Jhonny", new Group(1,1,2),
                new Group(1, 23, 2, 3), new Group(2, 2, 8));
        assertNotNull(obj.iterator());
        assertTrue(obj.iterator().hasNext());
        assertEquals(obj.iterator().next(), (Integer)1);
    }
}
