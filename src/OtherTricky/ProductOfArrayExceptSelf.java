package OtherTricky;

public class ProductOfArrayExceptSelf {

    //给你一个长度为 n 的整数数组 nums，其中 n > 1，返回输出数组 output ，其中 output[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积。

    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] L = new int[len];
        int[] R = new int[len];

        L[0] = 1;
        for (int i = 1; i < len; i++)
            L[i] = L[i - 1] * nums[i - 1];

        R[len - 1] = 1;
        for (int i = len - 2; i >= 0; i--)
            R[i] = R[i + 1] * nums[i + 1];

        int[] ans = new int[len];
        for (int i = 0; i < len; i++)
            ans[i] = L[i] * R[i];


        return ans;
    }

    public int[] productExceptSelf2(int[] nums) {
        int len = nums.length;
        int[] ans = new int[len];

        ans[0] = 1;
        for (int i = 1; i < len; i++)
            ans[i] = ans[i - 1] * nums[i - 1];

        int R = 1;
        for (int i = len - 1; i >= 0; i--) {
            ans[i] = ans[i] * R;
            R *= ans[i];
        }

        return ans;
    }

}
