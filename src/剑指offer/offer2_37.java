package 剑指offer;

import java.util.*;

/**
 * @program: leet
 * @description: 小行星碰撞
 * @author: Tb
 * @create: 2021-12-03 10:47
 **/
public class offer2_37 {
    public int[] asteroidCollision(int[] asteroids) {
        LinkedList<Integer> list = new LinkedList<>();
        for (int asteroid : asteroids) {
            if(list.isEmpty() && asteroid < 0 ){
                list.addLast(asteroid);
            }else if(!list.isEmpty() && list.peekLast() <0){
                list.addLast(asteroid);
            }else if(asteroid > 0){
                list.addLast(asteroid);
            }else{
                boolean flag = true;
                while (!list.isEmpty() && list.peekLast() >0 && list.peekLast() <= Math.abs(asteroid) && flag){
                    if(list.peekLast() == Math.abs(asteroid)){
                        list.removeLast();
                        flag = false;

                    }else {
                        list.removeLast();
                    }
                }
                if((!list.isEmpty() && list.peekLast() < 0 && flag) || list.isEmpty() && flag){
                    list.addLast(asteroid);
                }
            }
        }
        int[] ans = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }
}
