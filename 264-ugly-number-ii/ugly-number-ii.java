class Solution {
    public int nthUglyNumber(int n) {
        // prime factors - prime numbers divisible by n 

        // 2 3 5 
        // 4 3 5 -> 3, 4, 5
        // 

        PriorityQueue<Long> queue = new PriorityQueue<>();

        Set<Long> seen = new HashSet<>();

        int[] primeFactors = {2, 3, 5};
        queue.offer(1L); seen.add(1L);

        long currentUgly = 1L;

        for(int i = 0; i < n; i++){
            currentUgly = queue.poll();

            for(int prime: primeFactors){
                long next = currentUgly * prime;

                if(seen.add(next)){
                    queue.offer(next);
                }
            }
        }

        return (int)currentUgly;
    }
}