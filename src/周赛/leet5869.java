package 周赛;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class leet5869 {
    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        list1.add(1);
        list1.add(3);
        list1.add(7);
        list2.add(4);
        list2.add(6);
        list2.add(8);
        //System.out.println(new leet5869().isMax(list1,list2,13));
       System.out.println(new leet5869().maxProduct("bb"));
    }
    List<List<Integer>> lists = new ArrayList<>();
    public int maxProduct(String s) {
        int n = s.length();
        boolean[] visited = new boolean[n];
        List<Integer> pathInt = new ArrayList<>();
        StringBuffer pathChar = new StringBuffer();
        backTrace(s,visited,pathInt,pathChar,0);
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < lists.size(); i++) {
            List<Integer> list1 = lists.get(i);
            for (int j = i+1; j < lists.size(); j++) {
                List<Integer> list2 = lists.get(j);
                if(isMax(list1,list2,n)){
                    ans = Math.max(list1.size()*list2.size(),ans);
                }
            }
        }
        return ans;
    }
    public void backTrace(String s, boolean[] visited, List<Integer> pathInt,StringBuffer pathChar,int index){
        if(index == s.length()-1){
            return;
        }
        for (int i = index; i < s.length(); i++) {
            if(visited[i]) continue;
            visited[i] = true;
            pathChar.append(s.charAt(i));
            pathInt.add(i);
            if(isResever(pathChar.toString())){
                lists.add(new ArrayList<>(pathInt));
            }
            backTrace(s,visited,pathInt,pathChar,i);
            pathInt.remove(pathInt.size()-1);
            pathChar.deleteCharAt(pathChar.length()-1);
            visited[i] = false;
        }
    }
    public boolean isResever(String s){
        int right = s.length()-1;
        int left = 0;
        while (left <= right){
            if(s.charAt(left) != s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
    public boolean isMax(List<Integer> list1, List<Integer> list2,int n){
        boolean[] isVisited1 = new boolean[n];
        boolean[] isVisited2 = new boolean[n];
        for (int i = 0; i < list1.size(); i++) {
            isVisited1[list1.get(i)] = true;
        }
        for (int i = 0; i < list2.size(); i++) {
            isVisited2[list2.get(i)] = true;
        }
        for (int i = 0; i < n; i++) {
            if(isVisited1[i] && isVisited2[i]){
                return false;
            }
        }
        return true;
    }
}
