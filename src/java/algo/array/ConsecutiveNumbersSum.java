package algo.array;

/**
 * 给定一个正整数 N，试求有多少组连续正整数满足所有数字之和为 N?
 *
 * 示例 1:
 *
 * 输入: 5
 * 输出: 2
 * 解释: 5 = 5 = 2 + 3，共有两组连续整数([5],[2,3])求和后为 5。
 * 示例 2:
 *
 * 输入: 9
 * 输出: 3
 * 解释: 9 = 9 = 4 + 5 = 2 + 3 + 4
 * 示例 3:
 *
 * 输入: 15
 * 输出: 4
 * 解释: 15 = 15 = 8 + 7 = 4 + 5 + 6 = 1 + 2 + 3 + 4 + 5
 *
 * @author chahelagan
 * @since 2020-1-23
 */
public class ConsecutiveNumbersSum {
    /**
     * # 1个数时，必然有一个数可构成N
     * # 2个数若要构成N，第2个数与第1个数差为1，N减掉这个1能整除2则能由商与商+1构成N
     * # 3个数若要构成N，第2个数与第1个数差为1，第3个数与第1个数的差为2，N减掉1再减掉2能整除3则能由商、商+1与商+2构成N
     * # 依次内推，当商即第1个数小于等于0时结束
     * @param N
     * @return
     */
    public int consecutiveNumbersSum(int N) {
        int result = 0;
        int i = 1;
        while (N > 0){
            if (N % i == 0){
              result ++;
            }
            N-=i;
            i++;
        }

        return result;
    }
}
