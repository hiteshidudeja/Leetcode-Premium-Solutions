class Solution {
    public List<String> twoEditWords(String[] queries, String[] dictionary) {
        int n = queries.length;
        int m = dictionary.length;

        List<String> result = new ArrayList<>();

        for(int i = 0; i < n; i++){
            String s = queries[i]; 
            for(int k = 0; k < m; k++){ 
                int count = 0;
                String d = dictionary[k];
                if(s.length() != d.length()) continue;

                for(int j = 0; j < s.length(); j++){
                    if(s.charAt(j) != d.charAt(j)) count++;
                    if(count > 2) break;
                }

                if(count <= 2) {
                    result.add(s); break;
                }
            }
        }

        return result;
    }
}