package 题解;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class leet690 {
    class Employee{
        public int id;
        public int importance;
        public List<Integer> subordinates;
    }
    Map<Integer,Employee> map = new HashMap<>();
    public int getImportance(List<Employee> employees, int id) {
        int n = employees.size();
        for(int i = 0;i<n;i++) map.put(employees.get(i).id,employees.get(i));
        return dfs(id);
    }
    public int dfs(int id){
        Employee master = map.get(id);
        int ans = master.importance;
        for(int oid : master.subordinates){
            ans +=dfs(oid);
        }
        return ans;
    }

}
