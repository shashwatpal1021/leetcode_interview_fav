/*
Implement strStr().

Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

Clarification:

What should we return when needle is an empty string? This is a great question to ask during an interview.

For the purpose of this problem, we will return 0 when needle is an empty string. This is consistent to C's strstr() and Java's indexOf().

 

Example 1:

Input: haystack = "hello", needle = "ll"
Output: 2
Example 2:

Input: haystack = "aaaaa", needle = "bba"
Output: -1
Example 3:

Input: haystack = "", needle = ""
Output: 0
 

Constraints:

0 <= haystack.length, needle.length <= 5 * 104
haystack and needle consist of only lower-case English characters.
*/


class Solution {
   public int strStr(String haystack, String needle) {
      final int m = haystack.length();
      final int n = needle.length();

      for (int i = 0; i < m - n + 1; ++i)
         if (haystack.substring(i, i + n).equals(needle))
            return i;

      return -1;
   }
}




class Solution {
   private void computeLPSArray(int[] lps, String pattern) {
      int i = 1;
      int len = 0;

      while (i < pattern.length()) {
         if (pattern.charAt(i) == pattern.charAt(len))
            lps[i++] = ++len;
         else {
            if (len != 0)
               len = lps[len - 1];
            else
               lps[i++] = len;
         }
      }
   }


   class Solution {
      public int strStr(String haystack, String needle) {
         if (needle.length() == 0)
            return 0;
         for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            for (int j = needle.length() - 1; j >= 0; j--) {
               if (haystack.charAt(i + j) != needle.charAt(j))
                  break;
               if (j == 0)
                  return i;
            }
         }
         return -1;
      }
   }


   class Solution {
      public int strStr(String haystack, String needle) {

         if (needle.length() == 0) {
            return 0;
         }
         int L1 = haystack.length();
         int L2 = needle.length();
         // if L1="aaa",L2="aaa",L1-L2 will be 0,so it is a special case
         if (L1 == L2) {
            if (haystack.equals(needle)) {
               return 0;
            } else {
               return -1;
            }
         }
         for (int i = 0; i <= L1 - L2; i++) {
            String str = haystack.substring(i, i + L2);
            if (str.equals(needle)) {
               return i;
            }
         }
         return -1;
      }
   }







   public int strStr(String haystack, String needle) {
      if (needle.length() == 0) {
         return 0;
      }

      int N = haystack.length();
      int M = needle.length();

      int[] lps = new int[M];
      computeLPSArray(lps, needle);

      int hay = 0;
      int ned = 0;

      while (hay < N) {
         if (needle.charAt(ned) == haystack.charAt(hay)) {
            hay++;
            ned++;
         }

         if (ned == M) {
            return hay - ned;
         } else if (hay < N && needle.charAt(ned) != haystack.charAt(hay)) {
            if (ned != 0)
               ned = lps[ned - 1];
            else
               hay++;
         }
      }
      return -1;
   }
}