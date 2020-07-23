package DP.GetMinMaxValues;


public class MinimumNumberOfRefuelingStops {
/*
    A car travels from a starting position to a destination which is target miles east of the starting position.

    Along the way, there are gas stations.
    Each station[i] represents a gas station that is station[i][0] miles east of the starting position, and has station[i][1] liters of gas.

    The car starts with an infinite tank of gas, which initially has startFuel liters of fuel in it.
    It uses 1 liter of gas per 1 mile that it drives.

    When the car reaches a gas station, it may stop and refuel, transferring all the gas from the station into the car.

    What is the least number of refueling stops the car must make in order to reach its destination?
    If it cannot reach the destination, return -1.

    Note that if the car reaches a gas station with 0 fuel left, the car can still refuel there.
    If the car reaches the destination with 0 fuel left, it is still considered to have arrived.
*/

    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        //dp[t] means the furthest distance that we can get with t times of refueling.
        long[] dp = new long[stations.length + 1];
        dp[0] = startFuel;

        for (int i = 0; i < stations.length; i++)
            for (int t = i; t >= 0 && stations[i][0] <= dp[t]; t--)
                dp[t + 1] = Math.max(dp[t + 1], dp[t] + stations[i][1]);

        for (int t = 0; t <= stations.length; t++)
            if (dp[t] >= target)
                return t;

        return -1;
    }

    public int minRefuelStops2(int target, int startFuel, int[][] s) {
        long[] dp = new long[s.length + 1];
        dp[0] = startFuel;
        for (int i = 0; i < s.length; ++i)
            for (int t = i; t >= 0 && dp[t] >= s[i][0]; --t)
                dp[t + 1] = Math.max(dp[t + 1], dp[t] + s[i][1]);
        for (int t = 0; t <= s.length; ++t)
            if (dp[t] >= target) return t;
        return -1;
    }

}
