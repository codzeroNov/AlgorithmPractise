package BinarySearch;

public class FindTheDuplicateNumber {
    /*
        Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive), prove that at least one duplicate number must exist.
        Assume that there is only one duplicate number, find the duplicate one.

        Note:
        You must not modify the array (assume the array is read only).
        You must use only constant, O(1) extra space.
        Your runtime complexity should be less than O(n2).
        There is only one duplicate number in the array, but it could be repeated more than once.
    */
    //binary search,    space O(1),    time O(NlogN)
    public int findDuplicate(int[] nums) {
        int l = 0, r = nums.length - 1, cnt, ans = -1;

        while (l <= r) {
            int target = (r - l) / 2 + l;
            cnt = 0;
            for (int n : nums) {
                if (n <= target) cnt++;
            }

            if (cnt <= target) {
                l = target + 1;
            } else {
                r = target - 1;
                ans = target;
            }
        }

        return ans;
    }
    // Floyd circle

    /**
     *这里简单解释为什么后面将 slow 放置起点后移动相遇的点就一定是答案了。假设环长为 L，从起点到环的入口的步数是 a，从环的入口继续走 b 步到达相遇位置，
     * 从相遇位置继续走 c 步回到环的入口，则有 b+c=L，其中 L、a、b、c 都是正整数。根据上述定义，慢指针走了 a+b 步，快指针走了 2(a+b) 步。
     * 从另一个角度考虑，在相遇位置，快指针比慢指针多走了若干圈，因此快指针走的步数还可以表示成 a+b+kL，其中 k 表示快指针在环上走的圈数。联立等式，可以得到
     *
     * 2(a+b)=a+b+kL
     *
     * 解得 a=kL-ba=kL−b，整理可得
     *
     * a=(k-1)L+(L-b)=(k-1)L+c
     *
     * 从上述等式可知，如果慢指针从起点出发，快指针从相遇位置出发，每次两个指针都移动一步，则慢指针走了 a 步之后到达环的入口，快指针在环里走了 k-1 圈之后又走了 c 步，
     * 由于从相遇位置继续走 c 步即可回到环的入口，因此快指针也到达环的入口。两个指针在环的入口相遇，相遇点就是答案。
     *
     */
    public int findDuplicate2(int[] nums) {
        int slow = nums[0], fast = nums[nums[0]];

        while (slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }

        slow = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow;
    }

}
