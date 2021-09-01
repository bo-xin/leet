package 题解;

import java.util.HashMap;
import java.util.Map;

public class leet5750 {
    public static void main(String[] args) {
        int[][] logs = new int[][]{{1993,1999},{2000,2010}};
        System.out.println(new leet5750().maximumPopulation(logs));
    }
    public int maximumPopulation(int[][] logs) {
        int res = 0;
        int maxNumber = Integer.MIN_VALUE;
        int[] numbers = new int[10001];
//        for(int i = 0;i<logs.length;i++){
//            int j = logs[i][0];
//            int length  = logs[i][1];
//            for(;j<length;j++){
//                numbers[j]++;
//            }
//        }
        for(int i=0;i<logs.length;i++){
            for(int j = logs[i][0];j<logs[i][1];j++){
                System.out.println(j);
            }
        }
        for(int i =0;i<numbers.length;i++){
            if(maxNumber<numbers[i]){
                maxNumber=numbers[i];
                res=i;
            }
        }
        return res;
    }
}
