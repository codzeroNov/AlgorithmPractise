package Interval_Overlap;

import java.util.Arrays;

public class MinimumNumberOfArrowsToBurstBalloons {
/*
    There are a number of spherical balloons spread in two-dimensional space.
    For each balloon, provided input is the start and end coordinates of the horizontal diameter.
    Since it's horizontal, y-coordinates don't matter and hence the x-coordinates of start and end of the diameter suffice.
    Start is always smaller than end. There will be at most 104 balloons.

    An arrow can be shot up exactly vertically from different points along the x-axis.
    A balloon with xstart and xend bursts by an arrow shot at x if xstart ≤ x ≤ xend.
    There is no limit to the number of arrows that can be shot. An arrow once shot keeps travelling up infinitely.
    The problem is to find the minimum number of arrows that must be shot to burst all balloons.
*/

    public int findMinArrowShots(int[][] points) {
        if (points == null || points.length == 0) return 0;

        Arrays.sort(points, (a, b) -> (a[0] - b[0]));

        int preEnd = points[0][1], count = 1;

        for (int[] point : points) {
            if (point[0] > preEnd) {
                preEnd = point[1];
                count++;
            } else {
                preEnd = Math.min(preEnd, point[1]);
            }
        }

        return count;
    }

}
