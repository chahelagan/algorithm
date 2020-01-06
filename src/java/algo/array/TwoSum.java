package algo.array;

import java.util.HashMap;

/**
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 *
 * 示例:
 *
 * 给定 nums = [2, 7, 11, 15], target = 9
 *
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 *
 * @author chahe
 * @date 2020-1-6
 */
public class TwoSum {
    private int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hashMap = new HashMap<>(nums.length / 2);
        int[] result = new int[2];

        for (int i = 0; i< nums.length; i++){
            if (hashMap.containsKey(target - nums[i])){
                result[0] = i;
                result[1] = hashMap.get(target - nums[i]);
                break;
            }else{
                hashMap.put(nums[i], i);
            }
        }


        return result;
    }
    public static void main(String[] args) {
        int[] nums = new int[]{2, 7, 11, 15};
        int target = 9;
        for (int num : new TwoSum().twoSum(nums, target)){
            System.out.print(num + " ");
        }
    }
}
