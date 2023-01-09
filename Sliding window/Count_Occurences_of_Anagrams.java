//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String txt = br.readLine().trim();
            String pat = br.readLine().trim();

            int ans = new Solution().search(pat, txt);

            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {

    int search(String pat, String txt) {
        // code here
        int count = 0;
        HashMap<Character,Integer> map = new HashMap<>();
        for(char x : pat.toCharArray()){
            map.put(x,map.getOrDefault(x,0)+1);
        }
        
        HashMap<Character,Integer> hmap = new HashMap<>();
        int i=0,j=0;
        while(j<txt.length()){
            hmap.put(txt.charAt(j),hmap.getOrDefault(txt.charAt(j),0)+1);
            if( (j-i+1) < pat.length() ){
                j++;
            }else if(j-i+1 == pat.length()) {
                if(hmap.equals(map)) count++;
                int freq = hmap.get(txt.charAt(i));
                if(freq == 1) hmap.remove(txt.charAt(i));
                else hmap.put(txt.charAt(i),freq-1);
                i++;
                j++;
            }
        }
        return count;

    }
}