package Question1;

/**
 * this is main class for string operations and will call different functions
 * for different operations
 * 
 * @author Arjita
 *
 */
public class StringMain {
	public static void main(String[] args) {
		StringOperations operationString = new StringOperations();
		System.out.println("Arjita and arjita are same string: "
				+ operationString.compareStrings("Arjita", "arjita"));
		System.out.println("Arjita and Arjita are same string: "
				+ operationString.compareStrings("Arjita", "Arjita"));
		System.out.println("Reverse of arjita is: "
				+ operationString.reverseString("arjita"));
		System.out.println("ArjITa after cases are interchanged: "
				+ operationString.changeCase("ArjITa"));
		System.out
				.println("largest word in string: arjita marelay is trainee: is-    "
						+ operationString
								.largestWord("arjita marelay is trainee"));
	}
}
