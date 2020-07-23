package OtherTricky;

public class LongestTurbulentSubarray {
/*
    当 A 的子数组 A[i], A[i+1], ..., A[j] 满足下列条件时，我们称其为湍流子数组：

    若 i <= k < j，当 k 为奇数时， A[k] > A[k+1]，且当 k 为偶数时，A[k] < A[k+1]；
    或
    若 i <= k < j，当 k 为偶数时，A[k] > A[k+1] ，且当 k 为奇数时， A[k] < A[k+1]。
    也就是说，如果比较符号在子数组中的每个相邻元素对之间翻转，则该子数组是湍流子数组。

    返回 A 的最大湍流子数组的长度。
*/

    public int maxTurbulenceSize(int[] A) {
        int inc = 1, dec = 1, result = 1;
        for (int i = 1; i < A.length; i++) {
            if (A[i] > A[i-1]) {
                inc = dec + 1;
                dec = 1;
            } else if (A[i] < A[i-1]) {
                dec = inc + 1;
                inc = 1;
            } else {
                inc = 1;
                dec = 1;
            }
            result = Math.max(result, Math.max(inc, dec));
        }
        return result;
    }



}
