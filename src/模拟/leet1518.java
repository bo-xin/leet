package 模拟;

import org.junit.Test;

/**
 * @program: leet
 * @description: 换酒问题
 * @author: Tb
 * @create: 2021-12-17 10:02
 **/
public class leet1518 {
    @Test
    public void test1(){
        System.out.println(numWaterBottles(2,3));
    }
    public int numWaterBottles(int numBottles, int numExchange) {
        /*记录喝了的数量，和空瓶数量*/
        int ans = numBottles, empty = numBottles;
        /*直到不能兑换*/
        while (empty >= numExchange){
            /*本轮喝了多少*/
            int temp = empty / numExchange;
            /*本轮兑换后还剩多少空瓶*/
            empty = temp + (empty % numExchange);
            ans += temp;
        }
        /*返回*/
        return ans;
    }
}
