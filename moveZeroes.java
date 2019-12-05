package ArrayTest;

import java.util.Arrays;

/**
 * Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

 Example:

 Input: [0,1,0,3,12]
 Output: [1,3,12,0,0]
 Note:

 You must do this in-place without making a copy of the array.
 Minimize the total number of operations.

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/move-zeroes
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class moveZeroes {
    public static void main(String[] args) {
        int[] nums = {0,1,0,3,12,9,4,0,0,23};
        int[] solution = solution(nums);
        System.out.println(Arrays.toString(solution));
    }
    /**
     * 用计数器记录非零个数，把非零数移动到前边，然后把最后的数变为零
     * @param nums
     * @return
     */
    public static int[] solution(int[] nums) {//[0,1,0,3,12]
        int count = 0;
        for (int i = 0; i <nums.length ; i++) {
            if(nums[i] == 0 ) {
                count++;
            }else {
                nums[i-count] = nums[i];
            }
        }

        for (int i = nums.length - count; i < nums.length; i++) {
            nums[i] = 0;
        }
        return nums;
    }
}
