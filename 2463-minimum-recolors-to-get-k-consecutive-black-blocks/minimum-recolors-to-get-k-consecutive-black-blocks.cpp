class Solution {
public:
    int minimumRecolors(string blocks, int k) {
        int i = 0; int j = k;
        int converts = count(blocks.begin(), blocks.begin() + k, 'W');
        int result = converts;
        int n = blocks.size();
        while(j < n){
            if(blocks[i] == 'W') converts--;
            if(blocks[j] == 'W') converts++;
            i++; j++; result = min(result, converts);
        }

        return result;
    }
};