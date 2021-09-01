package 周赛;

import javax.xml.bind.annotation.XmlID;
import java.util.Arrays;

public class leet5764 {
    public static void main(String[] args) {
        int[] dist = {1,1,100000};
        double hour = 2.01;
        System.out.println(new leet5764().minSpeedOnTime(dist,hour));
    }
    public int minSpeedOnTime(int[] dist, double hour) {
        int n = dist.length;
        if(hour<n-1) return -1;
        int lowSpeed = 1;
        int highSpeed = 0;
        int maxDist = 0;
        for(int num:dist){
            maxDist = Math.max(maxDist,num);
        }
        if (hour%1==0){
            highSpeed = maxDist;
        }else {
            highSpeed = (int)(maxDist/(hour%1));
        }
        double speedHour = 0;
        while (lowSpeed<highSpeed){
            int midSpeed = (lowSpeed+highSpeed)/2;
            speedHour =0;
            for(int i=0;i<dist.length-1;i++){
                if(dist[i]%midSpeed ==0){
                    speedHour+=dist[i]/midSpeed;
                }else {
                    speedHour+=(int)(dist[i]/midSpeed)+1;
                }
            }
            speedHour+=(double) dist[dist.length-1]/midSpeed;
            if(speedHour<=hour){
                highSpeed = midSpeed;
            }else {
                lowSpeed=midSpeed+1;
            }


        }
        return lowSpeed;
    }

}
