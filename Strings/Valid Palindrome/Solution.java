
/* 
A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.

Given a string s, return true if it is a palindrome, or false otherwise.

 

Example 1:

Input: s = "A man, a plan, a canal: Panama"
Output: true
Explanation: "amanaplanacanalpanama" is a palindrome.
Example 2:

Input: s = "race a car"
Output: false
Explanation: "raceacar" is not a palindrome.
Example 3:

Input: s = " "
Output: true
Explanation: s is an empty string "" after removing non-alphanumeric characters.
Since an empty string reads the same forward and backward, it is a palindrome.
 

Constraints:

1 <= s.length <= 2 * 105
s consists only of printable ASCII characters.

*/



class Solution {
   public boolean isPalindrome(String s) {
      int l = 0;
      int r = s.length() - 1;

      while (l < r) {
         while (l < r && !Character.isLetterOrDigit(s.charAt(l)))
            ++l;
         while (l < r && !Character.isLetterOrDigit(s.charAt(r)))
            --r;
         if (Character.toLowerCase(s.charAt(l)) != Character.toLowerCase(s.charAt(r)))
            return false;
         ++l;
         --r;
      }

      return true;
   }
}


class Solution {
   public boolean isPalindrome(String s) {

      List<Integer> list = new ArrayList<>();
      for (int i = 0; i < s.length(); i++) {
         int ascii = (int) s.charAt(i);

         if (ascii >= 97 && ascii <= 122)
            list.add(ascii);
         else if (ascii >= 65 && ascii <= 90)
            list.add(ascii + 32);
         else if (ascii >= 48 && ascii <= 57)
            list.add(ascii);
      }

      int l = 0, r = list.size() - 1;
      while (l <= r) {
         if (list.get(l) != list.get(r))
            return false;

         l++;
         r--;
      }

      return true;
   }
}



class Solution {
   public boolean isPalindrome(String s) {
      if (s == null || s.length() <= 1) {
         return true;
      }

      int start = 0, end = s.length() - 1;

      while (start < end) {
         char chL = s.charAt(start);
         if (!Character.isLetterOrDigit(chL)) {
            start++;
            continue;
         }

         char chR = s.charAt(end);
         if (!Character.isLetterOrDigit(chR)) {
            end--;
            continue;
         }

         if (Character.toLowerCase(chL) != Character.toLowerCase(chR)) {
            return false;
         }
         start++;
         end--;
      }

      return true;
   }
}


class Solution {
   public boolean isPalindrome(String s) {
      s = s.toLowerCase().replaceAll("[^a-z0-9]", "");
      int j = s.length() - 1;
      for (int i = 0; i < s.length(); i++) {
         if (s.charAt(i) != s.charAt(j)) {
            return false;
         }
         j--;
      }
      return true;
   }
}






class Solution {
   public boolean isPalindrome(String s) {
      if (s.length() == 1) {
         return true;
      }
      s = s.toLowerCase();
      s = s.replaceAll("[^a-z0-9]", "");

      int i = 0;
      int j = (s.length() - 1);

      while (i < j) {
         if (s.charAt(i) != s.charAt(j)) {
            return false;
         }
         i++;
         j--;
      }
      System.out.println(s);

      return true;
   }

}