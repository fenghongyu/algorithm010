import java.util.HashMap;
import java.util.Map;

/**
 * @CLASSNAME:
 * @AUTHOR: fenghongyu
 * @TIME: 2020/6/14 23:01
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap();
        for(int i=0;i<nums.length;i++) {
            int tmp = nums[i];
            Integer diff = target - tmp;
            if(map.containsKey(diff)) {
                return new int[]{map.get(diff), i};
            } else {
                map.put(tmp, i);
            }
        }
        return null;
    }
}
