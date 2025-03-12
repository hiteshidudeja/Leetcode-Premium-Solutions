class Solution {
private:
    bool isVowel(char a){
        return a == 'a' || a == 'e' || a == 'i' ||  a == 'o' || a == 'u';
    }
public:
    long long countOfSubstrings(string word, int k) {
        int n = word.length();
        vector<int>nextConsonant(n, -1);
        int prev = n; 
        unordered_map<char, int>map;
        for(int i = n - 1; i >= 0 ; i--){
            nextConsonant[i] = prev;
            if(!isVowel(word[i])) prev = i;
        }

        vector<int>frequency(26, 0); long long count = 0; int i = 0; int j = 0;     
        int consonantCount = 0;
        while(j < n){
            if(isVowel(word[j])){
                map[word[j]]++; 
            } else {
                consonantCount++;
            }

            while(consonantCount > k){
                if(isVowel(word[i])){
                    map[word[i]]--; if(map[word[i]] == 0) map.erase(word[i]);
                } else {
                    consonantCount--;
                }
                i++;
            }

            while(i < n && map.size() == 5 && consonantCount == k){
                count += nextConsonant[j] - j;
                if(isVowel(word[i])){
                    map[word[i]]--; if(map[word[i]] == 0) map.erase(word[i]);
                } else {
                    consonantCount--;
                }
                i++;
            }

            j++;


        }
        

        return count;


    }
};