package 题解;
/*
数组arr是[0, 1, ..., arr.length - 1]的一种排列，
我们将这个数组分割成几个“块”，并将这些块分别进行排序。
之后再连接起来，使得连接的结果和按升序排序后的原数组相同。

我们最多能将数组分成多少块？

 */
public class leet769 {
    public int maxChunksToSorted(int[] arr) {
        int num = arr[0];
        int cnt = 0;
        for (int i = 0; i < arr.length; i++) {
            if(num == i){
                cnt++;
            }
            if(num < arr[i]){
                num = arr[i];
            }
        }
        return cnt;
    }
}
