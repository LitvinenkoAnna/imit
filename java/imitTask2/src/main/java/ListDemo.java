import java.util.ArrayList;
import java.util.List;

public class ListDemo {

    public static int checkString(List<String> string, char symbol){

        int count = 0;
        for(int i = 0; i<string.size(); i++){
            if(string.get(i).charAt(0)==symbol){
                count++;
            }

        }return count;
    }
    public static List<Human> checkSurname(List<Human> list, Human human){
        List<Human> result = new ArrayList<Human>();
        for(int i = 0; i<list.size(); i++){
            if(list.get(i).getSurname().equals(human.getSurname())){
                result.add(list.get(i));
            }
        }return result;
    }
    public static List<Human> removeHuman(List<Human> list, Human human){
        List<Human> copyList = new ArrayList<Human>();

        for(int i = 0; i<list.size(); i++){
                if(!list.get(i).equals(human)){
                    copyList.add(new Human(list.get(i)));
                }

        } return copyList;
    }
}
