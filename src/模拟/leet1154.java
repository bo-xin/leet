package 模拟;

/**
 * @program: leet
 * @description: 一年中的第几天
 * @author: Tb
 * @create: 2021-12-21 09:43
 **/
public class leet1154 {
    public int dayOfYear(String date) {
        int year = Integer.parseInt(date.substring(0,4));
        int mouth = Integer.parseInt(date.substring(5,7));
        int day = Integer.parseInt(date.substring(8));

        int[] mouths = {31,28,31,30,31,30,31,31,30,31,30,31};
        if(year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)){
            mouths[1]++;
        }
        int ans = 0;
        for (int i = 0; i < mouth-1; i++) {
            ans += mouths[i];
        }
        return ans + day;
    }
}
