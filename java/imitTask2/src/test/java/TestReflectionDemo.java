import TestClasses.A;
import TestClasses.Group;
import TestClasses.Human;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class TestReflectionDemo {
    @Test
    public static void testCountHuman(){

        List<Object> objectList = new ArrayList<Object>();
        objectList.add(new Human("Anna","Litvinenko", "Anatol'evna",1998));
        objectList.add(new Human("Olga","Litvinenko", "Anatol'evna",1997));
        objectList.add(new Human("Elena","Litvinenko", "Anatol'evna",1995));
        objectList.add(new Group(1, 1,2,5));
        objectList.add(new Object());
        objectList.add("Аня - молодец☺");
        Assert.assertEquals(ReflectionDemo.countHuman(objectList), 3);


    }

    @Test
    public static void testListName(){
    List<String> result = new ArrayList<String>();
    Group group = new Group(1);
    result.add("getId");
    result.add("setId");
    result.add("setArrayInt");
    result.add("getArrayInt");
    result.add("getLength");
    result.add("getClass");
    result.add("hashCode");
    result.add("equals");
    result.add("toString");
    result.add("notify");
    result.add("notifyAll");
    result.add("wait");
    result.add("wait");
    result.add("wait");
    Assert.assertTrue(result.containsAll(ReflectionDemo.listName(group)));
    Assert.assertTrue(ReflectionDemo.listName(group).containsAll(result));
    }

    @Test
    public  static  void testSuperClassName(){
    List<String> result = new ArrayList<String>();
    A a = new A("Anna","Litvinenko", "a",1998);
    result.add("Human");
    result.add("Object");
    Assert.assertTrue(result.containsAll(ReflectionDemo.superClassName(a)));
    Assert.assertTrue(ReflectionDemo.superClassName(a).containsAll(result));

    }
}
