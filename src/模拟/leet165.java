package 模拟;

public class leet165 {
    public static void main(String[] args) {
        String str1 = "7.5.2.4";
        String str2 = "7.5.2";
        System.out.println(new leet165().compareVersion(str1,str2));
    }
    public int compareVersion(String version1, String version2) {
        //把两个字符串分解为字符数组
        String[] str1s = version1.split("\\.");
        String[] str2s = version2.split("\\.");
        int len_1 = str1s.length;
        int len_2 = str2s.length;
        int n = Math.min(len_2,len_1);
        //比较相同长度下的大小
        for (int i = 0; i < n; i++) {
            int num1 = Integer.valueOf(str1s[i]);
            int num2 = Integer.valueOf(str2s[i]);
            if(num1 > num2) return 1;
            if(num1 < num2) return -1;
        }
        //长度不同，且前面相同长度的都一样，比较后几位
        if(len_1 > len_2){
            //防止1.0.0.0和1.0比较，所以判断后面是否全部为零
            for (int i = n; i < len_1; i++) {
                if(Integer.valueOf(str1s[i]) > 0) return 1;
            }
            return 0;
        }else if(len_1 < len_2){
            for (int i = n; i < len_2; i++) {
                if(Integer.valueOf(str2s[i]) > 0) return -1;
            }
            return 0;
        }else {
            return 0;
        }
    }
}
