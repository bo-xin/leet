package 贪心策略;

import java.util.ArrayList;
import java.util.List;

public class leet68 {
    List<String> res;
    public List<String> fullJustify(String[] words, int maxWidth) {
        res = new ArrayList<>();
        int left = 0,right =0 , n = words.length;
        //一直循环知道最后一个单词结束直接返回
        while (true){
            //每次循环后，把右指针赋值给左指针
            left = right;
            //记录每一行可以拿到word的长度和
            int sumLen = 0;
            //判断条件：注意加上字符之间默认的一个空格，默认空格数量为right-left
            while (right < n && sumLen+words[right].length()+right-left <= maxWidth){
                sumLen += words[right++].length();
            }
            //判断是最后一行
            if(right == n){
                StringBuffer sb = new StringBuffer();
                //把最后一行word按照要求输出
                sb.append(appendString(words,left,right," "));
                //末尾添加空格
                sb.append(appendSpace(maxWidth - sb.length()));
                //加入res中并返回
                res.add(sb.toString());
                return res;
            }
            //记录word数量
            int numWords = right - left;
            //记录需要补充空格数量
            int blankSpace = maxWidth - sumLen;
            //如果word为1
            if(numWords == 1){
                //按照要求添加word
                StringBuffer sb = new StringBuffer(words[left]);
                //末尾加入空格
                sb.append(appendSpace(maxWidth - sb.length()));
                //加入res中，进行下一个循环
                res.add(sb.toString());
                continue;
            }
            //记录平均空格数
            int avgSpace = blankSpace/(numWords - 1);
            //记录多出来的空格数
            int extraSpace = blankSpace % (numWords - 1);
            StringBuffer sb = new StringBuffer();
            //多出来的空格数，平均添加到前面
            sb.append(appendString(words, left, left+extraSpace+1, appendSpace(avgSpace + 1)));
            sb.append(appendSpace(avgSpace));
            //剩下的字符正常添加
            sb.append(appendString(words, left+extraSpace+1, right,appendSpace(avgSpace)));
            //加入res中
            res.add(sb.toString());
        }
    }
    //返回长度为n的空格字符串
    public String appendSpace(int n){
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < n; i++) {
            sb.append(' ');
        }
        return sb.toString();
    }
    //返回word+str+...+word+str+word形式的字符串
    public String appendString(String[] words,int left, int right, String str){
        //拼接第一个word
        StringBuffer sb = new StringBuffer(words[left]);
        //拼接str+word形式
        for (int i = left+1; i < right; i++) {
            sb.append(str);
            sb.append(words[i]);
        }
        return sb.toString();
    }
}
