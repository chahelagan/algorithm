package algo.array;

/**
 * 寻找两个有序数组的中位数
 *
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
 * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 * 你可以假设 nums1 和 nums2 不会同时为空。
 *
 * 示例 1:
 * nums1 = [1, 3]
 * nums2 = [2]
 * 则中位数是 2.0
 *
 * 示例 2:
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * 则中位数是 (2 + 3)/2 = 2.5
 *
 * @author chahelagan
 * @date 2019-12-26
 */
public class MedianOfTwoSortedArrays {
    private static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length == 0){
            if (nums2.length % 2 == 0){
                return (nums2[nums2.length / 2 - 1] + nums2[nums2.length / 2]) / 2.0;
            }else{
                return nums2[nums2.length / 2];
            }
        }else if (nums2.length == 0){
            if (nums1.length % 2 == 0){
                return (nums1[nums1.length / 2 - 1] + nums1[nums1.length / 2]) / 2.0;
            }else{
                return nums1[nums1.length / 2];
            }
        }

        boolean flag = (nums1.length + nums2.length) % 2 == 0;

        return 0.0;
    }

    public static void main(String[] args) {
        int[] nums1 = new int []{};
        int[] nums2 = new int []{};
        System.out.println(MedianOfTwoSortedArrays.findMedianSortedArrays(nums1, nums2));
    }
}
