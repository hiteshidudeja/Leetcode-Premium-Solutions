class Solution {
    public boolean judgeCircle(String moves) {
        // num right == num left
        // num up == num down

        int ups = 0; int downs = 0; int right = 0; int left = 0;

        for(int i = 0; i < moves.length(); i++){
            char c = moves.charAt(i);
            if(c == 'U') ups++;
            else if(c == 'D') downs++;
            else if(c == 'R') right++;
            else if(c == 'L') left++;
        }

        return ups == downs && right == left;
    }
}