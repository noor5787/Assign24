package in.ineuron.in;
import java.util.HashMap;
import java.util.Map;

public class LongestSubstring {
    public static int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        int start = 0;
        Map<Character, Integer> charMap = new HashMap<>();

        for (int end = 0; end < s.length(); end++) {
            char c = s.charAt(end);

            if (charMap.containsKey(c)) {
                // Update the start index to the next character after the repeated character
                start = Math.max(start, charMap.get(c) + 1);
            }

            charMap.put(c, end); // Store the current character's index

            // Update the maximum length if a longer substring is found
            maxLength = Math.max(maxLength, end - start + 1);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        String s1 = "abcabcbb";
        System.out.println("Length of the longest substring without repeating characters: " + lengthOfLongestSubstring(s1));

        String s2 = "bbbbb";
        System.out.println("Length of the longest substring without repeating characters: " + lengthOfLongestSubstring(s2));

        String s3 = "pwwkew";
        System.out.println("Length of the longest substring without repeating characters: " + lengthOfLongestSubstring(s3));
    }
}
