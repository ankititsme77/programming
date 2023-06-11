

class Solution {


    public int firstUniqChar(String s) {

        Map<Character, Integer> charCountMap = new LinkedHashMap<Character,Integer>();

        char[] chars = s.toCharArray();

        for(int i=0; i < chars.length ; i++){
            if(charCountMap.containsKey(chars[i])){
                int count = charCountMap.getOrDefault(chars[i],0);
                charCountMap.put(chars[i], count+1);
            }
            else {
                charCountMap.put(chars[i],1);
            }
        }

        for(int i=0; i < chars.length ; i++  ){
            if(charCountMap.get(chars[i]) == 1)
                return i;
        }

        return -1;

    }
}