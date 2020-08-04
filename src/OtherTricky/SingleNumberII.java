package OtherTricky;

public class SingleNumberII {
    /*
        Given a non-empty array of integers, every element appears three times except for one, which appears exactly once. Find that single one.
        Note:
        Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
    */
    public int singleNumber(int[] nums) {
        return generalApproach(nums, 3);
    }

    private int generalApproach(int[] nums, int k) {
        int ans = 0;

        for (int i = 0; i < 32; i++) {
            int bitCnt = 0;
            for (int j = 0; j < nums.length; j++) {
                if ((nums[j] >> i & 1) == 1) {
                    bitCnt++;
                    bitCnt %= k;
                }
            }
            if (bitCnt != 0)
                ans |= bitCnt << i;
        }

        return ans;
    }
}
