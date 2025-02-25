class Solution {
    boolean dp[][] = new boolean[1001][1001];
    public String longestPalindrome(String s) {
        int n = s.length();
        int maxLen = 0;
        int sp = 0;

        for(int i=0; i<1001; i++){
            for(int j=0; j<1001; j++){
                dp[i][j] = false;
            }
        }

        for(int i=0; i<n; i++){
            for(int j=i; j<n; j++){
                if(solve(s,i,j) ==  true){
                    if(j-i+1 > maxLen){
                        maxLen = j-i+1;
                        sp = i;
                    }
                }
            }
        }
        return s.substring(sp,sp+maxLen);
    }
    boolean solve(String s, int i, int j){
        if(i>=j) return true;

        if(dp[i][j] != false){
            return dp[i][j];
        }

        if(s.charAt(i) == s.charAt(j)){
            return dp[i][j] = solve(s,i+1,j-1);
        }

        return false;
    }
}