package OtherTricky;

import java.util.Comparator;
import java.util.PriorityQueue;

public class FindMedianFromDataStream {
    /**
     *The median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value and the median is the mean of the two middle values.
     *
     * For example, for arr = [2,3,4], the median is 3.
     * For example, for arr = [2,3], the median is (2 + 3) / 2 = 2.5.
     * Implement the MedianFinder class:
     *
     * MedianFinder() initializes the MedianFinder object.
     * void addNum(int num) adds the integer num from the data stream to the data structure.
     * double findMedian() returns the median of all elements so far. Answers within 10-5 of the actual answer will be accepted.
     ***/

    PriorityQueue<Integer> small; // max heap
    PriorityQueue<Integer> large; // min heap
    boolean even;

    public FindMedianFromDataStream() {
        small = new PriorityQueue<>(Comparator.reverseOrder());
        large = new PriorityQueue<>(Comparator.naturalOrder());
        even = true;
    }

    public void addNum(int num) {
        if (even) {
            large.offer(num);
            small.offer(large.poll());
        } else {
            small.offer(num);
            large.offer(small.poll());
        }
        even = !even;
    }

    public double findMedian() {
        if (even) {
            return (small.peek() + large.peek()) / 2.0;
        } else {
            return small.peek();
        }
    }
}
