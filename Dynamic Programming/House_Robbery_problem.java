// Tabulation code 

// this problem is similar to minimum sum of non adjacent elements problem.... just addition is here houses are in circular form so we have to consider the last house and first house as adjacent houses


import java.util.* ;
import java.io.*; 
public class Solution {
	public static long houseRobber(int[] valueInHouse) {
		// Write your code here.
		int n = valueInHouse.length;
		ArrayList<Integer> arr1 = new ArrayList<>();
		ArrayList<Integer> arr2 = new ArrayList<>();

		if(n == 1) return valueInHouse[0];
		
		for(int i=0; i<n; i++){
			if(i!= n-1){
				arr1.add(valueInHouse[i]);
			}
			if(i != 0){
				arr2.add(valueInHouse[i]);
			}
		}		

		return Math.max(solve(arr1),solve(arr2));
	}	
	static long solve(ArrayList<Integer> arr){
		long n = arr.size();
        if(n==1) return arr.get(0);
        
        long prev2 = 0;
        long prev1 = arr.get(0);
        
        for(int i=1; i<n; i++){
            long incl = prev2 + arr.get(i);
            long excl = prev1 + 0;
            long ans = Math.max(incl,excl);
            
            prev2 = prev1;
            prev1 = ans;
        }
        
        return prev1;
    }
}