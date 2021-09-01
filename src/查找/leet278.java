package 查找;
/*
假设你有 n 个版本 [1, 2, ..., n]，你想找出导致之后所有版本出错的第一个错误的版本。

你可以通过调用 bool isBadVersion(version) 接口来判断版本号 version 是否在单元测试中出错。实现一个函数来查找第一个错误的版本。你应该尽量减少对调用 API 的次数。

 */
public class leet278 {
    public int firstBadVersion(int n) {
        int left = 1;
        int right = n;
        while (left<right){
            int mid = left+(right-left)/2;
            if(isBadVersion()){
                right = mid;
            }else {
                left = mid+1;
            }
        }
        return left;
    }
    public boolean isBadVersion(){
        return true;
    }
}
