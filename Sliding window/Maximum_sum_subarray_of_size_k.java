class Solution{
    static long maximumSumSubarray(int K, ArrayList<Integer> Arr,int N){
        // code here
        if(N<K) return -1;
         int i=0; 
         int j = 0;
         long sum = 0;
         long max = Integer.MIN_VALUE;
         while(j<N) {
            sum += Arr.get(j)  % (long)(1e6);
            
            if(j-i+1<K) {
              j++;
            }
            else if(j-i+1 == K){
                max=Math.max(max,sum);
                sum=sum-Arr.get(i);
                j++;    
                i = i+1;
                
                //
            }
        }
        return max;
    }
}