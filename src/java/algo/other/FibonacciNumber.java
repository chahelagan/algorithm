package algo.other;

/**
 * FibonacciNumber  f(0) = 0 f(1) = 1 get f(n)
 * @author chahelagan
 * @since 2020-1-23
 */
public class FibonacciNumber {
    public int fib(int N) {
        int pre1 = 0;
        int pre2 = 1;
        if (N == 0){
            return pre1;
        }
        if (N == 1){
            return pre2;
        }

        int result = 0;
        for (int i = 2; i <= N; i++) {
            result = pre1 + pre2;
            pre1 = pre2;
            pre2 = result;
        }

        return result;
    }
}
