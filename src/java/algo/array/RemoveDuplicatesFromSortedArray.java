package algo.array;

/**
 * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 *
 * 给定 nums = [0,0,1,1,1,2,2,3,3,4],
 *
 * 函数应该返回新的长度 5, 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4。
 *
 * 你不需要考虑数组中超出新长度后面的元素
 *
 * @author chahe
 * @date 2019-12-25
 */
public class RemoveDuplicatesFromSortedArray {
    private static int removeDuplicatesOn(int[] nums){
        // [0, i] is valid
        int i = 0;

        for (int j = 0; j < nums.length; j++) {
            if (nums[i] != nums[j]){
                // 维护 [0,i]
                i++;
                nums[i] = nums[j];
            }
        }

        return i + 1;
    }

    @Deprecated
    private static int removeDuplicates(int[] nums){
        int length = nums.length;
        int i = 0;
        // [i,k) 是最终的 distinct 之后的sorted的头部分
        int k = i + 1;
        while(i < nums.length - 1){
            // indexDup 是 arr[i] 重复出现的次数
            int indexDup = 0;

            for (int j = i + 1; j < nums.length ; j++) {
                if (nums[i] == nums[j]){
                    length --;
                    indexDup ++;
                }else{
                    break;
                }
            }

            // [i, i + indexDup +1) is dup area next value is arr[i + indexDup + 1]
            if (i + indexDup + 1 >= nums.length){
                break;
            }else{
                // next elem is i + indexDup + 1
                i = i + indexDup + 1;
                // 维护 [i,k)
                nums[k] = nums[i];
                // add ks
                k++;
            }
        }

        return length;
    }

    public static void main(String[] args) {
        int[] array = new int[]{1, 1, 2, 2 ,2, 3, 4, 4, 5};
//        int[] array = new int[]{1, 1, 2};
//        int[] array = new int[]{0,0,1,1,1,2,2,3,3,4};
//        int[] array = new int[]{1,1,1};

        int solution = RemoveDuplicatesFromSortedArray.removeDuplicatesOn(array);
        System.out.println(solution + "----------------------");

        for (int anArray : array) {
            System.out.println(anArray);
        }
    }
}
