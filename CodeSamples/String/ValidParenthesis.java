/**
 *
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 *
 * An input string is valid if:
 *
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Every close bracket has a corresponding open bracket of the same type.
 *
 */

class Solution {
    public boolean isValid(String s) {

        char[] brackets = s.toCharArray();

        Map<Character,Character> bracketMap = new HashMap<Character,Character>();

        bracketMap.put(')','(');
        bracketMap.put('}','{');
        bracketMap.put(']','[');

        Stack<Character> stk = new Stack<Character>();

        for(int i=0; i< s.length(); i++){
            if(bracketMap.containsKey(s.charAt(i))){

                if(stk.isEmpty()){

                    return false;
                }

                Character c =  stk.pop();
                if(c != bracketMap.get(s.charAt(i)))
                    return false;
            }
            else {
                stk.push(s.charAt(i));
            }

        }

        return !stk.size() > 0 ? false : true;

    }
}