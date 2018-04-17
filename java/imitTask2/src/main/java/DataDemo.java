import java.util.ArrayList;
import java.util.List;

public class DataDemo {

    public static List<Integer> getAll(Data data){

        List<Integer> list  = new ArrayList<Integer>();
        DataIterator iter  = new DataIterator(data);
        while(iter.hasNext()){
            list.add(iter.next());

        }
        return  list;
    }
}
