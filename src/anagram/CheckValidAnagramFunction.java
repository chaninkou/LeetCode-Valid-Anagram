package anagram;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class CheckValidAnagramFunction {
	// Faster way to do it, since second loop will return false if its negative right away
    public boolean isAnagram(String s, String t) {
        // Once length not same, return false
        if(s.length() != t.length()){
            return false;
        }

        // size of 26 because lower case of a - z only
        int[] abc = new int[26];
        
        // Storing the first String to the array
        for(char letter : s.toCharArray()){
            // 'a' - 'a' = 0, 'b' - 'a' = 1
        	// Unique way to keep count
            abc[letter - 'a'] += 1; 
        }
        
        // Checking if the second String is equal to the first String
        for(char letter : t.toCharArray()){
            // By doing -- before the array, it will subtract first
            if(--abc[letter - 'a'] < 0){
                return false;
            }
        }
        
        // Return true since we know they are anagram(same)
        return true;
    }
    
    // This is the fastest way to do it, but take up more memory 
    public boolean isAnagram2(String s, String t){
    	if(s.length() != t.length()){
    		return false;
    	}
    	
    	int[] map1 = new int[26];
    	int[] map2 = new int[26];
    	
    	for(char c : s.toCharArray()){
    		map1[c - 'a']++;
    	}
    	
    	for(char c : t.toCharArray()){
    		map2[c - 'a']++;
    	}
    	
    	// Easy approach, using two array to store the count and compare them
    	for(int i = 0; i < 26; i++){
    		if(map1[i] != map2[i]){
    			return false;
    		}
    	}
    	
    	return true;
    }
    
    public boolean isAnagram3(String s, String t){
    	if(s.length() != t.length()){
    		return false;
    	}
    	
    	Map<Character, Integer> map = new HashMap<>();
    	
    	// Same thing if you just use another loop to do it if we do it separated     
    	for(int i = 0; i < s.length(); i++){
    		// add
    		map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
    		
    		// delete
    		map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) - 1);
    	}
    	
    	Set<Map.Entry<Character, Integer>> entry = map.entrySet();
    	
    	for(Map.Entry<Character, Integer> c : entry){
    		// whichever one is negative, return false
    		if(c.getValue() < 0){
    			return false;
    		}
    	}
    	
//    	for(char w : map.keySet()){
//    		if(map.get(w) < 0){
//    			return false;
//    		}
//    	}
	
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
