class Solution {

    private int rows; private int cols; private Set<String> visited;

    private boolean isPossible(int i, int j, char[][] board, String word, int len){
        if(len == word.length()) return true;
        if(i < 0 || i >= rows || j < 0 || j >= cols || visited.contains(i + "," + j) || board[i][j] != word.charAt(len)) return false;

        visited.add(i + "," + j);
        boolean result = isPossible(i + 1, j, board, word, len + 1) || isPossible(i - 1, j, board, word, len + 1) || isPossible(i, j + 1, board, word, len + 1) || isPossible(i, j - 1, board, word, len + 1);

        visited.remove(i + "," + j);
        return result;
    }

    public boolean exist(char[][] board, String word) {
        rows = board.length;
        cols = board[0].length;
        visited = new HashSet<>();

        Map<Character, Integer> count = new HashMap<>();

        for(char c : word.toCharArray()){
            count.put(c, count.getOrDefault(c, 0) + 1);
        }
        
        if(count.getOrDefault(word.charAt(0), 0) > count.getOrDefault(word.charAt(word.length() - 1), 0)){
            word = new StringBuilder(word).reverse().toString();
        }


        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(isPossible(i, j, board, word, 0)) return true;
            }
        }
        return false;

    }
}