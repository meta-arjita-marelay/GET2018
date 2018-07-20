package Question1;

/**
 * this class contains function to perform different operations on string
 * 
 * @author Arjita
 *
 */
public class StringOperations {
	/**
	 * 
	 * @param inputString1
	 *            string should be not null and case sensitive
	 * @param inputString2
	 *            string should be not null and case sensitive
	 * @return will return true if strings are equal
	 */
	public boolean compareStrings(String inputString1, String inputString2) {
		int i = 0;
		if (inputString1.length() == inputString2.length()) {
			while (i < inputString2.length()) {
				if (inputString1.charAt(i) != inputString2.charAt(i)) {
					return false;
				}
				i++;
			}
		}
		return true;
	}

	/**
	 * 
	 * @param inputString
	 *            string should be not null and case sensitive
	 * @return reverse of string
	 */
	public String reverseString(String inputString) {
		int lengthOfString = inputString.length();
		String stringReverse = "";
		for (int i = lengthOfString - 1; i >= 0; i--) {
			stringReverse = stringReverse + inputString.charAt(i);
		}
		return stringReverse;
	}

	/**
	 * 
	 * @param inputString
	 *            string should be not null and case sensitive
	 * @return interchange of cases
	 */
	public String changeCase(String inputString) {
		char inputChar;
		String changedString = "";
		for (int i = 0; i < inputString.length(); i++) {
			inputChar = inputString.charAt(i);
			if (inputChar > 64 && inputChar < 91) {
				inputChar = (char) (inputChar + 32);
			} else if (inputChar > 96 && inputChar < 123) {
				inputChar = (char) (inputChar - 32);
			}
			changedString = changedString + inputChar;
		}
		return changedString;
	}

	/**
	 * 
	 * @param inputString
	 *            string should be not null and case sensitive
	 * @return largest word of string
	 */
	public String largestWord(String inputString) {
		int count = 0;
		String intermediateCode = "";
		String largestCode = "";
		int maxLength = 0;
		for (int i = 0; i < inputString.length(); i++) {
			if (inputString.charAt(i) != ' ') {
				count++;
				intermediateCode = intermediateCode + inputString.charAt(i);
			} else {

				count = 0;
				intermediateCode = "";
			}
			if (maxLength <= count) {
				maxLength = count;
				largestCode = intermediateCode;
			}

		}
		return largestCode;
	}

}