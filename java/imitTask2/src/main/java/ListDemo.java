import javax.swing.text.html.HTMLDocument;
import java.util.*;

public class ListDemo {

    public static int checkString(List<String> string, char symbol) {

        int count = 0;
        for (int i = 0; i < string.size(); i++) {
            if (string.get(i).charAt(0) == symbol) {
                count++;
            }

        }
        return count;
    }

    public static List<Human> checkSurname(List<Human> list, Human human) {
        List<Human> result = new ArrayList<Human>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getSurname().equals(human.getSurname())) {
                result.add(list.get(i));
            }
        }
        return result;
    }

    public static List<Human> removeHuman(List<Human> list, Human human) {
        List<Human> copyList = new ArrayList<Human>();

        for (int i = 0; i < list.size(); i++) {
            if (!list.get(i).equals(human)) {
                copyList.add(new Human(list.get(i)));
            }

        }
        return copyList;
    }

    public static List<Set<Integer>> removeSet(List<Set<Integer>> set, Set<Integer> setInteger) {
        List<Set<Integer>> result = new ArrayList<Set<Integer>>();
        Iterator<Integer> iterator = setInteger.iterator();
        for (int i = 0; i < set.size(); i++) {
            while (iterator.hasNext()) {
                if (set.get(i).contains(iterator.next())) {
                    break;
                }
                if (!iterator.hasNext()) {
                    result.add(set.get(i));
                }
            }
            iterator = setInteger.iterator();
        }
        return result;
    }

    public static Set<Human> findHumans(Map<Integer, Human> map, Set<Integer> setInteger) {
        Set<Human> setHumans = new HashSet<Human>();
        int key;
        Iterator<Integer> iterator = setInteger.iterator();
        while (iterator.hasNext()) {
            key = iterator.next();
            if (map.containsKey(key)) {
                setHumans.add(map.get(key));
            }
        }
        return setHumans;
    }
    public static List<Integer> AgeMore18 (Map<Integer, Human> map){
        List<Integer> listInteger = new ArrayList<Integer>();
        Set<Integer> integerSet = map.keySet();
        int key;
        Iterator<Integer> iterator = integerSet.iterator();
        while(iterator.hasNext()){
            key = iterator.next();
            if(map.get(key).getYearOfBirth()<2001){
                listInteger.add(key);
            }
        }return listInteger;
    }

}
