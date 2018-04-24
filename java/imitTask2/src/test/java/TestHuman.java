import org.testng.annotations.Test;

import static org.testng.Assert.assertNotNull;
import static org.testng.AssertJUnit.assertEquals;

public class TestHuman {

    @Test
    public static void HumanTest(){
        Human human = new Human("Litvinenko","Anna", "Anatol'evna",1998);
        assertNotNull(human);
    }

    @Test
    public static void HumanTestCopy(){
        Human human = new Human("Litvinenko","Anna", "Anatol'evna",1998);
        Human copy = new Human(human);
        assertNotNull(copy);
        assertEquals(human.getSurname(),copy.getSurname());
        assertEquals(human.getFirstName(),copy.getFirstName());
        assertEquals(human.getPatronymic(),copy.getPatronymic());
        assertEquals(human.getYearOfBirth(),copy.getYearOfBirth());
    }


}
