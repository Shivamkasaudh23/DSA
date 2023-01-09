

// An ugly number is a positive integer whose prime factors are limited to 2, 3, and 5.

// Given an integer n, return true if n is an ugly number.

class Solution {
    public boolean isUgly(int n) {
        if(n <= 0)
            return false;

        int arr [] = {2,3,5};

        for(int i : arr){
           n =  check(n,i);
        }

        return n == 1;
    }
    int check(int dividend, int diviser){
        while(dividend % diviser == 0){
            dividend = dividend / diviser;
        }
        return dividend;
    }
}