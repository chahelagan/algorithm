package algo.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 * 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]
 *
 * 满足要求的三元组集合为：
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 *
 * @author chahe
 * @date 2020-1-6
 */
public class ThreeSum {
    private List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        //固定元素ａ
        for (int i = 0; i < nums.length - 2; i++) {
            // 固定的current 不合法直接gg
            if (nums[i] > 0) {
                break;
            }
            // distinct 已经固定过的num
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int nextSum = 0 - nums[i];
            int leftIndex = i + 1;
            int rightIndex = nums.length - 1;
            while (leftIndex < rightIndex) {
                //　已经大于 nextSum　skip
                if (nums[leftIndex] > nextSum) {
                    break;
                } else {
                    int currentSum = nums[leftIndex] + nums[rightIndex];
                    if (currentSum == nextSum) {
                        result.add(new ArrayList<>(Arrays.asList(nums[i], nums[leftIndex], nums[rightIndex])));
                        leftIndex++;
                        rightIndex--;

                        //　和前面的比较　相同就　skip
                        while (leftIndex < rightIndex && nums[leftIndex] == nums[leftIndex -1]) {
                            leftIndex++;
                        }

                        // 和后面的比较　相同就　skip
                        while (leftIndex < rightIndex && nums[rightIndex] == nums[rightIndex + 1]) {
                            rightIndex--;
                        }
                    } else if (currentSum > nextSum) {
                        rightIndex--;
                        while (leftIndex < rightIndex && nums[rightIndex] == nums[rightIndex + 1]) {
                            rightIndex--;
                        }
                    } else {
                        leftIndex++;
                        while (leftIndex < rightIndex && nums[leftIndex] == nums[leftIndex - 1]) {
                            leftIndex++;
                        }
                    }
                }
            }

        }


        return result;
    }

    public static void main(String[] args) {
//        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
//        int[] nums = new int[]{-2,0,0,2,2};
//        int[] nums = new int[]{0,0,0};
        // [[-4,-2,6],[-4,0,4],[-4,1,3],[-4,2,2],[-2,-2,4],[-2,0,2]]
//        int[] nums = new int[]{-4, -2, -2, -2, 0, 1, 2, 2, 2, 3, 3, 4, 4, 6, 6};
        int[] nums = new int[]{-4,-2,1,-5,-4,-4,4,-2,0,4,0,-2,3,1,-5,0};
        System.out.println(new ThreeSum().threeSum(nums));
    }

}