package 回溯;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class leet869 {
    public static void main(String[] args) {
        System.out.println(new leet869().reorderedPowerOf2(123456789));
    }
    // 数字长度
    int len;
    // 存储数字
    StringBuffer number;
    public boolean reorderedPowerOf2(int n) {
        number = new StringBuffer();
        // 对数字n进行处理，把所有数字存入Number中
        while (n > 0){
            number.append(n%10);
            n = n/10;
        }
        len = number.length();
        boolean[] visited = new boolean[len];
        // DFS回溯判断组合情况，若存在2的幂则返回true
        return dfs(number, new StringBuffer(),visited);
    }
    // path为当前路径，即目前排列的情况
    public boolean dfs(StringBuffer number,StringBuffer path, boolean[] visited){
        // path长度==len，说明已经完成这次排列，进行判断
        if(path.length() == len){
            // 开头数字不能为0
            if(path.charAt(0) != '0'){
                // 判断此次是否为2的幂
                return isPowerOf2(Integer.valueOf(path.toString()));
            }
        }
        // 遍历所有的数组，进行组合
        for (int i = 0; i < len; i++) {
            // 判断你是否选择，如果被选择直接下一个数
            if(visited[i] == true) continue;
            // 选择数字，并加入path中
            visited[i] =true;
            path.append(number.charAt(i));
            // 递归调用
            if (dfs(number,path,visited)) return true;
            // 回溯处理
            path.deleteCharAt(path.length()-1);
            visited[i] = false;
        }
        return false;
    }
    // 通过位运算判断是否为2的幂
    public boolean isPowerOf2(int n){
        return (n & (n-1)) == 0;
    }
    /*词频统计*/
    /*set存储频次*/
    Set<String> set = new HashSet<>();
    public boolean reorderedPowerOf2_1(int n) {
        init();
        /*判断n是否成立*/
        return set.contains(count(n));
    }
    /*统计 < 1e9中所有的2的幂的频次*/
    public void init(){
        for (int i = 1; i < 1e9; i <<= 1) {
            set.add(count(i));
        }
    }
    /*统计数字n中0-9出现的频次*/
    public String count(int n){
        char[] cnt = new char[10];
        /*统计频次*/
        while (n > 0){
            cnt[n%10]++;
            n /= 10;
        }
        // 返回类型为字符串
        return new String(cnt);
    }

}
