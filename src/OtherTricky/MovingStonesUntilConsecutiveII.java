package OtherTricky;

import java.util.Arrays;

public class MovingStonesUntilConsecutiveII {
/*
    在一个长度无限的数轴上，第 i 颗石子的位置为stones[i]。如果一颗石子的位置最小/最大，那么该石子被称作端点石子。

    每个回合，你可以将一颗端点石子拿起并移动到一个未占用的位置，使得该石子不再是一颗端点石子。

    值得注意的是，如果石子像stones = [1,2,5]这样，你将无法移动位于位置 5 的端点石子，因为无论将它移动到任何位置（例如 0 或 3），该石子都仍然会是端点石子。

    当你无法进行任何移动时，即，这些石子的位置连续时，游戏结束。

    要使游戏结束，你可以执行的最小和最大移动次数分别是多少？ 以长度为 2 的数组形式返回答案：answer = [minimum_moves, maximum_moves] 。
*/
    //https://leetcode.com/problems/moving-stones-until-consecutive-ii/discuss/286707/JavaC%2B%2BPython-Sliding-Window
    public int[] numMovesStonesII(int[] stones) {
        int n = stones.length;
        Arrays.sort(stones);
        int s1 = stones[n-1] - stones[0] + 1 - n;//the total space between stones
        int s2 = Math.min(stones[n-1] - stones[n-2] - 1, stones[1] - stones[0] - 1);
        int max = s1 - s2;
        int min = max, j = 0;
        for (int i = 0; i < n; i++) {
            while (j + 1 < n && stones[j+1] - stones[i] + 1 <= n)
                j++;
            int cost = n - (j - i + 1);
            if (j - i + 1 == n - 1 && stones[j] - stones[i] + 1 == n - 1)
                cost = 2;
            min = Math.min(cost, min);
        }
        return new int[]{min, max};
    }

    public int[] numMovesStonesII2(int[] stones) {
        Arrays.sort(stones);
        int n = stones.length;
        int max = Math.max(stones[n - 1] - stones[1] - n + 2, stones[n - 2] - stones[0] - n + 2);// we should skip the first or last interval
        int i = 0, min = n;
        for (int j = 0; j < n; j++) {// we need to find a window that contains most of the stones. so (j - i + 1) means the number of stones in the window.
            while (stones[j] - stones[i] >= n)
                i++;
            if (j - i + 1 == n - 1 && stones[j] - stones[i] == n - 2)
                min = Math.min(min, 2);
            else
                min = Math.min(min, n - (j - i + 1));// n - (j - i + 1) means the number of stones outside the window
        }

        return new int[]{min, max};
    }

}
