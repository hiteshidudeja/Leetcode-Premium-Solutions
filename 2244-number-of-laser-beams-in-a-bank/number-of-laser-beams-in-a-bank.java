class Solution {
    private int numOnes(String s){
        return (int) s.chars().filter(ch -> ch == '1').count();
    }
    public int numberOfBeams(String[] bank) {
        int n = bank.length;
        int result = 0;
        int previous = 0; 
        for(String s : bank){
            int count = numOnes(s);
            if(count > 0) {
                result += count * previous; 
                previous = count; 
            }
        }

        return result;
        
    }
}