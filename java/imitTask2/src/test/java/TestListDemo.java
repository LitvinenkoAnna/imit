import org.testng.annotations.Test;

import java.util.*;

import static org.testng.AssertJUnit.assertEquals;

public class TestListDemo {

    @Test
    public static void checkStringTest(){
        List<String> list = new ArrayList<String>();
        list.add("adc");
        list.add("cdj");
        list.add("12gg");
        list.add("0abc");
        list.add("apo");
        assertEquals(ListDemo.checkString(list, 'a'),2);
        assertEquals(ListDemo.checkString(list, '0'),1);

    }
    @Test
    public static void checkSurnameTest(){
        List<Human> listHuman = new ArrayList<Human>();
        List<Human> listHuman2 = new ArrayList<Human>();
        listHuman.add(new Human("ad", "ad", "ad", 1985));
        listHuman.add(new Human("Litvinenko","Anna", "Anatol'evna",1998));
        listHuman2.add(new Human("Litvinenko","Anna", "Anatol'evna",1998));
        assertEquals(ListDemo.checkSurname(listHuman, new Human("Litvinenko", "Anna",
                "Anatol'evna", 1998)), listHuman2);
    }

    @Test
    public static void removeHumanTest(){
        List<Human> listHuman = new ArrayList<Human>();
        listHuman.add(new Human("Litvinenko","Anna", "Anatol'evna",1998));
        assertEquals(ListDemo.removeHuman(listHuman, new Human("Litvinenko","Anna",
                "Anatol'evna",1998)), new ArrayList<Human>());
    }

    @Test
    public static void removeSetTest(){
    List<Set<Integer>> list = new ArrayList<Set<Integer>>();
    Set<Integer> set = new HashSet<Integer>();
    List<Set<Integer>> res = new ArrayList<Set<Integer>>();
    set.add(1);
    set.add(2);
    set.add(3);
    set.add(4);
    list.add(set);
    set = new HashSet<Integer>();
    set.add(2);
    set.add(3);
    set.add(4);
    res.add(set);
    list.add(set);
    set = new HashSet<Integer>();
    set.add(1);
    set.add(3);
    set.add(4);
    list.add(set);
    set = new HashSet<Integer>();
    set.add(1);
    assertEquals(ListDemo.removeSet(list, set), res);
    //ListDemo.removeSet(list, )
    }

    @Test
    public static void findHumansTest(){
        Map<Integer, Human> map = new HashMap<Integer, Human>();
        Set<Human> setHumans = new HashSet<Human>();
        Set<Integer> setInteger = new HashSet<Integer>();
        map.put(0, new Human("Litvinenko","Anna",
                "Anatol'evna",1998));
        map.put(1, new Human("Litvinenko","Anna",
                "Anatol'evna",1999));
        map.put(3, new Human("Litvinenko","Anna",
                "Anatol'evna",2000));
        setInteger.add(0);
        setInteger.add(1);
        setInteger.add(2);
        setInteger.add(4);
        setInteger.add(5);
        setHumans.add(new Human("Litvinenko","Anna",
                "Anatol'evna",1998));
        setHumans.add(new Human("Litvinenko","Anna",
                "Anatol'evna",1999));

        assertEquals(ListDemo.findHumans(map,setInteger), setHumans);

    }
    @Test
    public static void AgeMore18Test(){
        Map<Integer, Human> map = new HashMap<Integer, Human>();
        List<Integer> listInteger = new ArrayList<Integer>();
        listInteger.add(0);
        listInteger.add(1);
        map.put(0,new Human("Litvinenko","Anna",
                "Anatol'evna",1998));
        map.put(1,new Human("Litvinenko","Anna",
                "Anatol'evna",1999));
        map.put(2,new Human("Litvinenko","Anna",
                "Anatol'evna",2002));
        assertEquals(ListDemo.AgeMore18(map), listInteger);
    }
}
