// Recussive code 



//User function Template for Java

class Solution{
    static long disarrange(int n){
        // code here
        int mod = 10^9+7;
        if(n == 1) return 0;
        if(n == 2) return 1;
        
        long ans = ((n-1)%mod) * ((disarrange(n-2)%mod) + (disarrange(n-1)%mod);
        
        return ans;
    }
}

// Recusive code with memoization



//User function Template for Java

class Solution{
    static long disarrange(int n){
        // code here
        long dp[] = new long[n+1];
        Arrays.fill(dp,-1);
        return solve(n,dp);
       
    }
    static long solve(int n, long dp[]){
         long mod = 1000000007;
        if(n == 1) return 0;
        if(n == 2) return 1;
        
        if(dp[n] != -1){
            return dp[n];
        }
        
        dp[n] = (  ((n-1)%mod) * ((solve(n-1,dp)%mod) + (solve(n-2,dp)%mod)) ) %mod;

        return dp[n] ;
    }
}

// Tabulation



//User function Template for Java

class Solution{
    static long disarrange(int n){
        return solve(n);
       
    }
    static long solve(int n){
         long mod = 1000000007;
        long dp [] = new long[n+1];
        Arrays.fill(dp,0);
        
        dp[1] = 0;
        dp[2] = 1;
        
        for(int i=3; i<=n; i++){
            long first = dp[i-1] % mod;
            long second = dp[i-2] % mod;
            long sum = (first+second) % mod;
            long ans = ((i-1) * sum)%mod;
            dp[i] = ans;
        }
        return dp[n];
        
    }
}

//Space optimized tabulation


class Solution{
    static long disarrange(int n){
        return solve(n);
       
    }
    static long solve(int n){
         long mod = 1000000007;
        long prev2 = 0;
        long prev1 = 1;
        
        for(int i=3; i<=n; i++){
            long first = prev2 % mod;
            long second = prev1 % mod;
            long sum = (first+second) % mod;
            long ans = ((i-1) * sum)%mod;
            
            prev2 = prev1;
            prev1 = ans;
        }
        return prev1;
        
    }
}