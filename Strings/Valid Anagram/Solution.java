/*
Given two strings s and t, return true if t is an anagram of s, and false otherwise.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

 

Example 1:

Input: s = "anagram", t = "nagaram"
Output: true
Example 2:

Input: s = "rat", t = "car"
Output: false
 

Constraints:

1 <= s.length, t.length <= 5 * 104
s and t consist of lowercase English letters.
 

Follow up: What if the inputs contain Unicode characters? How would you adapt your solution to such a case?
*/

class Solution {
   public boolean isAnagram(String s, String t) {
      if (s.length() != t.length())
         return false;

      int[] count = new int[128];

      for (final char c : s.toCharArray())
         ++count[c];

      for (final char c : t.toCharArray())
         if (--count[c] < 0)
            return false;

      return true;
   }
}



class Solution {
   public boolean isAnagram(String s, String t) {
      if (s.length() != t.length()) {
         return false;
      }
      int[] counts = new int[26];
      for (int i = 0; i < s.length(); i++) {
         counts[s.charAt(i) - 'a']++;
         counts[t.charAt(i) - 'a']--;
      }
      for (int i = 0; i < counts.length; i++) {
         if (counts[i] != 0) {
            return false;
         }
      }
      return true;
   }
}




class Solution {
   public boolean isAnagram(String s, String t) {
      if (s.length() != t.length()) {
         return false;
      }
      int[] array = new int[26];

      for (char ch : s.toCharArray()) {
         array[ch - 'a']++;
         // array[s.charAt(i) - 'a']++;
         // array[t.charAt(i) - 'a']--;
      }
      for (char ch : t.toCharArray()) {
         array[ch - 'a']--;
      }
      for (int j = 0; j < array.length; j++) {
         if (array[j] != 0) {
            return false;
         }
      }
      return true;
   }
}



class Solution {
   public boolean isAnagram(String s, String t) {

      if (s.length() != t.length()) {
         return false;
      }

      int[] bucket = new int[26];

      for (int i = 0; i < s.length(); i++) {
         bucket[s.charAt(i) - 97]--;
         bucket[t.charAt(i) - 97]++;
      }

      for (int i = 0; i < bucket.length; i++) {
         if (bucket[i] != 0) {
            return false;
         }
      }
      return true;
   }
}


class Solution {
   public boolean isAnagram(String s, String t) {
      char[] first = s.toCharArray();
      char[] second = t.toCharArray();

      Arrays.sort(first);
      Arrays.sort(second);

      return Arrays.equals(first, second);
   }
}


class New {

   public static void main(String[] args) {
      // String a = "sadder";
      // String b = "dreads";
      String s = "shashwat";
      char[] S = s.toCharArray();
      char[] a = { 's', 'a', 'd', 'd', 'e', 'r' };
      char[] b = { 'd', 'r', 'e', 'a', 'd', 's' };

      int n1 = a.length;
      int n2 = b.length; //

      int arr[] = new int[26];
      for (int i = 0; i < a.length; i++) {
         arr[a[i] - 'a']++;
      }
      int arr1[] = new int[26];
      for (int i = 0; i < b.length; i++) {
         arr1[b[i] - 'a']++;
      }
      boolean flag = true;
      for (int i = 0; i < 26; i++) {
         // System.out.print(arr[i] + " ");

         if (arr[i] != arr1[i]) {
            System.out.println("String is not a anagram");
            flag = false;
            break;
         }

      }
      if (flag == true) {
         System.out.println("String is a anagram");
      }


      for (int i = 0; i < S.length; i++) {
         System.out.print(S[i]+" ");
      }
