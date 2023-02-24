// Recusive code 

class Solution
{
    //Function to find the maximum money the thief can get.
    public int FindMaxSum(int arr[], int n)
    {
        // Your code here
        int ans = solve(arr,n-1);
        return ans;
    }
    int solve(int arr[], int n){
        if(n<0) 
            return 0;
            
        if(n == 0)
            return arr[0];
            
            
        int incl = solve(arr , n-2) + arr[n];
        int excl = solve(arr, n-1) + 0;
        
        return Math.max(incl,excl);
    }
}


//Reccursive code with memoization



class Solution
{
    //Function to find the maximum money the thief can get.
    public int FindMaxSum(int arr[], int n)
    {
        // Your code here
        int dp [] = new int[n];
        Arrays.fill(dp, -1);
        return solve(arr,n-1,dp);
    }
    int solve(int arr[], int n, int [] dp){
        if(n<0) 
            return 0;
            
        if(n == 0)
            return arr[0];
            
        if(dp[n] != -1){
            return dp[n];
        }
            
        int incl = solve(arr , n-2,dp) + arr[n];
        int excl = solve(arr, n-1,dp) + 0;
        
        dp[n] = Math.max(incl,excl);
        
        return dp[n];
    }
}


//Tabulation code



class Solution
{
    //Function to find the maximum money the thief can get.
    public int FindMaxSum(int arr[], int n)
    {
        // Your code here
        return solve(arr,n);
    }
    int solve(int arr[], int n){
        if(n==1) return arr[0];
        
        int dp [] = new int[n+1];
        
    
        dp[0] = arr[0];
        dp[1] = Math.max(arr[0],arr[1]);
        
        for(int i=2; i<n; i++){
            int incl = dp[i-2] + arr[i];
            int excl = dp[i-1] + 0;
            dp[i] = Math.max(incl,excl);
          
        }
        
        return dp[n-1];
    }
}


// Tabulation code with space optimization



class Solution
{
    //Function to find the maximum money the thief can get.
    public int FindMaxSum(int arr[], int n)
    {
        // Your code here
        return solve(arr,n);
    }
    int solve(int arr[], int n){
        if(n==1) return arr[0];
        
        int prev2 = 0;
        int prev1 = arr[0];
        
        for(int i=1; i<n; i++){
            int incl = prev2 + arr[i];
            int excl = prev1 + 0;
            int ans = Math.max(incl,excl);
            
            prev2 = prev1;
            prev1 = ans;
        }
        
        return prev1;
    }
}