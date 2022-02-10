//package Array.Rotate Array;

/*
Given an array,rotate the array to the right by k steps,where k is non-negative.

Input:nums=[1,2,3,4,5,6,7],k=3 
Output:[5,6,7,1,2,3,4]
Explanation:
rotate 1 steps to the right:[7,1,2,3,4,5,6]
rotate 2 steps to the right:[6,7,1,2,3,4,5]
rotate 3 steps to the right:[5,6,7,1,2,3,4]

Input:nums=[-1,-100,3,99],k=2 
Output:[3,99,-1,-100]
Explanation:
rotate 1 steps to the right:[99,-1,-100,3]
rotate 2 steps to the right:[3,99,-1,-100]

Constraints:

1<=nums.length<=105-231<=nums[i]<=231-1 0<=k<=105

Follow up:

Try to come up with as many solutions as you can. There are at least three different ways to solve this problem.
Could you do it in-place with O(1) extra space?
*/

class Solution {
   static void printArray(int[] arr) {
      for (int i = 0; i < arr.length; i++) {
         System.out.print(arr[i]+" ");
      }
   }
   public static void main(String[] args){
      int[] arr = {1,2,3,4,5,6,7};
      int k=3;
      rotate(arr, k);
      printArray(arr);

   }
   public static int[] rotate(int[] nums, int k) {
      while (k-- > 0) {
         int val = nums[nums.length - 1];
         for (int i = nums.length - 1; i > 0; i--) {
            nums[i] = nums[i - 1];
         }
         nums[0] = val;
      }
        return nums;
    }
}

/*
(

public void rotate(int[] nums, int k) {
   k %= nums.length;
   reverse(nums, 0, nums.length - 1);
   reverse(nums, 0, k - 1);
   reverse(nums, k, nums.length - 1);
}

private void reverse(int[] nums, int l, int r) {
   while (l < r)
      swap(nums, l++, r--);
}

private void swap(int[] nums, int l, int r) {
   final int temp = nums[l];
   nums[l] = nums[r];
   nums[r] = temp;
}
)

class Solution {
public void rotate(int[] nums, int k) {
        int n = nums.length;
        k %= nums.length;
        reverse(nums,0, n-1);
        reverse(nums,0, k-1);
        reverse(nums,k, n-1);
    }
    
    public void reverse(int arr[], int start, int end){
        while(start < end){
            swap(arr, start++, end--);
        }
    }
    
    public void swap(int[] arr, int s, int e){
        int temp = arr[s];
        arr[s] = arr[e];
        arr[e] = temp;
    }
}

class Solution {
    public void rotate(int[] nums, int k) {
        k = k%nums.length;
        reverse(nums,0,nums.length-1);
        reverse(nums,0,k-1);
        reverse(nums,k,nums.length-1);
        
    }
    
    public void reverse(int[] nums,int i, int j)
    {
        while(i<j)
        {
            int temp = nums[i];
            nums[i]=nums[j];
            nums[j]=temp;
            i++;
            j--;
        }
    }
}
*/