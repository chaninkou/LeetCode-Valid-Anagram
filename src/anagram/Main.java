package anagram;

public class Main {
	public static void main(String[] args) {
		String s = "michael";
		String t = "ichmael";
		
		System.out.println("Input S: " + s + " Input T: " + t);
		
		CheckValidAnagramFunction solution = new CheckValidAnagramFunction();
		
		System.out.println("Solution: " + solution.isAnagram(s, t));
	}
}
