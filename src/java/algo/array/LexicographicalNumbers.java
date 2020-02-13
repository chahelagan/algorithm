package algo.array;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 字典序排序数组
 * 给定 n =1 3，返回 [1,10,11,12,13,2,3,4,5,6,7,8,9] 。
 * @author chahelagan
 * @since  2020-2-12
 */
public class LexicographicalNumbers {

    /**
     * dfs impl
     * @param n n
     * @return result
     */
    public List<Integer> lexicalOrder(int n) {
        List<Integer> result = new LinkedList<>();
        this.lexicalOrderDFS(1, n, result);

        return result;
    }

    private void lexicalOrderDFS(int cur, int n, List<Integer> list){
        // i<10 即可（1-9） cur<=n停止， cur++ +1不断处理
        for (int i = cur % 10; i < 10 && cur <= n ; i++,cur++) {
            list.add(cur);
            if (cur * 10 <= n) {
                // 处理 cur*10
                lexicalOrderDFS(cur * 10, n, list);
            }
        }
    }

    /**
     * no recursive
     * @param n number
     * @return  result
     */
    public List<Integer> lexicalOrderLoop(int n) {
        List<Integer> result = new LinkedList<>();
        Stack<Integer> stack = new Stack<>();
        for (int i = 9; i > 0; i --){
            stack.push(i);
        }

        while (!stack.isEmpty()){
            int elem = stack.pop();
            if (elem <= n){
                result.add(elem);
                for (int i = 9; i >=0; i--) {
                    int x = elem * 10 + i;
                    if (x <= n){
                        // push to Stack not resultList
                        stack.push(x);
                    }
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        new LexicographicalNumbers().lexicalOrderLoop(13).forEach(System.out::println);
    }
}
