package algo.array;

/**
 * 回文数
 * @author chahe
 * @date 2019-12-26
 */
public class palindromeNumber {
    private static boolean isPalindrome(int x) {
        int num = 0;
        int ori = x;
        while (x > 0){
            num = num * 10 + x % 10;
            x = x / 10;
        }

        return ori == num;
    }

    public static void main(String[] args) {
        System.out.println(palindromeNumber.isPalindrome(-3));
    }
}
