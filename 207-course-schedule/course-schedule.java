class Solution {
    public boolean canFinish(int n, int[][] prerequisites) {
        List<Integer>[] adj = new List[n];

        int[] indegree = new int[n];
        int courses = 0;

        Queue<Integer> queue = new LinkedList<>();

        for(int[] pair : prerequisites){
            int course = pair[0];
            int prerequisite = pair[1];
            if(adj[prerequisite] == null){
                adj[prerequisite] = new ArrayList<>();
            }
            adj[prerequisite].add(course);
            indegree[course]++;
        }


        for(int i = 0; i < n; i++){
            if(indegree[i] == 0) queue.offer(i);
        }


        while(!queue.isEmpty()){
            int course = queue.poll(); courses++;
            if(adj[course] != null){
                for(int next : adj[course]){
                    indegree[next]--;
                    if(indegree[next] == 0) queue.offer(next);
                }
            }
        }

        return courses == n;

    }
}