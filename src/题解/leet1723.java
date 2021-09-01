package 题解;

import java.util.Arrays;

/*
给你一个整数数组 jobs ，其中 jobs[i] 是完成第 i 项工作要花费的时间。

请你将这些工作分配给 k 位工人。所有工作都应该分配给工人，且每项工作只能分配给一位工人。
工人的 工作时间 是完成分配给他们的所有工作花费时间的总和。
请你设计一套最佳的工作分配方案，使工人的 最大工作时间 得以 最小化 。

返回分配方案中尽可能 最小 的 最大工作时间

输入：jobs = [3,2,3], k = 3
输出：3
解释：给每位工人分配一项工作，最大工作时间是 3 。
 */
public class leet1723 {

    public int minimumTimeRequired(int[] jobs, int k) {
        Arrays.sort(jobs);
        int low = 0,high = jobs.length-1;
        while (low<high){
            int temp = jobs[low];
            jobs[low] = jobs[high];
            jobs[high]=temp;
            low++;
            high--;
        }
        int l = jobs[0];
        int r = Arrays.stream(jobs).sum();
        while(l<r){
            int mid = (l+r)/2;
            if(check(jobs,k,mid)){
                r = mid;
            }else {
                l=mid+1;
            }
        }
        return l;
    }
    public boolean check(int[] jobs,int k,int limit){
        int[] workloads = new int[k];
        return checkTrace(jobs,0,limit,workloads);
    }
    public boolean checkTrace(int [] jobs,int i,int limit,int[] workloads){
        if(i>=jobs.length){
            return true;
        }
        int cur = jobs[i];
        for(int j=0;j<workloads.length;j++){
            if(workloads[j]+cur <=limit){
                workloads[j]+=cur;
                if(checkTrace(jobs,i+1,limit,workloads)){
                    return true;
                }
                workloads[j]-=cur;
            }
        }
        return false;
    }

}
