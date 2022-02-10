
/*
Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.

Assume the environment does not allow you to store 64-bit integers (signed or unsigned).

 

Example 1:

Input: x = 123
Output: 321
Example 2:

Input: x = -123
Output: -321
Example 3:

Input: x = 120
Output: 21
 

Constraints:

-2^31 <= x <= 2^31 - 1
*/

class Solution {
   public int reverse(int x) {
      long ans = 0;

      while (x != 0) {
         ans = ans * 10 + x % 10;
         x /= 10;
      }

      return (ans < Integer.MIN_VALUE || ans > Integer.MAX_VALUE) ? 0 : (int) ans;
   }
}


class Solution {
   public int reverse(int x) {
      int ans = 0;
      while (x != 0) {
         int dig = x % 10;
         if ((ans > Integer.MAX_VALUE / 10) || (ans < Integer.MIN_VALUE / 10)) {
            return 0;
         }
         ans = (ans * 10) + dig;
         x = x / 10;
      }
      return ans;
   }
}


class Solution {
   public int reverse(int x) {
      long rev = 0;
      if (x < 0) {
         x = -x;
         while (x > 0) {
            rev = rev * 10 + x % 10;
            x = x / 10;
         }
         rev = -rev;
      } else {
         while (x > 0) {
            rev = rev * 10 + x % 10;
            x = x / 10;
         }
      }
      if (rev > 2147483647 || rev < -2147483648) {
         return 0;
      }
      return (int) rev;
   }
}

























class Solution {
   public int reverse(int x) {
      long reverse = 0;
      while (x != 0) {
         long remainder = x % 10;
         reverse = reverse * 10 + remainder;
         x = x / 10;
      }
      if (reverse > 2147483641L || reverse < -2147483648L)
         return 0;
      return (int) reverse;
   }
}