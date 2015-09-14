package algorithm.dynamic;

/**
 * Created by hy on 2015/9/10.
 */
public class MaxSubArray1 {

    public int maxSubArray(int[] nums) {
        if(nums==null || nums.length==0){
            return 0;
        }
        int sum = 0;int max=nums[0];
        for(int i=0;i<nums.length;i++){
            sum += nums[i];
            if(sum > max)
                max = sum;
            if(sum < 0)
                sum = 0;
        }
        return max;
    }
}
