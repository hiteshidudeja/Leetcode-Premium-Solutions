class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        // array of asteroids []
        Arrays.sort(asteroids); long sum = mass;    
        for(int asteroid : asteroids){
            if(sum < asteroid) return false;
            sum += asteroid;
        }

        return true;
    }
}