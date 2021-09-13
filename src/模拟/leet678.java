package 模拟;

public class leet678 {
    public boolean checkValidString(String s) {
        //记录左括号可以取到的最大值和最小值
        int minCount = 0,maxCount = 0;
        for (int i = 0; i < s.length(); i++) {
            //左括号，最大最小值++
            if(s.charAt(i) == '('){
                minCount++;
                maxCount++;
                //右括号最大值，最小值--，判断最小值和0的大小
            }else if(s.charAt(i) == ')'){
                minCount = Math.max(minCount-1,0);
                maxCount --;
                //若出现最大值小于0，直接返回false
                if(maxCount < 0){
                    return false;
                }
                //出现*，最大值++，最小值--
            }else {
                minCount = Math.max(minCount-1, 0);
                maxCount++;
            }
        }
        //判断左括号数量是否可以为零
        return minCount == 0;
    }
}
