package algo.tree;

/**
 * 给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？
 *
 * 示例:
 *
 * 输入: 3
 * 输出: 5
 * 解释:
 * 给定 n = 3, 一共有 5 种不同结构的二叉搜索树:
 *
 *    1         3     3      2      1
 *     \       /     /      / \      \
 *      3     2     1      1   3      2
 *     /     /       \                 \
 *    2     1         2                 3
 *
 * @author chahe
 * @since 2020-1-16
 */
public class UniqueBinarySearchTrees {
    /**
     * 先看定义:
     *      g(x) = 节点数量为x时的 2叉树数量
     *          g(0)=g(1)=1
     *      f(a,b) = 以节点 a 为 root 节点量为b的 2叉树数量
     *
     *      g(x) = sum(f(i,x)) 0<=i<=x
     *      f(i,x) = g(i-1) * g(x-1)
     *      g(x) = sum(g(i-1) * g(x-1)) 0<=i<=x
     * @param n
     * @return
     */
    public int numTrees(int n) {
        int[] g = new int[n + 1];
        g[0] = 1;
        g[1] = 1;

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                g[i] += g[j - 1] * g[i -j];
            }
        }

        return g[n];
    }

    /**
     *  卡塔兰数 C_n
     * @param n
     * @return
     */
    public int numTreesMath(int n) {
        // Note: we should use long here instead of int, otherwise overflow
        long C = 1;
        for (int i = 0; i < n; ++i) {
            C = C * 2 * (2 * i + 1) / (i + 2);
        }
        return (int) C;
    }
}
