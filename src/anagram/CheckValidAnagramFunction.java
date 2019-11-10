package anagram;

public class CheckValidAnagramFunction {
    public boolean isAnagram(String s, String t) {
        // If length is not the same, false
        if(s.length() != t.length()){
            return false;
        }

        // size of 26 because lower case of a - z only
        int[] abc = new int[26];
        
        // Storing the first String to the array
        for(char letter : s.toCharArray()){
            // 'a' - 'a' = 0, 'b' - 'a' = 1
        	// Unique way to keep count
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
    
    // Second way of doing it, seems slower than the first method
//    public boolean isAnagram(String s, String t){
//        // First check if they are both the same length, if not return false
//        if(s.length() != t.length()){
//            return false;
//        }
//        
//        // Since there will be only lowercase a-z
//        int[] abc = new int[26];
//        
//        // Since both string length is the same, use either
//        for(int i = 0; i < s.length(); i++){
//            abc[s.charAt(i) - 'a']++;
//            abc[t.charAt(i) - 'a']--;
//        }
//        
//        // Finally, check the abc array if any of them is negative
//        for(int letter : abc){
//            if(letter != 0){
//                return false;
//            }
//        }
//        
//        return true;
//    }
}
