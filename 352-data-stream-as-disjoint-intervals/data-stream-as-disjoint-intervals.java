class SummaryRanges {
    Set<Integer> set;
    public SummaryRanges() {
        set = new TreeSet<>();
    }
    
    public void addNum(int value) {
        set.add(value);
    }
    
    public int[][] getIntervals() {

        if(set.isEmpty()) return new int[0][2];
        int left = -1; int right = -1;

        List<int[]> res = new ArrayList<>();

        for(int value : set){
            if(left == -1 && right == -1){
                left = right = value;
            } else if(value == right + 1){
                right = value;
            } else {
                res.add(new int[]{left, right});
                left =value; right = value;
            }
        }

        res.add(new int[]{left, right});

        return res.toArray(new int[0][]);
    }
}

/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(value);
 * int[][] param_2 = obj.getIntervals();
 */