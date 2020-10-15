package OtherTricky;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class InsertDeleteGetRandomO_1 {
    /*
    Implement the RandomizedSet class:

    bool insert(int val) Inserts an item val into the set if not present. Returns true if the item was not present,
    false otherwise.
    bool remove(int val) Removes an item val from the set if present. Returns true if the item was present,
    false otherwise.
    int getRandom() Returns a random element from the current set of elements (it's guaranteed that at least one element exists when this method is called).
    Each element must have the same probability of being returned.

    Follow up: Could you implement the functions of the class with each function works in average O(1) time?
     */
    class RandomizedSet {
        private HashMap<Integer, Integer> dict;
        private ArrayList<Integer> list;
        private Random rand;
        /** Initialize your data structure here. */
        public RandomizedSet() {
            dict = new HashMap<>();
            list = new ArrayList<>();
            rand = new Random();
        }

        /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
        public boolean insert(int val) {
            if (dict.containsKey(val))
                return false;
            list.add(val);
            dict.put(val, list.size() - 1);
            return true;
        }

        /** Removes a value from the set. Returns true if the set contained the specified element. */
        public boolean remove(int val) {
            if (!dict.containsKey(val))
                return false;
            int temp = list.get(list.size() - 1);
            int pos = dict.get(val);
            list.set(pos, temp);
            dict.put(temp, pos);
            dict.remove(val);
            list.remove(list.size() - 1);
            return true;
        }

        /** Get a random element from the set. */
        public int getRandom() {
            return list.get(rand.nextInt(list.size()));
        }
    }
}

