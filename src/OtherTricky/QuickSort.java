package OtherTricky;

public class QuickSort {


    public void quickSort (int[] nums, int left, int right) {
        if (left >= right)
            return;

        int i = left, j = right;
        int pivot = nums[left];

        while (i < j) {
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
        nums[left] = nums[i];
        nums[i] = pivot;
        quickSort(nums, left, i-1);
        quickSort(nums, i+1, right);
    }
}
