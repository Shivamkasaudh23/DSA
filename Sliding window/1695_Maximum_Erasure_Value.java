class Solution {
    public int maximumUniqueSubarray(int[] nums) {
       int l =0; 
       int r =0;
       int Score = 0;
       int maxScore = 0;
       Set<Integer> set = new HashSet<>();

       for(r=0; r<nums.length; r++){
            if(set.contains(nums[r])){
                while(l<r && set.contains(nums[r])){
                    set.remove(nums[l]);
                    Score -= nums[l];
                    l++;
                }
            }
            set.add(nums[r]);
            Score += nums[r];
            maxScore = Math.max(maxScore,Score);
       }
       return maxScore;
    }
}