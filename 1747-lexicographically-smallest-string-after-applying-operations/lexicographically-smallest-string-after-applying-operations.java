class Solution {
    public String findLexSmallestString(String s, int a, int b) {
        // if b is odd -> try to minimise all the letters by adding a
        // if b is even -> try to minimise only letters at odd index

        // then finally compare the characters at b intervals

        // minimise (5 + ka) % 10 
        Queue<String>q = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        String smallest = s; q.offer(s); visited.add(s);

        while(!q.isEmpty()){
            String current = q.poll();

            if(current.compareTo(smallest) < 0) smallest = current;

            StringBuilder sb = new StringBuilder(current);

            for(int i = 1; i < sb.length(); i+=2){
                sb.setCharAt(i, (char) ((sb.charAt(i) - '0' + a) % 10 + '0'));
            }

            String added = sb.toString();
            if(visited.add(added)) q.offer(added);

            String rotated = current.substring(current.length() - b) + current.substring(0, current.length() - b);
            if(visited.add(rotated)) q.offer(rotated);
        }

        return smallest;
    }
}