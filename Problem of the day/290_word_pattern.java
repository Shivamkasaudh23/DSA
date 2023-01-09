class Solution {
    public boolean wordPattern(String pattern, String s) {
        String words[] = s.split(" ");

        if(words.length != pattern.length()){
            return false;
        }

        HashMap<Character,String> CharToWord = new HashMap<>();
        HashMap<String,Character> WordToChar = new HashMap<>();
        
        for(int i=0; i<words.length; i++){
            char c = pattern.charAt(i);
            String word = words[i];

            if(!CharToWord.containsKey(c)){
                CharToWord.put(c,word);
            }

            if(!WordToChar.containsKey(word)){
                WordToChar.put(word,c);
            }

            if(!CharToWord.get(c).equals(word) || !WordToChar.get(word).equals(c)){
                return false;
            }
        }
        return true;
    }
}