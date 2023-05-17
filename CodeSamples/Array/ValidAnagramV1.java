/**
 *
 * Given two strings s and t, return true if t is an anagram of s, and false otherwise.
 *
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "anagram", t = "nagaram"
 * Output: true
 * Example 2:
 *
 * Input: s = "rat", t = "car"
 * Output: false
 *
 *
 * Constraints:
 *
 * 1 <= s.length, t.length <= 5 * 104
 * s and t consist of lowercase English letters.
 *
 *
 * Follow up: What if the inputs contain Unicode characters? How would you adapt your solution to such a case?
 */

class Solution {
    public boolean isAnagram(String s, String t) {

        if(s == null ||  t == null || s.length() != t.length())
            return false;

        Map<Character,Integer> charMap = new HashMap<Character,Integer>();

        for(int i=0; i< s.length(); i++){
            if(charMap.containsKey(s.charAt(i))){
                int currentCount = charMap.get(s.charAt(i));
                charMap.put(s.charAt(i),currentCount+1);
            }
            else{
                charMap.put(s.charAt(i),1);
            }
        }


        for(int i=0; i< t.length(); i++){
            if(charMap.containsKey(t.charAt(i)) && charMap.get(t.charAt(i)) != 0 ){
                charMap.put(t.charAt(i),charMap.get(t.charAt(i))-1);
            }

            else{
                return false;
            }


        }

        return true;


    }
}