class Solution {
    public String nearestPalindromic(String n) {
        int index = n.length()/2;
        boolean even = n.length() %2 == 0;
        if(even) index -= 1;
        long leftPart = Long.parseLong(n.substring(0,index+1));

        //5 cases
        List<Long> cases = new ArrayList<>();
        //converting end digits to starting digits
        cases.add(getPalindrome(leftPart,even));
        //increamenting middle 
        cases.add(getPalindrome(leftPart+1,even));
        //decreamenting middle
        cases.add(getPalindrome(leftPart-1,even));
        //reduce digit by 1
        cases.add((long)Math.pow(10,n.length()-1)-1);
        // increase digit by 1
        cases.add((long)Math.pow(10,n.length())+1);

        long result = 0;
        long diff = Integer.MAX_VALUE;
        long num = Long.parseLong(n);
        for( long c : cases){
            if(c == num) continue;
            long curr = Math.abs(num-c);
            if(curr<diff){
                result = c;
                diff = curr;
            }
            else if(curr == diff){
                result = Math.min(result,c);
            }
        }
        return String.valueOf(result);

    }

    long getPalindrome(long leftPart, boolean even){
        long result = leftPart;
        if(!even) leftPart /= 10;

        while(leftPart > 0){
            result = (result * 10) + leftPart % 10;
            leftPart /= 10;
        }

        return result;
    }
}