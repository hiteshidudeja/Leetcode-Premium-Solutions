class Solution {
    Map<String, List<Character>> map = new HashMap<>();
    Map<String, Boolean> memo = new HashMap<>();
    
    private boolean solve(String bottom){
        if(bottom.length() == 1) return true;
        if(memo.containsKey(bottom)) return memo.get(bottom);

        boolean result = generateNextRow(bottom, 0, new StringBuilder());
        memo.put(bottom, result);

        return result;
    }


    private boolean generateNextRow(String bottom, int idx, StringBuilder currentNext){
        if(idx == bottom.length() - 1){
            return solve(currentNext.toString());
        }

        String key = bottom.substring(idx, idx + 2);
        if(!map.containsKey(key)) return false;

        for(char val : map.get(key)){
            currentNext.append(val);
            if(generateNextRow(bottom, idx + 1, currentNext)) return true;
            currentNext.deleteCharAt(currentNext.length() - 1);
        }

        return false;
    }
    public boolean pyramidTransition(String bottom, List<String> allowed) {
        // dp
        // dp['AAAA'] = dp['BBB'] || dp['CCC'] || dp['BCB'] || dp['BBC'] || dp['CCB'] || dp['CBC'] || dp['CBB']
        // dp['BBB'] = dp['EE'] = false
        // dp['CCC'] = false
        // dp['BCB'] = false
        // dp['BBC'] = dp['ED'] false
        // dp['CCB'] = false
        // dp['CBC'] = false
        // dp['CBB'] = false

    for(String s : allowed){
        String key = s.substring(0, 2);
        map.computeIfAbsent(key, k -> new ArrayList<>()).add(s.charAt(2));
    }

    return solve(bottom);

    }
}