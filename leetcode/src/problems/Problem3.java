package leetcode.src.problems;

import java.util.HashSet;
import java.util.Set;

public class Problem3 {

    public static void main(String[] args) {
//        System.out.println(lengthOfLongestSubstring("abcabcbb"));
//        System.out.println(lengthOfLongestSubstring("bbbbb"));
//        System.out.println(lengthOfLongestSubstring("pwwkew"));
        System.out.println(lengthOfLongestSubstring(" "));
    }

    public static int lengthOfLongestSubstring(String s) {
        int longestSubstringLength = 0;
        StringBuilder subString = new StringBuilder();

        Set<Character> charactersInString = new HashSet<>();
        for (char currentCharacter : s.toCharArray()) {
            if (charactersInString.contains(currentCharacter)) {
                longestSubstringLength = Integer.max(longestSubstringLength, subString.length());

                String currentSubString = subString.toString();
                int currentCharacterIndex = currentSubString.indexOf(currentCharacter);

                String subStringBeforeCurrentCharacter = currentSubString.substring(0, currentCharacterIndex + 1);
                for (char toDeleteChar : subStringBeforeCurrentCharacter.toCharArray()) {
                    charactersInString.remove(toDeleteChar);
                }

                String subStringAfterCurrentCharacter = currentSubString.substring(currentCharacterIndex + 1);
                subString = new StringBuilder(subStringAfterCurrentCharacter);
            }

            subString.append(currentCharacter);
            charactersInString.add(currentCharacter);
        }

        longestSubstringLength = Integer.max(longestSubstringLength, subString.length());
        return longestSubstringLength;
    }
}
