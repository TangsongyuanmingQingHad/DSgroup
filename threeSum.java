package ArrayTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

 Note:

 The solution set must not contain duplicate triplets.

 Example:

 Given array nums = [-1, 0, 1, 2, -1, -4],

 A solution set is:
 [
 [-1, 0, 1],
 [-1, -1, 2]
 ]

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/3sum
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class threeSum {
    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> solution = threeSum.solution(nums, 0);
        System.out.println(solution);
    }

    /**
     * 先对数组进行排序，然后确定首尾，第三个指针比首部的指针大一位（i,k,j）
     * 然后看这三个数字的值，如果值小于0，则k+1,
     *
     * @param nums
     * @param target
     * @return
     */
    public static List<List<Integer>> solution(int[] nums,int target) {
        if(nums.length < 3) {
            return null;
        }
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {

            if(nums[i] > 0) {
                break;
            }

            if(i > 0 && nums[i] == nums[i-1]) {
                continue;
            }

            int k = i + 1;
            int j = nums.length - 1;
            while (k < j) {
                int result = nums[i] + nums[k] + nums[j];
                if(result == 0) {
                   list.add(Arrays.asList(nums[i], nums[k], nums[j]));
                   while (k<j && nums[k] == nums[k+1]) {
                       continue;
                   }
                   while (k<j && nums[j] == nums[j-1]) {
                       continue;
                   }
                   k++;
                   j--;
                }else if(result < 0) {
                    k++;
                }else if(result > 0) {
                    j--;
                }
            }

        }
        return list;
    }
}
