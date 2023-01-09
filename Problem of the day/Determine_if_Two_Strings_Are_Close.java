class Solution {
    public boolean closeStrings(String word1, String word2) {
        int arr1[] = new int[26];
        int arr2[] = new int[26];
        int arr3[] = new int[26];
        int arr4[] = new int[26];

        for(int i=0; i<word1.length(); i++){
            arr1[word1.charAt(i)-'a']++;
            arr2[word1.charAt(i)-'a'] = 1;
        }

        for(int i=0; i<word2.length(); i++){
            arr3[word2.charAt(i)-'a']++;
            arr4[word2.charAt(i)-'a'] = 1;
        }

        Arrays.sort(arr1);
        Arrays.sort(arr3);

        if((Arrays.equals(arr1, arr3)) && (Arrays.equals(arr2, arr4)))
        return true;

        return false;
    }
}