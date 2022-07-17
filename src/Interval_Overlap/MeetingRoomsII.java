package Interval_Overlap;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MeetingRoomsII {
    /**
     * Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), find the minimum number of conference rooms required
     * **/

    // swap line https://aaronice.gitbook.io/lintcode/sweep-line/meeting-rooms-ii

    class Point {
        int time, type;
        Point(int time, int type) {
            this.time = time;
            this.type = type;
        }
    }

    public int minMeetingRooms(List<MeetingRoomsI.Interval> intervals) {
        if (intervals == null || intervals.size() == 0)
            return 0;

        List<Point> list = new ArrayList<>();
        for (MeetingRoomsI.Interval interval : intervals) {
            list.add(new Point(interval.start, 1));
            list.add(new Point(interval.end, 0));
        }

        // lambda Comparator cmp = (Comparator<Point>) (p1, p2) -> p1.time == p2.time ? p1.type - p2.type : p1.time - p2.time;
        Comparator cmp = new Comparator<Point>() {
            @Override
            public int compare(Point p1, Point p2) {
                return p1.time == p2.time ? p1.type - p2.type : p1.time - p2.time;
            }
        };
        list.sort(cmp);

        int res = 0, ongoing = 0;
        for (Point p : list) {
            if (p.type == 1)
                ongoing++;
            else
                ongoing--;

            res = Math.max(res, ongoing);
        }

        return res;
    }
}
