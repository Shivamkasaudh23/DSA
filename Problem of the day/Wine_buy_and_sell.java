//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

public class GFG {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while(T>0)
        {
            int N = sc.nextInt();
            int arr[] = new int[N];
            for(int i=0; i<N; i++)
                arr[i] = sc.nextInt();
            
            Solution g = new Solution();
            long ans = g.wineSelling(arr,N);
            
            System.out.println(ans);
            T--;
        }
    }
}


// } Driver Code Ends
//User function Template for Java


class Solution {
    long wineSelling(int Arr[],int n){
        // code here
        int b = 0; 
        int s = 0;
        long ans = 0;
        while(b<n && s<n){
            while(Arr[b] <= 0){
                b++;
                if(b == n) return ans;
            }
            while(Arr[s] >= 0){
                s++;
                if(s == n) return ans;
            }
            
            if(Math.abs(Arr[b]) >= Math.abs(Arr[s])){
                ans += (long)(Math.abs(b-s) * Math.abs(Arr[s]));
                Arr[b] += Arr[s];
                Arr[s] = 0;
            }
            else{
               ans += (long)(Math.abs(b-s) * Math.abs(Arr[b]));
                Arr[s] += Arr[b];
                Arr[b] = 0; 
            }
        }
        return ans;
        
    }
}

//{ Driver Code Starts.
// } Driver Code Ends