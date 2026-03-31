class Solution {
    public int[] findOrder(int n, int[][] prerequisites) {
        // a[1] -> a[0] // directed graph

        List<List<Integer>> graph = new ArrayList<>();
        int[] indegree = new int[n];
        for(int i = 0; i < n; i++) graph.add(new ArrayList<>());
        for(int[] prerequisite : prerequisites){
            int from = prerequisite[1]; int to = prerequisite[0];
            graph.get(from).add(to);
            indegree[to]++;
        }

        Queue<Integer> queue = new LinkedList<>();

        for(int i = 0; i < n; i++) {
            // no prerequisite needed;
            if(indegree[i] == 0) queue.offer(i);
        }

        int[] courses = new int[n];

        int i = 0;

        while(!queue.isEmpty()){
            int course = queue.poll(); courses[i] = course; i++;

            for(int dependent : graph.get(course)){
                indegree[dependent]--;
                if(indegree[dependent] == 0) queue.offer(dependent);
            }
        }

        return i == n ? courses : new int[0];


    }
}