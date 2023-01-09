class Solution {
    public int characterReplacement(String s, int k) {
       int arr[] = new int[26];
       int start =0; 
       int maxlen = 0;
       int maxCount = 0;
       for(int end=0; end<s.length(); end++){
           arr[s.charAt(end)-'A']++;

           maxCount = Math.max(maxCount,arr[s.charAt(end)-'A']);

           while(end-start+1-maxCount> k){
               arr[s.charAt(start)-'A']--;
               start++;
           }
           maxlen = Math.max(maxlen,end - start + 1);
       }
       return maxlen;
        
    }
}