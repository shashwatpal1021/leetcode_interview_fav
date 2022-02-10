/*

Write a function that reverses a string. The input string is given as an array of characters s.

You must do this by modifying the input array in-place with O(1) extra memory.


Example 1:

Input: s = ["h","e","l","l","o"]
Output: ["o","l","l","e","h"]
Example 2:

Input: s = ["H","a","n","n","a","h"]
Output: ["h","a","n","n","a","H"]
 

Constraints:

1 <= s.length <= 105
s[i] is a printable ascii character.

*/








class Solution {
   public void reverseString(char[] s) {
      int l = 0;
      int r = s.length - 1;

      while (l < r) {
         char temp = s[l];
         s[l++] = s[r];
         s[r--] = temp;
      }
   }
}


class Solution {
   public void reverseString(char[] s) {
      int l = 0;
      int r = s.length - 1;
      while (l < r) {
         char c = s[l];
         s[l] = s[r];
         s[r] = c;
         l++;
         r--;
      }
   }
}



class Solution {
   public void swap(char[] s, int i, int j) {
      char temp = s[i];
      s[i] = s[j];
      s[j] = temp;
   }

   public void reverseString(char[] s) {
      for (int i = 0; i < s.length / 2; i++) {
         this.swap(s, i, s.length - i - 1);
      }
   }
}