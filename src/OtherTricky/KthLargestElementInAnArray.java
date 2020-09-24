package OtherTricky;

import java.util.PriorityQueue;

public class KthLargestElementInAnArray {

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int n : nums) {
            minHeap.offer(n);
            if (minHeap.size() > k)
                minHeap.remove();
        }
        return minHeap.poll();
    }

    public int findKthLargest2(int[] nums, int k) {
        k = nums.length - k;
        int l = 0, r = nums.length - 1;

        while (l < r) {
            int idx = quickSelect(nums, l, r);
            if (idx < k) {
                l = idx + 1;
            } else if (idx > k) {
                r = idx - 1;
            } else {
                break;
            }
        }

        return nums[k];
    }

    private int quickSelect(int[] nums, int l, int r) {
        int i = l, j = r, pivot = nums[l];

        while (i < j) {
            // we select pivot from the very left, so we must start looking the smallest num that bigger than pivot from right.
            while (i < j && nums[j] >= pivot)
                j--;
            while (i < j && nums[i] <= pivot)
                i++;
            if (i < j) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }
        nums[l] = nums[i];
        nums[i] = pivot;

        return i;
    }

    public static void main(String[] args) {
        new KthLargestElementInAnArray().findKthLargest2(new int[]{5,2,4,1,3,6,0}, 4);
    }

}
