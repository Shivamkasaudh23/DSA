class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> li = new ArrayList<>();
        int low = 0;
        int high = arr.length - 1;
        
        while(high - low >= k){
            int dislow = Math.abs(x-arr[low]);
            int dishigh = Math.abs(x-arr[high]);
            
            if(dislow <= dishigh){
                high--;
            }
            else{
                low++;
            }
        }
        
        while(low <= high){
            li.add(arr[low++]);
        }
        return li;
    }
    
}