/**
 * @CLASSNAME:
 * @AUTHOR: fenghongyu
 * @TIME: 2020/7/5 19:02
 * 搜索旋转排序数组
 */
public class Submissions {
    public int search(int[] nums, int target) {
        int length = nums.length;
        if(length == 0) {
            return -1;
        }
        int lo = 0;
        int hi = length -1;
        int mid = 0;
        while (lo <= hi) {
            mid = lo + (hi - lo)/2;
            if(target == nums[mid]) {
                return mid;
            }
            if(nums[lo]<=nums[mid]) {
                //左侧有序
                if(nums[lo]<=target && target<=nums[mid]) {
                    //target 在前半部分
                    hi = mid -1;
                } else {
                    lo = mid +1;
                }
            } else {
                //右侧有序
                if(nums[mid]< target && target <= nums[hi]) {
                    //在右侧部分
                    lo = mid + 1;
                } else {
                    //在左侧部分
                    hi = mid - 1;
                }
            }
        }
        return -1;
    }
}
