//Recursion Code 

class Solution {
    public int coinChange(int[] nums, int amount) {
        int ans = solve(nums,amount);
        if(ans == Integer.MAX_VALUE) return -1;
        return ans;
    }
    int solve(int nums[], int amount){
        if(amount == 0) return 0;

        if(amount < 0) return Integer.MAX_VALUE;

        int mini = Integer.MAX_VALUE;
        for(int i=0; i<nums.length; i++){
            int ans = solve(nums,amount-nums[i]);

            if(ans != Integer.MAX_VALUE)
                    mini = Math.min(mini, 1+ans);
        }

        return mini;
    }
}


//Memoization Code

class Solution {
    public int coinChange(int[] nums, int amount) {
        int dp [] = new int[amount+1]; 
        Arrays.fill(dp,-1);
        int ans = solve(nums,amount,dp);
        if(ans == Integer.MAX_VALUE) return -1;
        return ans;
    }
    int solve(int nums[], int amount,int []dp){
        if(amount == 0) return 0;

        if(amount < 0) return Integer.MAX_VALUE;

        if(dp[amount] != -1) return dp[amount];

        int mini = Integer.MAX_VALUE;
        for(int i=0; i<nums.length; i++){
            int ans = solve(nums,amount-nums[i],dp);

            if(ans != Integer.MAX_VALUE)
                    mini = Math.min(mini, 1+ans);
        }
        dp[amount] = mini;

        return mini;
    }
}



//Tabulation Code

class Solution {
    public int coinChange(int[] nums, int amount) {
        
        return solve(nums,amount);
    }
    int solve(int nums[], int amount){

        int []dp = new int[amount+1];
        Arrays.fill(dp,Integer.MAX_VALUE);

        dp[0] = 0;

       for(int i=1;i<=amount;i++){
            for(int j=0;j<nums.length;j++){
                if(i-nums[j]>=0 && dp[i-nums[j]]!=Integer.MAX_VALUE)
                    dp[i]=Math.min(dp[i],1+dp[i-nums[j]]);
            }
            
        }

       if(dp[amount] == Integer.MAX_VALUE){
           return -1;
       } 

       return dp[amount];
    }
}

