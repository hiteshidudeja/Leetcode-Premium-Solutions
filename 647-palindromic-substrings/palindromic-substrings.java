class Solution {
    public int countSubstrings(String s) {
        // count
        // i, j is my state
        // palindrome - 
        int n = s.length(); int ans = 0;

        for(int i = 0; i < n; i++){
            int j = i - 1; int k = i;
            while(k < n - 1 && s.charAt(k) == s.charAt(k + 1)) k++;
            ans += (k - j) * (k - j + 1)/2;
            i = k; k++;
            while(j >= 0 && k < n && s.charAt(j--) == s.charAt(k++)) ans++;
        }

        return ans;

    }
}