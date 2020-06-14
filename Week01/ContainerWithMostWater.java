/**
 * @CLASSNAME:
 * @AUTHOR: fenghongyu
 * @TIME: 2020/6/14 17:56
 *
 */
public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int max = 0;
        for(int i=0,j=height.length-1;i<j;) {
            int minHeight = height[i]<height[j] ? height[i] : height[j];
            //j-i+1 是由于上面的++ 或者 -- 操作，导致 j-i 的时候，少 1， 故需要将前面提前处理的1，给加上。
            int area = (j-i+1) * minHeight;
            max = Math.max(max, area);
        }
        return max;
    }
}
