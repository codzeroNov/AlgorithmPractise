package OtherTricky;

import java.util.Arrays;

public class MovingStonesUntilConsecutiveII {
/*
    在一个长度无限的数轴上，第 i 颗石子的位置为 stones[i]。如果一颗石子的位置最小/最大，那么该石子被称作端点石子。

    每个回合，你可以将一颗端点石子拿起并移动到一个未占用的位置，使得该石子不再是一颗端点石子。

    值得注意的是，如果石子像 stones = [1,2,5] 这样，你将无法移动位于位置 5 的端点石子，因为无论将它移动到任何位置（例如 0 或 3），该石子都仍然会是端点石子。

    当你无法进行任何移动时，即，这些石子的位置连续时，游戏结束。

    要使游戏结束，你可以执行的最小和最大移动次数分别是多少？ 以长度为 2 的数组形式返回答案：answer = [minimum_moves, maximum_moves] 。
*/
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

}
