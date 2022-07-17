package Interval_Overlap;

import java.util.List;

public class MeetingRoomsI {
    /**
     * Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), determine if a person could attend all meetings.
     **/
    public class Interval {
        int start, end;

        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public boolean canAttendMeetings(List<Interval> intervals) {
        if (intervals == null || intervals.size() == 0)
            return true;

        intervals.sort((a, b) -> (a.start - b.start));
        int prevEnd = intervals.get(0).end;

        for (int i = 1; i < intervals.size(); i++) {
            if (prevEnd > intervals.get(i).start)
                return false;
        }

        return true;
    }
}
