class Solution {
public:
    int numberOfAlternatingGroups(vector<int>& colors, int k) {
        // find the numbers formed with 1 0 1 , 0 1 0
        // now sliding window over colors 

        int n = colors.size();
        string a = ""; string b = ""; char x = '0';
        for(int i = 0; i < k; i++){            
           a += x;
           x = ((x - '0') ^ 1) + '0';
           b += x;
        }


        string formed = "";  int count = 0;
        for(int i = 0; i < k; i++){
            formed += colors[i] + '0';
        }
        int j = k - 1;
        for(int i = 0; i < n; i++){
            if(formed == a || formed == b){
                count++;
            }
            formed.erase(0, 1);
            j = (j + 1) % n; formed += colors[j] + '0';
        }
        return count;
    }
};