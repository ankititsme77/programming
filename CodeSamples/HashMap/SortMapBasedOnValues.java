class Solution {


    private void sortMayByValues(){

        Map<Integer, Integer> map = new HashMap<Integer,Integer>();

        map.put(1,11);
        map.put(2,22);
        map.put(3,33);
        map.put(4,44);

        //TreeMap<Integer,Integer> treeMap = new TreeMap<>(map);
        // Sort the map by values
        List<Map.Entry<String, Integer>> entryList = new ArrayList<>(map.entrySet());

        entryList.sort(Map.Entry.comparingByValue());

        // Create a new LinkedHashMap to preserve the sorted order
        Map<String, Integer> sortedMap = new LinkedHashMap<>();

        for (Map.Entry<String, Integer> entry : entryList) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }

        // Print the sorted map
        for (Map.Entry<String, Integer> entry : sortedMap.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }


    }

    public static void main(String[] args){

        Solution s= new Solution();
        s.sortMayByValues();


    }


}