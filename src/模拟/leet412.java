package 模拟;

import java.util.ArrayList;
import java.util.List;

public class leet412 {
    public List<String> fizzBuzz(int n) {
        //声明返回字符串
        List<String> ans = new ArrayList<>();
        // 对1-n进行处理
        for (int i = 1; i <= n; i++) {
            // 如果n既是3的倍数也是5的倍数，输出“FizzBuzz”
            if(i%3 == 0 && i%5 == 0){
                ans.add("FizzBuzz");
                //如果n既是3的倍数也是5的倍数，输出“FizzBuzz”
            }else if(i%3 == 0){
                ans.add("Fizz");
                //如果n是5的倍数，输出“Buzz”
            }else if(i%5 == 0){
                ans.add("Buzz");
            }else {
                ans.add(String.valueOf(i));
            }
        }
        // 返回
        return ans;
    }
}
