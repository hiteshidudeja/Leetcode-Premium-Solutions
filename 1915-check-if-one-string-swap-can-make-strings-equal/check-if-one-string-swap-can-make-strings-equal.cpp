class Solution {
public:
    bool areAlmostEqual(string s1, string s2) {
        int index1 = 0;  int index2 = 0; int count = 0; 
        for(int i = 0; i < s1.length(); i++){
            if(s1[i] != s2[i]) {
                if(count > 1) return false;
                if(count == 0)
                    index1 = i;
                else 
                    index2 = i;

                count++;
            }
        }

        cout<<index1<<" "<<index2;
        if(s1[index1] == s2[index2] && s1[index2] == s2[index1]) return true;
        return false;
    }
};