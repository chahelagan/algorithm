package algo.array;

/**
 *给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 *
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 *
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 *
 * 示例 1:
 *
 * 输入: [1,2,3]
 * 输出: [1,2,4]
 * 解释: 输入数组表示数字 123。
 * 示例 2:
 *
 * 输入: [4,3,2,1]
 * 输出: [4,3,2,2]
 * 解释: 输入数组表示数字 4321。
 *
 * @author chahe
 * @date 2020-1-6
 */
public class PlusOne {
    private int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] = digits[i] % 10;
            if (digits[i] != 0) {
                return digits;
            }
        }
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }

    @Deprecated
    private int[] plusOneDep(int[] digits) {
        boolean flag = false;
        digits[digits.length - 1] = digits[digits.length - 1] + 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            if (flag && i != digits.length - 1){
                digits[i] = digits[i] + 1;
            }
            if (digits[i] >= 10){
                digits[i] = 0;
                flag = true;
            }else{
                flag = false;
            }
        }

        if (flag){
            int[] result = new int[digits.length + 1];
            result[0] = 1;
            System.arraycopy(digits, 0, result, 1, digits.length);

            return result;
        }else {
            return digits;
        }
    }

    public static void main(String[] args) {
        int[] digits = new int[]{9,9,9};
        for (int num : new PlusOne().plusOne(digits)){
            System.out.print(num + " ");
        }
    }
}
