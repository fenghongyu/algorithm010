package lesson03;

/**
 * @CLASSNAME:
 * @AUTHOR: fenghongyu
 * @TIME: 2020/6/14 20:11
 */
public class ClimbStairs {

    public int climbStairs(int n) {
        if(n <=1) {
            return 1;
        }
        int[] result = new int[n+1];
        result[1] = 1;
        result[2] = 2;
        for(int i=3;i<=n;i++) {
            result[i] = result[i-1] + result[i-2];
        }
        return result[n];
    }
}
