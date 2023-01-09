//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int N = Integer.parseInt(read.readLine());
            String input_line[] = read.readLine().trim().split("\\s+");
            int Arr[]= new int[N];
            for(int i = 0; i < N; i++)
                Arr[i] = Integer.parseInt(input_line[i]);
            
            Solution ob = new Solution();
            int[] ans = ob.twoOddNum(Arr,N);
            for(int i = 0; i < ans.length; i++)
            {
                System.out.print(ans[i] + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


//User function Template for Java

//User function Template for Java
class Solution
{
    public int[] twoOddNum(int Arr[], int N)
    {
        // code here
        int x = 0; 
        for(int i=0; i<N; i++){
            x = x^Arr[i];
        }
        
        int set = x & ~(x-1);
        
        int f = 0;
        int s = 0;
        
        for(int i=0; i<N; i++){
            if((set & Arr[i]) > 0){
                f = f^Arr[i];
            }
            else{
                s = s^Arr[i];
            }
        }
        
        int ans [] =  new int[2];
        
        if(f>s){
            ans[0] = f;
            ans[1] = s;
            return ans;
        }
        ans[0] = s;
        ans[1] = f;
        return ans;
    }
}