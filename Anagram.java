/** Functions for checking if a given string is an anagram. */
public class Anagram {
	public static void main(String args[]) {
		// Tests the isAnagram function.
		System.out.println(isAnagram("silent","listen"));  // true
		System.out.println(isAnagram("William Shakespeare","I am a weakish speller")); // true
		System.out.println(isAnagram("Madam Curie","Radium came")); // true
		System.out.println(isAnagram("I am Lord Voldemort","Tom Marvolo Riddle")); // true
		System.out.println("##############################################");
		System.out.println("####################mine######################");
		System.out.println("##############################################");
		System.out.println(isAnagram("babaa","abbba")); //false
		System.out.println(isAnagram("baba","abba")); //true
		System.out.println(isAnagram("babaa","abcba")); //false
		System.out.println(isAnagram("baba","abcba")); //false
		System.out.println(isAnagram("   ","  ")); //false or true?
		System.out.println(isAnagram("a "," a")); //true
		System.out.println(isAnagram("anagram","nag ram a"));


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
		String newStr1 = preProcess1(str1);
		String newStr2 = preProcess1(str2);
		String newForCheck = "";
		int indexForHelp = 0;

		for(int i = 0; i < newStr1.length(); i++){
			char c = newStr1.charAt(i);
			indexForHelp = newStr2.indexOf(c);
			if (indexForHelp == -1){
				return false;
			}
			else{
				newForCheck = newStr2.substring(0, indexForHelp);
				newForCheck = newForCheck + newStr2.substring(indexForHelp+1);
			}
			newStr2 = newForCheck;

		}
		if (newForCheck.length() > 0){
			return false;
		}
		return true;
	}
	   
	// Returns a preprocessed version of the given string: all the letter characters are converted
	// to lower-case, and all the other characters are deleted, except for spaces, which are left
	// as is. For example, the string "What? No way!" becomes "whatnoway"
	public static String preProcess(String str) {
		String newString = "";
		String newLower = str.toLowerCase();
		for (int i = 0; i < newLower.length(); i++){
			char c = newLower.charAt(i);
			if( (c >= 'a' && c <= 'z') || c == ' ' ){
				newString = newString + c;
			}
		}
		return newString;
	} 

	//I had to duplicate to function to override the fact that one of the test requires to take consider with spaces and the another don't require this
	public static String preProcess1(String str) {
		String newString = "";
		String newLower = str.toLowerCase();
		for (int i = 0; i < newLower.length(); i++){
			char c = newLower.charAt(i);
			if( (c >= 'a' && c <= 'z')){
				newString = newString + c;
			}
		}
		return newString;
	} 
	   
	// Returns a random anagram of the given string. The random anagram consists of the same
	// characters as the given string, re-arranged in a random order. 
	public static String randomAnagram(String str) {
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
