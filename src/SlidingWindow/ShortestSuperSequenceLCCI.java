package SlidingWindow;

import java.util.HashMap;
import java.util.Map;

class ShortestSuperSequenceLCCI {
/*
    假设你有两个数组，一个长一个短，短的元素均不相同。找到长数组中包含短数组所有的元素的最短子数组，其出现顺序无关紧要。

    返回最短子数组的左端点和右端点，如有多个满足条件的子数组，返回左端点最小的一个。若不存在，返回空数组。
*/

    public int[] shortestSeq(int[] big, int[] small) {
        if (small.length > big.length)
            return new int[0];

        HashMap<Integer, Integer> map = new HashMap<>();
        HashMap<Integer, Integer> bm = new HashMap<>();
        for (int num : small)
            map.put(num, 1);

        int l = 0, r = 0, min = big.length, len = big.length, count = small.length;
        int[] ret = new int[2];
        while (r < len) {
            //update count
            if (map.containsKey(big[r])) {
                bm.put(big[r], bm.getOrDefault(big[r], 0) + 1);
                if (bm.get(big[r]).equals(map.get(big[r])))
                    count--;
            }
            //move window's left boundary
            while (count == 0) {
                if (min > r - l) {
                    min = r - l;
                    ret[0] = l;
                    ret[1] = r;
                }
                if (map.containsKey(big[l])){
                    bm.put(big[l], bm.get(big[l]) - 1);
                    if (bm.get(big[l]) < map.get(big[l]))
                        count++;
                }
                l++;
            }

            r++;
        }
        if(ret[1] - 1 < ret[0]) {
            return new int[0];
        } else {
            return ret;
        }

    }

    public int[] shortestSeq2(int[] big, int[] small) {
        if(big.length < small.length) return new int[0];
        Map<Integer, Integer> smallMap = new HashMap<>(small.length);
        for (int i = 0; i < small.length; i++) {
            smallMap.put(small[i], smallMap.getOrDefault(small[i], 0) +1);
        }
        Map<Integer, Integer> bigMap = new HashMap<>(small.length);
        int left = 0, right = 0, match = 0;
        int min = Integer.MAX_VALUE;
        int l = -1, r = -1;
        while(right < big.length){
            int rightValue = big[right++];
            if(smallMap.containsKey(rightValue)){
                bigMap.put(rightValue, bigMap.getOrDefault(rightValue, 0) +1);
                if(smallMap.get(rightValue).equals(bigMap.get(rightValue))){
                    match++;
                }
            }
            while(match == smallMap.size()){
                if(right - left < min){
                    l =  left;
                    r = right;
                    min = right - left;
                }
                int leftValue = big[left++];
                if(smallMap.containsKey(leftValue)){
                    bigMap.put(leftValue, bigMap.get(leftValue)-1);
                    if(bigMap.get(leftValue) < smallMap.get(leftValue)) {
                        match--;
                    }
                }
            }
        }
        if(r-1 < l ) {
            return new int[0];
        } else {
            return new int[]{l,r-1};
        }
    }

}