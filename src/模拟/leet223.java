package 模拟;

public class leet223 {
    public static void main(String[] args) {
        System.out.println(new leet223().computeArea(-2,-2,2,2,3,3,4,4));
    }
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        //分别去两个矩形面积
        int area1 = (ax2-ax1)*(ay2-ay1), area2 = (bx2-bx1)*(by2-by1);
        //求出相交部分的宽度，若为负数则没有相交
        int overlapWidth = Math.min(ax2,bx2) - Math.max(ax1,bx1);
        //求出相交部分的高度，若为负数则没有相交
        int overlapHeight = Math.min(by2,ay2) - Math.max(by1,ay1);
        // 若相交高度或者宽度小于0，则相交面积为0
        int overlapArea = Math.max(overlapHeight,0)*Math.max(overlapWidth,0);
        // 返回面积：总面积-相交面积
        return area1 + area2 - overlapArea;
    }
}
