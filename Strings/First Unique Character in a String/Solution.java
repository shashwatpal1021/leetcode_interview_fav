/*
Given a string s, find the first non-repeating character in it and return its index. If it does not exist, return -1.

 

Example 1:

Input: s = "leetcode"
Output: 0
Example 2:

Input: s = "loveleetcode"
Output: 2
Example 3:

Input: s = "aabb"
Output: -1
 

Constraints:

1 <= s.length <= 105
s consists of only lowercase English letters.
*/

class Solution {
   public int firstUniqChar(String s) {
      int[] count = new int[128];

      for (final char c : s.toCharArray())
         ++count[c];

      for (int i = 0; i < s.length(); ++i)
         if (count[s.charAt(i)] == 1)
            return i;

      return -1;
   }
}



class Solution {
   public int firstUniqChar(String s) {
      int[] count = new int[26];
      int n = s.length();
      // build char count bucket : <charIndex, count>
      for (int i = 0; i < n; i++) {
         int index = s.charAt(i) - 'a';
         count[index]++;
      }

      // find the index
      for (int i = 0; i < n; i++) {
         int index = s.charAt(i) - 'a';
         if (count[index] == 1) {
            return i;
         }

      }
      return -1;
   }
}


class Solution {
   public int firstUniqChar(String s) {
      if (s.isEmpty())
         return -1;

      int[] count = new int[26];
      for (int i = s.length() - 1; i >= 0; i--) {
         count[s.charAt(i) - 'a']++;
      }
      for (int i = 0; i < s.length(); i++) {
         if (count[s.charAt(i) - 'a'] == 1) {
            return i;
         }
      }
      return -1;
   }
}


