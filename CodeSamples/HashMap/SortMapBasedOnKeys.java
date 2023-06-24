class Solution {


    private void sortMayByKeys(){

        Map<Integer, Integer> map = new HashMap<Integer,Integer>();

        map.put(1,11);
        map.put(2,22);
        map.put(3,33);
        map.put(4,44);

        TreeMap<Integer,Integer> treeMap = new TreeMap<>(map);

        for(Map.Entry<Integer,Integer> entry : treeMap.entrySet()){

            System.out.println("Key-->"+entry.getKey());
            System.out.println("Value-->"+entry.getValue());


        }


    }

    public static void main(String[] args){

        Solution s= new Solution();
        s.sortMayByKeys();


    }


}