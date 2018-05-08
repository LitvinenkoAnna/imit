
import org.testng.annotations.Test;

import java.util.ArrayList;

import static org.testng.Assert.assertEquals;

public class TestDataDemo {

    @Test
    public static void testGetAll() {
        Data obj = new Data("Luis", new Group(1, 1, 2, 3), new Group(2, 4, 5),
                new Group(5, 6, 7));

        ArrayList<Integer> res = new ArrayList<Integer>();
        res.add(1);
        res.add(2);
        res.add(3);
        res.add(4);
        res.add(5);
        res.add(6);
        res.add(7);
        assertEquals(DataDemo.getAll(obj), res);
    }
}
