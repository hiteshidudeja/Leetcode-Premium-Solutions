class Solution {
private:
    long long atLeastK(string word, int k){
        int i = 0; int j = 0; int n = word.length();
        long long substrings = 0;
        int consonantCount = 0;
        unordered_map<char, int>map;
        while(j < n){
            if(isVowel(word[j])){
                map[word[j]]++;
            } else consonantCount++;

            while(map.size() == 5 && consonantCount >= k){
                substrings += n - j;
                if(isVowel(word[i])){
                    map[word[i]]--; if(map[word[i]] == 0) map.erase(word[i]);
                } else consonantCount--;

                i++;
            }

            j++;
        }

        return substrings;
        
    }
    bool isVowel(char c){
        return c == 'a' || c == 'e' || c == 'i' ||  c == 'o' || c == 'u';
    }
public:
    long long countOfSubstrings(string word, int k) {
        int n = word.length();
        long long count1 = atLeastK(word, k);
        long long count2 = atLeastK(word, k + 1);

        return count1 - count2;


    }
};