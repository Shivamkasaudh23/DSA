//Recusion + Memoization
class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int dp [] = new int[n+1];
        Arrays.fill(dp,-1);
        int ans = Math.min(solve(cost,dp,n-1),solve(cost,dp,n-2));
        return ans;
    }
    int solve(int [] cost, int [] dp, int n){
        if(n==0) return cost[0];
        if(n==1) return cost[1];

        if(dp[n] != -1) return dp[n];

        int ans = cost[n] + Math.min(solve(cost,dp,n-1),solve(cost,dp,n-2));
        return ans;
    }
}


//Tabulation Method
class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        return solve(cost,n);
    }
    int solve(int [] cost, int n){
        int dp[] = new int[n+1];

        //base case 
        dp[0] = cost[0];
        dp[1] = cost[1];

        for(int i=2; i<n; i++){
            dp[i] = cost[i] + Math.min(dp[i-1],dp[i-2]);
        }
        return Math.min(dp[n-1],dp[n-2]);
    }
}



//Space Optimization Solution
class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        return solve(cost,n);
    }
    int solve(int [] cost, int n) {

        //base case 
       int prev2 = cost[0];
       int prev1 = cost[1];

        for(int i=2; i<n; i++){
            int curr = cost[i] + Math.min(prev1,prev2);
            prev2 = prev1;
            prev1 = curr;
        }
        return Math.min(prev1,prev2);
    }
}