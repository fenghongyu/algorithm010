/**
 * @CLASSNAME:
 * @AUTHOR: fenghongyu
 * @TIME: 2020/6/14 17:41
 */
public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        int j = 0;
        for(int i=0;i<nums.length;i++) {
            if(nums[i] != 0) {
                nums[j] = nums[i];
                if(j!=i) {
                    nums[i] = 0;
                }
                j++;
            }
        }
    }
}
