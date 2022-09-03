package OtherTricky;

import java.util.*;

public class MinimumAmountOfTimeToCollectGarbage {



    public int garbageCollection(String[] garbage, int[] travel) {
        Map<Character, ArrayList<Integer>> map = new HashMap<>();

        for (int i = 0; i < garbage.length; i++) {
            for (char unit : garbage[i].toCharArray()) {
                if (!map.containsKey(unit))
                    map.put(unit, new ArrayList<>());
                map.get(unit).add(i);
            }
        }

        int[] prefixSum = new int[travel.length];
        prefixSum[0] = travel[0];
        for (int i = 1; i < travel.length; i++)
            prefixSum[i] = prefixSum[i - 1] + travel[i];


        int[] res = new int[3];
        int idx = 0;
        int lastPos = 0;
        Set<Integer> visited = new HashSet<>();
        for (char unit : map.keySet()) {
            visited.add(0);
            ArrayList<Integer> posList = map.get(unit);
            for (int i = 0; i < posList.size(); i++) {
                res[idx] += 1;
                int pos = posList.get(i);
                if (visited.add(pos) && pos != 0) {
                    if (pos == 1)
                        res[idx] += travel[0];
                    else if (lastPos == 0)
                        res[idx] += prefixSum[pos - 1];
                    else
                        res[idx] += (prefixSum[pos - 1] - prefixSum[lastPos - 1]);
                }
                lastPos = pos;
            }
            idx++;
            visited = new HashSet<>();
        }

        int total = 0;
        for (int min : res)
            total += min;

        return total;
    }

    public static void main(String[] args) {
        String[] strs = {"PMMMM","P","PPGM","GMGGPM"};
        int[] ints = {4,1,3};
        new MinimumAmountOfTimeToCollectGarbage().garbageCollection(strs, ints);
    }
}
