class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> ans = new ArrayList<>();
        helper(s,0,0,"",ans);
        return ans;
    }
    public void helper(String s, int i, int par,String temp, List<String> ans){
        if(i == s.length() ||  par == 4){
            if(i == s.length() && par == 4){
                ans.add(temp.substring(0,temp.length()-1));
            }
            return;
        }

        helper(s,i+1,par+1,temp+s.charAt(i)+".",ans);
        if(i+2<=s.length() && isValid(s.substring(i,i+2)))
            helper(s,i+2,par+1,temp+s.substring(i,i+2)+'.',ans);
        if(i+3<=s.length() && isValid(s.substring(i,i+3)))
            helper(s,i+3,par+1,temp+s.substring(i,i+3)+'.',ans);
    }
    public boolean isValid(String s){
        if(s.charAt(0) == '0'){
            return false;
        }
        int val = Integer.parseInt(s);
        return val<= 255;

    }
}