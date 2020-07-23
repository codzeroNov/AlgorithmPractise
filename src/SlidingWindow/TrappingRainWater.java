package SlidingWindow;

public class TrappingRainWater {

    //给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。

    public int trap(int[] height) {
        int i = 0, j = height.length - 1;
        int maxleft = 0, maxright = 0;
        int res = 0;

        while (i <= j) {
            if (height[i] <= height[j]) {
                if (maxleft < height[i])
                    maxleft = height[i];
                else
                    res += maxleft - height[i];
                i++;
            } else {
                if (maxright < height[j])
                    maxright = height[j];
                else
                    res += maxright - height[j];
                j--;
            }

        }

        return res;
    }
}
