/** Functions for checking if a given string is an anagram. */
public class Anagram {
	public static void main(String args[]) {
		// Tests the isAnagram function.
		System.out.println(isAnagram("silent","listen"));  // true
		System.out.println(isAnagram("William Shakespeare","I am a weakish speller")); // true
		System.out.println(isAnagram("Madam Curie","Radium came")); // true
		System.out.println(isAnagram("Tom Marvolo Riddle","I am Lord Voldemort")); // true
		System.out.println("mine");
		System.out.println(isAnagram("baba","abba"));
		System.out.println(isAnagram("babaa","abcba"));
		System.out.println(isAnagram("baba","abcba"));
		System.out.println(isAnagram("   ","  "));
		System.out.println(isAnagram("a "," a"));


		// Tests the preProcess function.
		System.out.println(preProcess("William Shakespeare"));
		System.out.println(preProcess("I am a weakish speller"));
		System.out.println(preProcess("Tom Marvolo Riddle"));
		System.out.println(preProcess("I am Lord Voldemort"));
		
		// Tests the randomAnagram function.
		System.out.println("silent and " + randomAnagram("silent") + " are anagrams.");
		
		// Performs a stress test of randomAnagram 
		String str = "1234567";
		Boolean pass = true;
		//// 10 can be changed to much larger values, like 1000
		for (int i = 0; i < 10; i++) {
			String randomAnagram = randomAnagram(str);
			System.out.println(randomAnagram);
			pass = pass && isAnagram(str, randomAnagram);
			if (!pass) break;
		}
		System.out.println(pass ? "test passed" : "test Failed");
	}  

	// Returns true if the two given strings are anagrams, false otherwise.
	public static boolean isAnagram(String str1, String str2) {
		String newStr1 = preProcess(str1);
		String newStr2 = preProcess(str2);
		String newForCheck = "";

		if(newStr1.length() != newStr2.length()){
			return false;
		}

		int i = 0;
		while (i < newStr1.length()){
			Character c = newStr1.charAt(i);
			int j = 0;
			newForCheck = "";
			while (j < newStr2.length()){
				Character c2 = newStr2.charAt(j);
				if (c == c2){
					j++;
				}
				else{
					newForCheck = newForCheck + c2;
					j++;
				}
			}
			newStr2 = newForCheck;
			i++;
		}

		if (newForCheck == "" && i == newStr1.length()){
			return true;
		}


		return false;
	}
	   
	// Returns a preprocessed version of the given string: all the letter characters are converted
	// to lower-case, and all the other characters are deleted, except for spaces, which are left
	// as is. For example, the string "What? No way!" becomes "whatnoway"
	public static String preProcess(String str) {
		// Replace the following statement with your code
		String newString = "";
		String newLower = str.toLowerCase();
		for (int i = 0; i < newLower.length(); i++){
			Character c = newLower.charAt(i);
			if( (c >= 'a' && c <= 'z') || c == ' '){
				newString = newString + c;
			}
		}
		return newString;
	} 
	   
	// Returns a random anagram of the given string. The random anagram consists of the same
	// characters as the given string, re-arranged in a random order. 
	public static String randomAnagram(String str) {
		// Replace the following statement with your code
		int numberToChoose = (int)(Math.random() * str.length());
		String newString = "";
		String helper = "";
		while (str != ""){
			helper = "";
			numberToChoose = (int)(Math.random() * str.length());
			newString = newString + str.charAt(numberToChoose);

			for (int i = 0; i < str.length(); i++){
				if (i != numberToChoose) {
					helper = helper + str.charAt(i);	
				}
			}
			str = helper;
		}
		
		return newString;
	}
}
