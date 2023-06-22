/*

Group Anagrams

*/

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        if(strs == null || strs.length == 0){
            return new ArrayList<>();

        }

        List<List<String>> res = new ArrayList<List<String>>();
        Map<String, List<String>> anagramMap = new HashMap<String, List<String>>();

        for(String str : strs){
            char[] chArr = str.toCharArray();
            Arrays.sort(chArr);
            String sb = new String(chArr);
            //System.out.println("Sorted Key--> "+sb+ " Actual String -->"+str);
            if(anagramMap.containsKey(sb)){
                List<String> foundAnagrams = anagramMap.get(sb);
                System.out.println("Key--> "+sb+" Value --> "+ foundAnagrams);
                foundAnagrams.add(str);
                anagramMap.put(sb, foundAnagrams);
            }

            else{
                List<String> value= new ArrayList<String>();
                value.add(str);
                anagramMap.put(sb, value);
                //System.out.println("Key--> "+sb+" Value --> "+"First Entry");
            }
        }

        for(Map.Entry<String,List<String>> entry : anagramMap.entrySet()){
            List<String> foundAnagrams = entry.getValue();
            res.add(foundAnagrams);
        }
        return res;
    }
}


