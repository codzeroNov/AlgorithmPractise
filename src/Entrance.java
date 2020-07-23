import OtherTricky.QuickSort;

public class Entrance {
    static int[] nums = new int[]{1,9,5,3,4,7,6};
    public static void main(String[] args) {
        new QuickSort().quickSort(nums, 0, 6);
        for (int n : nums)
            System.out.println(n);
    }
}
