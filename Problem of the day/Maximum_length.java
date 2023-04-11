
// Given the maximum occurrences of a, b, and c in a string. Your task is to make the largest length string containing only a, b, and c such that no three consecutive characters are the same. Return the longest possible string length.



class Solution {
    int solve(int a, int b, int c) {
        // code here
        int max = Math.max(a,Math.max(b,c));
        int sum = a+b+c-max;
        
        return (max <= sum * 2) ? a+b+c : -1;
    }
};