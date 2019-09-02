package anagram;

public class CheckValidAnagramFunction {
    public boolean isAnagram(String s, String t) {
        // If length is not the same, false
        if(s.length() != t.length()){
            return false;
        }

        int[] abc = new int[26];
        
        // Storing the first String to the array
        for(char letter : s.toCharArray()){
            // 'a' - 'a' = 0, 'b' - 'a' = 1
            abc[letter - 'a'] = abc[letter - 'a'] + 1; 
        }
        
        // Checking if the second String is equal to the first String
        for(char letter : t.toCharArray()){
            // By doing -- before the array, it will subtract first
            if(--abc[letter - 'a'] < 0){
                return false;
            }
        }
        
        // Return true since we know they are anagram
        return true;
    }
}
