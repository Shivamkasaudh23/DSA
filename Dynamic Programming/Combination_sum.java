//Recusive code
class Solution {
    public int combinationSum4(int[] nums, int target) {
        return solve(nums,target);
    }

    int solve(int [] nums, int tar){
        //Base case
        if(tar < 0) return 0;
        if(tar == 0) return 1;

        int ans = 0;
        for(int i=0; i<nums.length; i++){
            ans += solve(nums, tar - nums[i]);
        }

        return ans;
    }
}


//dp code
class Solution {
    public int combinationSum4(int[] nums, int target) {
        int dp [] = new int[target+1];
        Arrays.fill(dp, -1);
        return solve(nums,target, dp);


    }

    int solve(int [] nums, int tar, int [] dp){
        //Base case
        if(tar < 0) return 0;
        if(tar == 0) return 1;

        if(dp[tar] != -1){
            return dp[tar];
        }


        int ans = 0;
        for(int i=0; i<nums.length; i++){
            ans += solve(nums, tar - nums[i], dp);
        }

        dp[tar] = ans;

        return dp[tar];
    }
}
```


//Tabulation code
class Solution {
    public int combinationSum4(int[] nums, int target) {
        return solve(nums,target);
    }

    int solve(int [] nums, int tar){
        //Base case
      int []dp =  new int[tar+1];
      Arrays.fill(dp, 0);
      dp[0] = 1;

    //traversing target from 1 to tar
      for(int i=1; i<=tar; i++){
        
        //traversing nums array
          for(int j= 0; j<nums.length; j++){
              if(i-nums[j] >= 0)
                dp[i] += dp[i-nums[j]];
          }
      }
      return dp[tar];
    }
}