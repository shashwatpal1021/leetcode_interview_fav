import java.util.HashSet;
import java.util.Set;

//package Array.Contains Duplicate;

/*
Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.

Example 1:

Input: nums = [1,2,3,1]
Output: true

Example 2:

Input: nums = [1,2,3,4]
Output: false

Example 3:

Input: nums = [1,1,1,3,3,4,3,2,4,2]
Output: true


Constraints:

1 <= nums.length <= 105
-109 <= nums[i] <= 109


*/

public class Solution {
   public static void main(String[] args) {
      int[] arr = { 1, 1, 1, 3, 3, 4, 3, 2, 4, 2 };
      System.out.println(containsDuplicate(arr));
   }
   
   public static boolean containsDuplicate(int[] nums) {
      Set<Integer> seen = new HashSet<>();

      for (final int num : nums)
         if (!seen.add(num))
            return true;

      return false;
   }
}

/*
   public boolean containsDuplicate(int[] nums) {
      // Use HashSet, Check if number gets pushed into the set,
      // if yes return false,
      // else return true

      HashSet<Integer> numCheckSet = new HashSet<>();

      for (int i = 0; i < nums.length; i++) {
         if (!numCheckSet.add(nums[i])) {
            return true;
         }
      }

      return false;
   }
}


Set<Integer> set = new HashSet<>();for(
int n:nums){if(!set.add(n))
{
   return true;
}
}return false;

}

Set<Integer> set = new HashSet<Integer>();

for(
int i = 0;i<nums.length;i++)
{
   if (set.contains(nums[i])) {
      return true;
   }
   set.add(nums[i]);
}

return false;
}


public boolean containsDuplicate(int[] nums) {
        //sort it then find consecutive O(nlogn)-->brute force
        // count arr
        if(nums.length>1 && nums[0]==nums[1]){
            return true;
        }
        int maxNum = Integer.MIN_VALUE;
        int minNum = Integer.MAX_VALUE;
        for(int num : nums){
            if(num > maxNum ){
                maxNum = num;
            }
            if(num < minNum){
                minNum = num;
            }
        }
        boolean [] arr = new boolean[(maxNum-minNum)+1];
        for(int i = 0; i < nums.length; i++){
            if(arr[(nums[i]-minNum)] ){
                return true;
            }
            arr[(nums[i]-minNum)] = true;
        }
                return false;
        
    }

}
*/