import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.stream.Collectors;

public class App {
    public static void main(String[] args) throws Exception {
        int[] nums1 = new int[] { 4, 1, 2 };
        int[] nums2 = new int[] { 1, 3, 4, 2 };
        System.out.println(Arrays.toString(nextGreaterElement(nums1, nums2)));
    }

    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack<>();

        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        // Map nums1 elements to its index
        for (int i = 0; i < nums1.length; i++) {
            map.put(nums1[i], i);
        }

        int[] res = new int[nums1.length];
        // Initialize all elements to -1
        Arrays.fill(res, -1);

        for (int i = 0; i < nums2.length; i++) {
            int element = nums2[i];

            // If the current element from nums2 is bigger than the peek of the stack, that
            // means that we have "the Next Greater Element" to that element!
            // Now we need to put this "element" inside the "res" arr with the same index of the 
            // current "val" .. this index is already inside the "map".
            // Don't forget to pop the item from the stack.
            while (!stack.isEmpty() && stack.peek() <= element) {
                int val = stack.pop();
                int indx = map.get(val);
                res[indx] = element;
            }

            // If current element from nums2 is inside map, then push it to the stack
            if (map.keySet().contains(element)) {
                stack.push(element);
            }
        }

        return res;

        /*
         * int[] ans = new int[nums1.length];
         * 
         * Stack<Integer> stack = new Stack<>();
         * HashMap<Integer, Integer> map = new HashMap<>();
         * 
         * // find out all the next greater elements in nums2 array
         * for(int num: nums2) {
         * // if num is greater than top elements in stack then it is the next greater
         * element in nums2
         * while(!stack.isEmpty() && num > stack.peek()) {
         * map.put(stack.pop(), num);
         * }
         * // then add num to stack
         * stack.add(num);
         * }
         * 
         * int i = 0;
         * for(int num : nums1) {
         * ans[i++] = map.getOrDefault(num, -1);
         * }
         * 
         * return ans;
         * 
         */

        // Stack<Integer> stack = new Stack<>();

        // for (int i = nums2.length - 1; i >= 0; i--) {
        // int element = nums2[i];

        // // No greater elements till now
        // if (stack.isEmpty()) {
        // stack.push(element);
        // nums2[i] = -1;
        // }

        // if (stack.peek() > element) {
        // nums2[i] = stack.peek();
        // stack.push(element);
        // }

        // while (!stack.isEmpty() && stack.peek() <= element) {
        // stack.pop();
        // }

        // if (stack.isEmpty()) {
        // nums2[i] = -1;
        // } else {
        // nums2[i] = stack.peek();
        // }
        // stack.push(element);
        // }

        // return nums2;

        // Map<Integer, Integer> map1 = new LinkedHashMap<>();
        // Map<Integer, Integer> map2 = new LinkedHashMap<>();

        // int[] res = new int[nums1.length];

        // for (int i = 0; i < nums1.length; i++) {
        // map1.put(nums1[i], i + 1 > nums1.length - 1 ? -1 : nums1[i + 1]);
        // }
        // System.out.println(map1);

        // for (int i = 0; i < nums2.length; i++) {
        // if (i + 1 < nums2.length - 1) {
        // if (nums2[i + 1] > nums2[i])
        // map2.put(nums2[i], nums2[i + 1]);
        // else
        // break;
        // } else
        // map2.put(nums2[i], -1);

        // }
        // System.out.println(map2);

        // for (int i = 0; i < map2.keySet().size() - 1; i++) {
        // if (i > map1.keySet().size() - 1)
        // break;
        // res[i] = map2.get(map1.keySet().toArray()[i]);
        // }

        // return res;
    }
}
