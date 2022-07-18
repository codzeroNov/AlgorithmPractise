package Interval_Overlap;

public class MeetingRoomsIII {
    /**
     * you have a list intervals of current meetings, and some meeting rooms with start and end timestamp.
     * When a stream of new meeting ask coming in, judge one by one whether they can be placed in the current meeting list without overlapping.
     * A meeting room can only hold one meeting at a time. Each inquiry is independent.
     *
     * The meeting asked can be split to some times. For example, if you want to ask a meeting for [2, 4], you can split it to [2,3] and [3, 4].
     *
     * Ensure that Intervals can be arranged in rooms meeting rooms
     * The start and end times of any session are guaranteed to take values in the range [1, 50000]
     * |Intervals| <= 50000
     * |ask| <= 50000
     * 1 <= rooms <= 20
     * **/

    // https://www.lintcode.com/problem/1897/solution/37915
    public boolean[] meetingRoomIII(int[][] intervals, int rooms, int[][] ask) {
        int[] events = new int[50001];

        int maxEndTime = 0;
        for (int[] interval : intervals) {
            events[interval[0]]++;
            events[interval[1]]--;
            maxEndTime = Math.max(maxEndTime, interval[1]);
        }

        for (int[] a : ask)
            maxEndTime = Math.max(maxEndTime, a[1]);

        int ongoing = 0;
        int[] emptyRoom = new int[50001];
        for (int i = 0; i < maxEndTime; i++) {
            ongoing += events[i];
            if (ongoing < rooms)
                emptyRoom[i] = 0;
            else
                emptyRoom[i] = 1;
        }

        int[] prefixSum = new int[emptyRoom.length + 1];
        for (int i = 1; i < prefixSum.length; i++)
            prefixSum[i] = prefixSum[i - 1] + emptyRoom[i - 1];

        boolean[] res = new boolean[ask.length];
        for (int i = 0; i < ask.length; i++) {
            int start = ask[i][0], end = ask[i][1];
            res[i] = prefixSum[start] == prefixSum[end]; // prefixSum[end] - prefixSum[start] == 0
        }

        return res;
    }
}
