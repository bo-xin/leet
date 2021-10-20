package 字符串;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class leet1436 {
    public String destCity(List<List<String>> paths) {
        Map<String,String> map = new HashMap<>();
        for (List<String> list : paths){
            map.put(list.get(0),list.get(1));
        }
        String start = paths.get(0).get(0);
        String end = paths.get(0).get(1);
        while (map.containsKey(start)){
            System.out.println(start);
            start = map.get(map.get(start));
            end = map.get(start);
        }
        return end;
    }
}
