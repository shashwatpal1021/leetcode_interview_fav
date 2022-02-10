/*

Implement the myAtoi(string s) function, which converts a string to a 32-bit signed integer (similar to C/C++'s atoi function).

The algorithm for myAtoi(string s) is as follows:

Read in and ignore any leading whitespace.
Check if the next character (if not already at the end of the string) is '-' or '+'. Read this character in if it is either. This determines if the final result is negative or positive respectively. Assume the result is positive if neither is present.
Read in next the characters until the next non-digit character or the end of the input is reached. The rest of the string is ignored.
Convert these digits into an integer (i.e. "123" -> 123, "0032" -> 32). If no digits were read, then the integer is 0. Change the sign as necessary (from step 2).
If the integer is out of the 32-bit signed integer range [-231, 231 - 1], then clamp the integer so that it remains in the range. Specifically, integers less than -231 should be clamped to -231, and integers greater than 231 - 1 should be clamped to 231 - 1.
Return the integer as the final result.
Note:

Only the space character ' ' is considered a whitespace character.
Do not ignore any characters other than the leading whitespace or the rest of the string after the digits.
 

Example 1:

Input: s = "42"
Output: 42
Explanation: The underlined characters are what is read in, the caret is the current reader position.
Step 1: "42" (no characters read because there is no leading whitespace)
         ^
Step 2: "42" (no characters read because there is neither a '-' nor '+')
         ^
Step 3: "42" ("42" is read in)
           ^
The parsed integer is 42.
Since 42 is in the range [-231, 231 - 1], the final result is 42.
Example 2:

Input: s = "   -42"
Output: -42
Explanation:
Step 1: "   -42" (leading whitespace is read and ignored)
            ^
Step 2: "   -42" ('-' is read, so the result should be negative)
             ^
Step 3: "   -42" ("42" is read in)
               ^
The parsed integer is -42.
Since -42 is in the range [-231, 231 - 1], the final result is -42.
Example 3:

Input: s = "4193 with words"
Output: 4193
Explanation:
Step 1: "4193 with words" (no characters read because there is no leading whitespace)
         ^
Step 2: "4193 with words" (no characters read because there is neither a '-' nor '+')
         ^
Step 3: "4193 with words" ("4193" is read in; reading stops because the next character is a non-digit)
             ^
The parsed integer is 4193.
Since 4193 is in the range [-231, 231 - 1], the final result is 4193.
 

Constraints:

0 <= s.length <= 200
s consists of English letters (lower-case and upper-case), digits (0-9), ' ', '+', '-', and '.'.

*/


class Solution {
   public int myAtoi(String s) {
      s = s.strip();
      if (s.isEmpty())
         return 0;

      final int sign = s.charAt(0) == '-' ? -1 : 1;
      if (s.charAt(0) == '+' || s.charAt(0) == '-')
         s = s.substring(1);

      long num = 0;

      for (final char c : s.toCharArray()) {
         if (!Character.isDigit(c))
            break;
         num = num * 10 + (c - '0');
         if (sign * num <= Integer.MIN_VALUE)
            return Integer.MIN_VALUE;
         if (sign * num >= Integer.MAX_VALUE)
            return Integer.MAX_VALUE;
      }

      return sign * (int) num;
   }
}





class Solution {
   public int myAtoi(String s) {
      char[] ss = s.toCharArray();
      long num = 0;
      boolean isNegative = false;
      char symbol = ' ';
      for (char c : ss) {
         if (c == ' ' && symbol != ' ')
            break;
         if (c == ' ')
            continue;

         if (c == '-' || c == '+') {
            if (symbol != ' ')
               break;
            if (c == '-') {
               isNegative = true;
            }
            symbol = c;
            continue;
         }

         if (Character.isAlphabetic(c) || c == '.') {
            break;
         }

         if (c >= '0' && c <= '9') {
            num = num * 10 + (c - '0');
            if (num >= (long) Integer.MAX_VALUE + 1) {
               return isNegative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            symbol = '+';
         }
      }

      num = isNegative ? -num : num;

      return (int) num;
   }
}






class Solution {
   public int myAtoi(String input) {
      int sign = 1;
      int result = 0;
      int index = 0;
      int n = input.length();

      // Discard all spaces from the beginning of the input string.
      while (index < n && input.charAt(index) == ' ') {
         index++;
      }

      // sign = +1, if it's positive number, otherwise sign = -1.
      if (index < n && input.charAt(index) == '+') {
         sign = 1;
         index++;
      } else if (index < n && input.charAt(index) == '-') {
         sign = -1;
         index++;
      }

      // Traverse next digits of input and stop if it is not a digit
      while (index < n && Character.isDigit(input.charAt(index))) {
         int digit = input.charAt(index) - '0';

         // Check overflow and underflow conditions.
         if ((result > Integer.MAX_VALUE / 10) ||
               (result == Integer.MAX_VALUE / 10 && digit > Integer.MAX_VALUE % 10)) {
            // If integer overflowed return 2^31-1, otherwise if underflowed return -2^31.
            return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
         }

         // Append current digit to the result.
         result = 10 * result + digit;
         index++;
      }

      // We have formed a valid number without any overflow/underflow.
      // Return it after multiplying it with its sign.
      return sign * result;
   }
}



class Solution {
   public int myAtoi(String str) {
      int index = 0;
      int total = 0;
      int sign = 1;

      // Check if empty string
      if (str.length() == 0)
         return 0;

      // remove white spaces from the string
      while (index < str.length() && str.charAt(index) == ' ')
         index++;

      if (index == str.length())
         return 0;

      // get the sign
      if (str.charAt(index) == '+' || str.charAt(index) == '-') {
         sign = str.charAt(index) == '+' ? 1 : -1;
         index++;
      }

      // convert to the actual number and make sure it's not overflow
      while (index < str.length()) {
         int digit = str.charAt(index) - '0';
         if (digit < 0 || digit > 9)
            break;

         // check for overflow
         if (Integer.MAX_VALUE / 10 < total || Integer.MAX_VALUE / 10 == total && Integer.MAX_VALUE % 10 < digit) {
            // System.out.println(Integer.MAX_VALUE / 10);
            // System.out.println(Integer.MAX_VALUE%10);
            return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
         }

         total = total * 10 + digit;
         index++; // don't forget to increment the counter
      }

      return total * sign;
   }
}



class Solution {
   public static int myAtoi(String s) {

      int ans = 0;
      s = s.toLowerCase();
      if (s.equals(""))
         return ans;
      char[] array = s.toCharArray();

      // loop till number found
      boolean isNegative = false;
      boolean found = false;
      int operatorCount = 0;
      int i;
      for (i = 0; i < s.length(); i++) {
         char current = array[i];
         if (current == '-' || current == '+') {
            isNegative = current == '-';
            operatorCount++;
            if (operatorCount > 1)
               return 0;
         } else if ((current >= '0' && current <= '9')) {
            found = true;
            break;
         } else if (current == ' ') {
            if (operatorCount > 0)
               return 0;
            continue;
         } else
            return 0;

      }
      if (!found)
         return ans;
      // System.out.println("i is " + i);

      // number is found. iterate till non digit is found
      int end = i;
      for (int j = i; j < s.length(); j++) {
         char current = array[j];
         if (current >= '0' && current <= '9') {
            end++;
         } else
            break;
      }
      String newString = s.substring(i, end);
      if (newString.equals(""))
         return 0;
      else {
         try {
            // System.out.println("ans is:" + ans);
            ans = Integer.parseInt(newString);
         } catch (NumberFormatException e) {
            if (isNegative) {
               return Integer.MIN_VALUE;
            } else
               return Integer.MAX_VALUE;
         }
      }
      if (isNegative)
         ans = ans * -1;
      return ans;
   }

}


class Solution {
   public int myAtoi(String s) {
      // remove whitespace
      /*
       * s = s.trim();
       * int index = 0;
       * boolean negative = false;
       * while(true){
       * char c = s.charAt(index);
       * if(Character.isDigit(c)){
       * System.out.println(c);
       * break;
       * }
       * if(c == '-' && Character.isDigit(s.charAt(index + 1))){
       * negative = true;
       * ++index;
       * break;
       * }
       * if(c == '+' && Character.isDigit(s.charAt(index + 1))){
       * ++index;
       * break;
       * }
       * 
       * ++index;
       * }
       */

      s = s.trim();
      if (s.length() == 0)
         return 0;
      int index = 0;
      boolean negative = false;
      if (s.charAt(0) == '-') {
         negative = true;
         ++index;
      }
      if (s.charAt(0) == '+') {
         ++index;
      }

      int answer = 0;
      int max = Integer.MAX_VALUE;
      int min = Integer.MIN_VALUE;
      while (index < s.length() && Character.isDigit(s.charAt(index))) {
         if (negative) {
            if (answer < (min / 10)) {
               System.out.println("clim");
               return min;
            }
         } else {
            if (answer > (max / 10))
               return max;
         }
         long temp = answer;
         temp *= 10;
         temp += Character.getNumericValue(s.charAt(index));
         if (-temp < min && negative)
            return min;
         if (temp > max && !negative)
            return max;
         answer = (int) temp;
         // answer *= 10;
         // answer += Character.getNumericValue(s.charAt(index));
         ++index;
      }

      if (negative)
         answer *= -1;

      return answer;
   }
}