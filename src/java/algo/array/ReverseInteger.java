package algo.array;

/**
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 *
 * 示例 1:
 *
 * 输入: 123
 * 输出: 321
 *
 * 示例 2:
 *
 * 输入: -123
 * 输出: -321
 *
 * 示例 3:
 *
 * 输入: 120
 * 输出: 21
 *
 * 注意:
 * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
 *
 * @author chahe
 * @date 2020-1-6
 */
public class ReverseInteger {
    private int reverse(int x) {
        long num = 0;
        while (x != 0){
            num = num * 10 + x % 10;
            if (num > Integer.MAX_VALUE || num < Integer.MIN_VALUE){
                return 0;
            }
            x = x / 10;
        }

        return (int) num;
    }

    public static void main(String[] args) {
        int value = 1534236469;
        System.out.println(new ReverseInteger().reverse(value));
    }
}
