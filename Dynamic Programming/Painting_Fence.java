//Recursive code

//User function Template for Java


class Solution
{
    long mod = 1000000007;
    long countWays(int n,int k)
    {
        //code here.
        return solve((long)n,(long)k);
    }
    
    long add(long a,long b){
        return (a%mod + b%mod) % mod;
    }
    long mul(long  a, long b){
        return ((a%mod) * (b%mod));
    } 
    long solve(long n,long k){
        if(n== 1) return k;
        if(n== 2) return add(k, mul(k,k-1));
        
        long ans = add(mul(solve(n-2, k),k-1),mul(solve(n-1,k),k-1));
        
        return ans;
    }
}

//Recusion + Memoization

//User function Template for Java


class Solution
{
    long mod = 1000000007;
    long countWays(int n,int k)
    {
        //code here.
        long dp[] = new long[n+1];
        Arrays.fill(dp,(long)-1);
        return solve(n,(long)k,dp);
    }
    
    long solve(int n,long k,long [] dp){
        if(n== 1) return k;
        if(n== 2) return add(k, mul(k,k-1));
        
        if(dp[n] != (long)-1) {
            return dp[n];
        }
        
        dp[n] = add(mul(solve(n-2, k,dp),k-1),mul(solve(n-1,k,dp),k-1));
        
        return dp[n];
    }
    
    long add(long a,long b){
        return (a%mod + b%mod) % mod;
    }
    long mul(long  a, long b){
        return ((a%mod) * (b%mod));
    } 
}



//Tabulation

//User function Template for Java


class Solution
{
    long mod = 1000000007;
    long countWays(int n,int k)
    {
        //code here.
       return solve(n,(long)k);
    }
    
    long solve(int n,long k){
        if(n == 1) return k;
       long dp [] = new long[n+1];
       Arrays.fill(dp,0);
       
       dp[1] = k;
       dp[2] = add(k,mul(k,k-1));
       
       for(int i=3; i<=n; i++){
           dp[i] = add(mul(dp[i-2],k-1),mul(dp[i-1],k-1));
       }
       
       return dp[n];
    }
    
    long add(long a,long b){
        return (a%mod + b%mod) % mod;
    }
    long mul(long  a, long b){
        return ((a%mod) * (b%mod));
    } 
}


//Space Optimized Tabulation

//User function Template for Java


class Solution
{
    long mod = 1000000007;
    long countWays(int n,int k)
    {
        //code here.
       return solve(n,(long)k);
    }
    
    long solve(int n,long k){
        if(n == 1) return k;
      
       
      long prev2 = k;
      long prev1= add(k,mul(k,k-1));
       
       for(int i=3; i<=n; i++){
           long ans = add(mul(prev2,k-1),mul(prev1,k-1));
           prev2 = prev1;
           prev1 = ans;
       }
       
       return prev1;
    }
    
    long add(long a,long b){
        return (a%mod + b%mod) % mod;
    }
    long mul(long  a, long b){
        return ((a%mod) * (b%mod));
    } 
}

