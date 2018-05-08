import org.testng.annotations.Test;

import java.util.ArrayList;

import static org.testng.Assert.*;

public class TestGroup {

    @Test
    public static void testConstructDefaultAndGetters() {
        Group obj = new Group(1, 2,5);
        assertNotNull(obj);
        int[] arr = {2,5};
        assertEquals(obj.getId(), 1);
        assertEquals(obj.getArrayInt(), arr);
    }

    @Test
    public static void testConstructWithDataAndCopy() {
        Group obj = new Group(100, 1, 2, 3, 4, 5);
        assertNotNull(obj);
        Group copyObj = new Group(obj);
        assertNotNull(copyObj);
        int[] res = {1,2,3,4,5};
        assertEquals(copyObj.getId(), 100);
        assertEquals(copyObj.getArrayInt(), res);
    }

    @Test
    public static void testLength(){
        Group obj = new Group(23, 10, 18, 0, 9, 3, 1, 0, 7);
        assertEquals(obj.getLength(), 8);
    }

    @Test
    public static void testSetDataAndId(){
        Group obj = new Group(12, 23, 3,5,6,7,83,343);
        obj.setArrayInt(1,2,3);
        int[] res = {1, 2, 3};
        assertEquals(obj.getArrayInt(), res);
        obj.setId(1);
        assertEquals(obj.getId(), 1);
    }
}
