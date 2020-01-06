package algo.array;

/**
 * 给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 *
 * 说明：你不能倾斜容器，且 n 的值至少为 2。
 *
 * 输入: [1,8,6,2,5,4,8,3,7]
 * 输出: 49
 *
 * @author chahelagan
 * @date 2020-1-4
 */
public class ContainerWithMostWater {
    private int maxArea(int[] height) {
        int maxArea = 0;
        // 开始 一个指针在头 一个在尾
        int begin = 0;
        int end = height.length - 1;

        while (begin < end){
            int partArea = Math.min(height[begin] , height[end]) * (end - begin);
            maxArea = Math.max(maxArea, partArea);
            // 比较大小 看谁小就移动谁 移动大的没有意义
            if (height[begin] > height[end]){
                end --;
            }else{
                begin ++;
            }
        }

        return maxArea;
    }
    public static void main(String[] args) {
        int[] height = new int[]{10,9,8,7,6,5,4,3,2,1};
        System.out.println(new ContainerWithMostWater().maxArea(height));
    }
}
