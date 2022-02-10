//package Array.Move Zeroes;
/*
Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.

Note that you must do this in-place without making a copy of the array.


Example 1:

Input: nums = [0,1,0,3,12]
Output: [1,3,12,0,0]

Example 2:

Input: nums = [0]
Output: [0]
 

Constraints:

1 <= nums.length <= 104
-231 <= nums[i] <= 231 - 1
 

Follow up: Could you minimize the total number of operations done?

*/

class Solution {
   static void printArray(int[] arr) {
      for (int i = 0; i < arr.length; i++) {
         System.out.print(arr[i] + " ");
      }
   }

   public static void main(String[] args) {
      int[] arr = { 0, 1, 0, 3, 12 };
      moveZeros(arr);
      printArray(arr);
   }

   static void moveZeros(int[] arr) {
      int i = 0;
      for (int j = 0; j < arr.length; j++) {
         if (j != 0)
            arr[i++] = j;
      }
      while (i < arr.length)
         arr[i++] = 0;

   }
}

   public void moveZeroes(int[] nums) {
      int count = 0;
      for (int i = 0; i < nums.length; i++) {
         if (nums[i] != 0) {
            nums[count] = nums[i];
            count++;
         }
      }
      for (int i = count; i < nums.length; i++) {
         nums[i] = 0;
      }
   }


   public void moveZeroes(int[] nums) {
        int i=0,j=0;
        while(i<nums.length){
            if(nums[i]!=0){
                nums[j++]=nums[i];
            }
            i++;
        }
        while(j<nums.length) nums[j++] = 0;
    }


  public void moveZeroes(int[] nums) {
     int p = 0;
    for (int i = 0; i < nums.length; i++) {
      if (nums[p] == 0 && nums[i] != 0) {
        nums[p] = nums[i];
        nums[i] = 0;
        p++;
      } else if (nums[p] != 0) {
        p++;
      }
    }
    }