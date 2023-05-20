class Solution {

    private static Map<Character,String> digitCharMap;

    static {

        digitCharMap = new HashMap<>();
        digitCharMap.put('2',"abc");
        digitCharMap.put('3',"def");
        digitCharMap.put('4',"ghi");
        digitCharMap.put('5',"jkl");
        digitCharMap.put('6',"mno");
        digitCharMap.put('7',"pqrs");
        digitCharMap.put('8',"tuv");
        digitCharMap.put('9',"wxyz");
    }

    public List<String> letterCombinations(String digits) {

        if(digits == null || digits.length() == 0)
            return new ArrayList<String>();

        List<String> res = new ArrayList<String>();

        backTrack(res,new StringBuilder(),digits, 0);

        return res;

    }


    private void backTrack(List<String> res, StringBuilder currentCombination , String digits, int index){
        //base case
        if(index == digits.length()){
            res.add(currentCombination.toString());
            return ;
        }



        String letters = digitCharMap.get(digits.charAt(index));

        for(int i=0; i< letters.length(); i++){
            Character letter = letters.charAt(i);
            currentCombination.append(letter);
            backTrack(res,currentCombination,digits,index+1);
            currentCombination.deleteCharAt(currentCombination.length()-1);


        }



    }
}