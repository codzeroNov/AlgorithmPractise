package BinarySearch;

import java.util.Arrays;

public class Heaters {
    /**
     * Winter is coming! During the contest, your first job is to design a standard heater with a fixed warm radius to warm all the houses.
     *
     * Every house can be warmed, as long as the house is within the heater's warm radius range.
     *
     * Given the positions of houses and heaters on a horizontal line, return the minimum radius standard of heaters so that those heaters could cover all houses.
     *
     * Notice that all the heaters follow your radius standard, and the warm radius will the same.
     * **/

    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(heaters);
        int res = Integer.MIN_VALUE;
        for (int house : houses) {
            int rad = find(heaters, house);
            res = Math.max(res, rad);
        }

        return res;
    }

    private int find(int[] heaters, int pos) {
        int i = 0, j = heaters.length - 1;
        int l = Integer.MAX_VALUE, r = Integer.MAX_VALUE;
        while (i <= j) {
            int mid = (i + j) / 2;
            if (pos == heaters[mid]) {
                return 0;
            } else if (pos > heaters[mid]) {
                r = pos - heaters[mid];
                i = mid + 1;
            } else {
                l = heaters[mid] - pos;
                j = mid - 1;
            }
        }

        return Math.min(l, r);
    }
}
