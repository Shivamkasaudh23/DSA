//Recursive code to cut a rod into segments of length x, y and z



//User function Template for Java


class Solution
{
    //Function to find the maximum number of cuts.
    public int maximizeCuts(int n, int x, int y, int z)
    {
       //Your code here
       int ans = solve(n,x,y,z);
       if(ans < 0) return 0;
       return ans;
    }
    int solve(int n,int x , int y, int z){
        if(n==0) return 0;
        
        if(n< 0) return Integer.MIN_VALUE;
        
        int a = solve(n-x, x, y, z) + 1;
        int b = solve(n-y, x, y, z) + 1 ;
        int c= solve(n-z, x, y, z) + 1;
        
        int ans = Math.max(a, Math.max(b,c));
        return ans;
    }
}


//Reccursive code with memoization



//User function Template for Java


class Solution
{
    //Function to find the maximum number of cuts.
    public int maximizeCuts(int n, int x, int y, int z)
    {
       //Your code here
       int dp[] = new int[n+1];
       Arrays.fill(dp,-1);
       int ans = solve(n,x,y,z,dp);
       if(ans < 0) return 0;
       return ans;
    }
    int solve(int n,int x , int y, int z,int dp[]){
        if(n==0) return 0;
        
        if(n< 0) return Integer.MIN_VALUE;
        
        if(dp[n] != -1){
            return dp[n];
        }
        
        int a = solve(n-x, x, y, z,dp) + 1;
        int b = solve(n-y, x, y, z,dp) + 1 ;
        int c= solve(n-z, x, y, z,dp) + 1;
        
        dp[n] = Math.max(a, Math.max(b,c));
        return dp[n];
    }
}

//Tabulation code



//User function Template for Java


class Solution
{
    //Function to find the maximum number of cuts.
    public int maximizeCuts(int n, int x, int y, int z)
    {
       //Your code here
       return solve(n,x,y,z);
    }
    int solve(int n,int x , int y, int z){
        
        int dp[] = new int[n+1];
        Arrays.fill(dp,Integer.MIN_VALUE);
        dp[0] = 0;
        
        for(int i=1; i<=n; i++){
            if(i-x >= 0)
                dp[i] = Math.max(dp[i],dp[i-x] + 1);
            if(i-y >= 0)
                dp[i] = Math.max(dp[i],dp[i-y] + 1);
            if(i-z >= 0)
                dp[i] = Math.max(dp[i],dp[i-z] + 1);
        }
        
        if(dp[n] < 0){
            return 0;
        }
        
        return dp[n];
    }
}

//Space optimiazation is notp possible in this problem
