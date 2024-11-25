/** Functions for checking if a given string is an anagram. */
public class Anagram {
	public static void main(String args[]) {
		// Tests the isAnagram function.
		System.out.println(isAnagram("silent","listen"));  // true
		System.out.println(isAnagram("William Shakespeare","I am a weakish speller")); // true
		System.out.println(isAnagram("Madam Curie","Radium came")); // true
		System.out.println(isAnagram("I am Lord Voldemort","Tom Marvolo Riddle")); // true
		//System.out.println("##############################################");
		//System.out.println("####################mine######################");
		//System.out.println("##############################################");
		//System.out.println(isAnagram("babaa","abbba")); //false
		//System.out.println(isAnagram("baba","abba")); //true
		//System.out.println(isAnagram("babaa","abcba")); //false
		//System.out.println(isAnagram("baba","abcba")); //false
		//System.out.println(isAnagram("   ","  ")); //false or true?
		//System.out.println(isAnagram("a "," a")); //true
		//System.out.println(isAnagram("anagram","nag ram a"));


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

	public static boolean isAnagram(String str1, String str2) {
		String newStr1 = preProcess(str1);
		String newStr2 = preProcess(str2);
		//System.out.println("newstr1 = "+newStr1);
		//System.out.println("newstr2 = "+newStr2);
		String newForCheck = "";
		boolean check = true;
		int indexForHelp = 0;

		for(int i = 0; i < newStr1.length(); i++){
			char c = newStr1.charAt(i);
			//System.out.println("c= " + c);
			indexForHelp = newStr2.indexOf(c);
			if (indexForHelp == -1){
				//System.out.println("not found in str2");
				return false;
			}
			else{
				newForCheck = newStr2.substring(0, indexForHelp);
				newForCheck = newForCheck + newStr2.substring(indexForHelp+1);
			}
			//System.err.println("new for check: " + newForCheck);
			newStr2 = newForCheck;

		}
		//System.out.println("newforcheck= " + newForCheck.length());
		if (newForCheck.length() > 0){
			//System.out.println("i am here");
			return false;
		}
		return true;
	}


	// Returns true if the two given strings are anagrams, false otherwise.
	public static boolean isAnagram1(String str1, String str2) {
		String newStr1 = preProcess(str1);
		String newStr2 = preProcess(str2);
		String newForCheck = "";

		// i pulled out the consideration with the long of the str's, because it doesnt pass the exams... now string with only spaces with different length is true
		//if(newStr1.length() != newStr2.length()){
		//	System.out.println("the length isnt eq");
		//	return false;
		//}
		//if we dont to dont take consider in spaces' we should put out the c == ' ' in the preProcess function and delete the greem from the length checking

		int i = 0;
		while (i < newStr1.length()){
			char c = newStr1.charAt(i);
			int j = 0;
			newForCheck = "";
			while (j < newStr2.length()){
				char c2 = newStr2.charAt(j);
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
