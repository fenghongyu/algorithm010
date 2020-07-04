/**
 * @CLASSNAME:
 * @AUTHOR: fenghongyu
 * @TIME: 2020/7/4 21:57
 */
public class BestTimeToBuyAndSellStockTwo {
    public int maxProfit(int[] prices) {
        int max = 0;
        if(prices.length == 0) {
            return max;
        }
        int min = Integer.MAX_VALUE;
        for(int i=0;i < prices.length-1;i++) {
            if(prices[i]<prices[i+1]){
                max +=prices[i+1] - prices[i];
            }
        }
        return max;
    }
}
