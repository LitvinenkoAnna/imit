import TestClasses.Human;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class ReflectionDemo {

    public static int countHuman(List<Object> objectList ){
        int count = 0;
        for(Object item: objectList){
            if(item instanceof Human){
                count++;

            }

        }
            return count;
    }
    public static List<String>  listName(Object object){
        List<String> result = new ArrayList<String>();
        for(Method method: object.getClass().getMethods()){
            result.add(method.getName());
        }
        return result;

    }

    public static List<String> superClassName(Object object){
    List<String> result = new ArrayList<String>();
    Class cl = object.getClass().getSuperclass();
    while(cl != null){
        result.add(cl.getSimpleName());
        cl = cl.getSuperclass();
    }
    return result;
    }

}














