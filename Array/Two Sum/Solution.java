/*
Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.

 

Example 1:

Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
Example 2:

Input: nums = [3,2,4], target = 6
Output: [1,2]
Example 3:

Input: nums = [3,3], target = 6
Output: [0,1]
 

Constraints:

2 <= nums.length <= 10^4
-10^9 <= nums[i] <= 10^9
-10^9 <= target <= 10^9
Only one valid answer exists.
 

Follow-up: Can you come up with an algorithm that is less than O(n2) time complexity?

*/


class Solution {
   public int[] twoSum(int[] nums, int target) {
      for (int i = 0; i < nums.length; i++) {
         for (int j = i + 1; j < nums.length; j++) {
            if (nums[i] + nums[j] == target) {
               return new int[] { i, j };
            }
         }
      }
      return new int[] {};
   }

}

/*

class Solution {
   public int[] twoSum(int[] nums, int target) {
      HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
      for (int i = 0; i < nums.length; i++) {
         Integer diff = (Integer) (target - nums[i]);
         if (map.containsKey(diff)) {
            int values[] = { map.get(diff), i };
            return values;
         }
         map.put(nums[i], i);
      }
      return null;
   }
}


class Solution {
   public int[] twoSum(int[] nums, int target) {
      int[] ret = new int[2];
      HashMap<Integer, Integer> map = new HashMap<>();
      for (int i = 0; i < nums.length; i++) {
         if (map.containsKey(target - nums[i])) {
            ret[0] = map.get(target - nums[i]);
            ret[1] = i;
            break;
         } else {
            map.put(nums[i], i);
         }
      }
      return ret;
   }
}




import java.util.HashMap;
import java.util.Map;

class Solution {
   public int[] twoSum(int[] nums, int target) {
      Map<Integer, Integer> map = new HashMap<>();
      for (int i = 0; i < nums.length; i++) {
         if (map.containsKey(nums[i])) {
            return new int[] { map.get(nums[i]), i };
         } else {
            map.put(target - nums[i], i);
         }
      }
      return null;
   }
}



class Solution {
   public int[] twoSum(int[] nums, int target) {
      
       * int[] result = new int[2];
       * for (int i = 0; i < nums.length-1; i++){
       * for (int j = i+1; j < nums.length; j++){
       * if (nums[i] +nums[j] == target){
       * result[0] = i;
       * result[1] = j;
       * }
       * }
       * }
       * return result;
       
      int[] res = new int[2];
      HashMap<Integer, Integer> map = new HashMap<>();
      for (int i = 0; i < nums.length; i++) {
         int a = nums[i];
         int b = target - a;

         if (map.containsKey(b)) {
            res[0] = map.get(b);
            res[1] = i;
            return res;
         }
         map.put(a, i);
      }
      return res;
   }
}
*/


