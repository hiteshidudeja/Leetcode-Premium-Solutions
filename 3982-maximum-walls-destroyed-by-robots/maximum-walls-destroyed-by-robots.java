class Solution {

    private int lowerBound(int[] arr, int target){
        // idx of first element >= target
        int l = 0; int r = arr.length;

        while(l < r){
            int m = l + (r - l)/2;
            if(arr[m] < target) l = m + 1;
            else r = m;
        }

        return l;
    }

    private int upperBound(int[] arr, int target){
        // idx of the first element > target
        int l = 0; int r = arr.length;

        while(l < r){
            int m = l + (r - l)/2;
            if(arr[m] <= target) l = m + 1;
            else r = m;
        }

        return l;
    }
    public int maxWalls(int[] robots, int[] distance, int[] walls) {
        int n = robots.length; 
        // number of walls robo i can shoot to its left
        int[] left = new int[n];

        // number of walls robo i can shoot to its right
        int[] right = new int[n];

        // number of overlapping walls between robo[i - 1], robo[i] 
        int[] num = new int[n];
        Map<Integer, Integer> roboToDist = new HashMap<>();

        for(int i = 0; i < n; i++){
            roboToDist.put(robots[i], distance[i]);
        }

        Arrays.sort(robots); Arrays.sort(walls);


        // lfet 
        for(int i = 0; i < n; i++){
            // num walls <= robots[i];
            int pos1 = upperBound(walls, robots[i]);
            int leftPos = 0;
            if(i >= 1){
                int leftBound = Math.max(robots[i] - roboToDist.get(robots[i]), robots[i - 1] + 1);
                leftPos = lowerBound(walls, leftBound);
            } else {
                leftPos = lowerBound(walls, robots[i] - roboToDist.get(robots[i]));
            }

            left[i] = pos1 - leftPos;

            int pos2 = lowerBound(walls, robots[i]);
            int rightPos = 0;
            if(i < n - 1){
                int rightBound = Math.min(robots[i] + roboToDist.get(robots[i]), robots[i + 1] - 1);
                rightPos = upperBound(walls, rightBound);
            } else {
                rightPos = upperBound(walls, robots[i] + roboToDist.get(robots[i]));
            }

            right[i] = rightPos - pos2;

            if(i == 0) continue;

            int pos3 = lowerBound(walls, robots[i - 1]);
            num[i] = pos1 - pos3;
        }


        int subLeft = left[0]; int subRight = right[0];

        for(int i = 1; i < n; i++){
            // current robo shoots in left direction
            int currLeft = Math.max(subLeft + left[i], subRight - right[i - 1] + Math.min(left[i] + right[i - 1], num[i]));
            int currRight = Math.max(subLeft + right[i], subRight + right[i]);
            subLeft = currLeft; subRight = currRight;
        }

        return Math.max(subLeft, subRight);


    }
}