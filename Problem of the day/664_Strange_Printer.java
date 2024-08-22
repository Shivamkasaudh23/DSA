class Solution {  
    int n = 0;  
    Integer[][] memo; // Memoization table  

    public int strangePrinter(String s) {  
        n = s.length();  
        memo = new Integer[n][n]; // Initialize memoization table  
        return solve(0, n - 1, s);  
    }  

    int solve(int l, int r, String s) {  
        if (l > r) return 0; // Edge case: no characters to print  
        if (l == r) return 1; // Only one character to print  

        // Check memoization table  
        if (memo[l][r] != null) return memo[l][r];  

        int i = l + 1;  
        // Move i to the right while characters are the same  
        while (i <= r && s.charAt(i) == s.charAt(l)) i++;  

        int basic = 1 + solve(i, r, s); // Basic case for different characters  

        int lalach = Integer.MAX_VALUE;  

        // Try to find the minimum by joining segments  
        for (int j = i; j <= r; j++) {  
            if (s.charAt(j) == s.charAt(l)) {  
                int ans = solve(i, j - 1, s) + solve(j, r, s);  
                lalach = Math.min(lalach, ans);  
            }  
        }  

        // Store the result in the memoization table  
        memo[l][r] = Math.min(basic, lalach);  
        return memo[l][r];  
    }  
}
