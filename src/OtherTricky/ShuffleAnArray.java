package OtherTricky;

import java.util.Random;

public class ShuffleAnArray {
    /*
    Shuffle a set of numbers without duplicates.
     */
    class Solution {
        Random rand;
        int[] arr;
        int[] origin;

        public Solution(int[] nums) {
            rand = new Random();
            arr = nums;
            origin = nums.clone();
        }

        /** Resets the array to its original configuration and return it. */
        public int[] reset() {
            arr = origin;
            origin = arr.clone();
            return arr;
        }

        /** Returns a random shuffling of the array. */
        public int[] shuffle() {
            for (int i = 0; i < origin.length; i++) {
                swapAt(i, getRandIdx(i, origin.length));
            }
            return arr;
        }

        private int getRandIdx(int min, int max) {
            return rand.nextInt(max - min) + min;
        }

        private void swapAt(int i, int j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }
}
