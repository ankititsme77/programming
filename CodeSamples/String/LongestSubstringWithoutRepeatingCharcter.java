/**
 *
 *
 * Given a string s, find the length of the longest
 * substring
 *  without repeating characters.
 *
 */


class Solution {
    public int lengthOfLongestSubstring(String s) {

        int i=0;
        int j=0;
        Set<Character> set = new HashSet<Character>();
        int n = s.length();
        int max = 0;

        while(i <n && j < n){
            if(!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                max = Math.max(max,(j-i));
            }
            else{
                set.remove(s.charAt(i++));

            }
        }
        return max;
    }
}