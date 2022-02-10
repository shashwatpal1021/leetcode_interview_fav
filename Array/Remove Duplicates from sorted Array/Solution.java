/*
Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such that each unique element appears only once. The relative order of the elements should be kept the same.

Since it is impossible to change the length of the array in some languages, you must instead have the result be placed in the first part of the array nums. More formally, if there are k elements after removing the duplicates, then the first k elements of nums should hold the final result. It does not matter what you leave beyond the first k elements.

Return k after placing the final result in the first k slots of nums.

Do not allocate extra space for another array. You must do this by modifying the input array in-place with O(1) extra memory.


Custom Judge:

The judge will test your solution with the following code:

int[] nums = [...]; // Input array
int[] expectedNums = [...]; // The expected answer with correct length

int k = removeDuplicates(nums); // Calls your implementation

assert k == expectedNums.length;
for (int i = 0; i < k; i++) {
    assert nums[i] == expectedNums[i];
}
If all assertions pass, then your solution will be accepted.


Ex:-
   Input: nums = [1,1,2]
   Output: 2, nums = [1,2,_]
   Explanation: Your function should return k = 2, with the first two elements of nums being 1 and 2 respectively.
   It does not matter what you leave beyond the returned k (hence they are underscores).

Ex:-
   Input: nums = [0,0,1,1,1,2,2,3,3,4]
   Output: 5, nums = [0,1,2,3,4,_,_,_,_,_]
   Explanation: Your function should return k = 5, with the first five elements of nums being 0, 1, 2, 3, and 4 respectively.
   It does not matter what you leave beyond the returned k (hence they are underscores).


   Constraints:

      0 <= nums.length <= 3 * 104
      -100 <= nums[i] <= 100
      nums is sorted in non-decreasing order.


Hint 1:-
      In this problem, the key point to focus on is the input array being sorted. As far as duplicate elements are concerned, what is their positioning in the array when the given array is sorted? Look at the image above for the answer. If we know the position of one of the elements, do we also know the positioning of all the duplicate elements?


Hint 2:-
      We need to modify the array in-place and the size of the final array would potentially be smaller than the size of the input array. So, we ought to use a two-pointer approach here. One, that would keep track of the current element in the original array and another one for just the unique elements.

Hint 3:-
      Essentially, once an element is encountered, you simply need to bypass its duplicates and move on to the next unique element.

*/

class Solution {
   public static int removeDuplicates(int[] nums) {
      int res = 1;
      for (int i = 1; i < nums.length; i++) {
         if (nums[i] != nums[res - 1]) {
            nums[res] = nums[i];
            res++;
         }
      }
      return res;
   }

   public static void main(String[] args) {
      int[] arr = { 1, 1, 2 };
      int[] nums = { 0, 0, 1, 1, 1, 2, 2, 3, 3, 4 };
      System.out.println(removeDuplicates(arr));
      System.out.println(removeDuplicates(nums));
   }
}


/*
class Solution {
   public int removeDuplicates(int[] nums) {
      int index = 0;
      for (int i = 1; i < nums.length; i++) {
         if (nums[index] != nums[i]) {
            nums[++index] = nums[i];
         }
      }
      return index + 1;
   }
}


class Solution {
    public int removeDuplicates(int[] nums) {
     int index = 1;
        for(int i = 0;i< nums.length-1;i++){
            if(nums[i]!= nums[i+1]){
              nums[index++] = nums[i+1];
            }
        }
        return index;
    }
}


class Solution {
   public int removeDuplicates(int[] nums) {
      int l = 1;
      for (int r = 1; r < nums.length; r++) {
         if (nums[r] != nums[r - 1]) {
            nums[l] = nums[r];
            l++;
         }
      }
      return l;
   }
}


class Solution {
   public int removeDuplicates(int[] nums) {

      int sortedPointer = 0;
      // int current = sortedPointer + 1;
      int current = sortedPointer;
      int size = nums.length;

      for (current = 0; current < size; current++) {

         if (nums[current] != nums[sortedPointer]) {
            sortedPointer++;
            nums[sortedPointer] = nums[current];
         }

      }

      return sortedPointer + 1;
   }
}


class Solution {
   public int removeDuplicates(int[] nums) {
      if (nums.length < 2) {
         return nums.length;
      }
      int i = 0;
      for (int j = 1; i < nums.length - 1 && j < nums.length; j++) {
         if (nums[j] > nums[i]) { // move this element to the front
            i++;
            nums[i] = nums[j];
         }
      }
      return i + 1;
   }
}

*/