package Hexadecimal;

/*
 * this class includes function which will convert hexadecimal number to decimal number and vice versa.
 */
public class ConversionClass {
	String hexCharacter = "0123456789ABCDEF";

	/*
	 * this function will convert decimal number to hexadecimal number.
	 */
	public String decimalToHexa(int decimalNumber) {
		int remainder;
		String hexadecimalNumber = "";
		while (decimalNumber != 0) {
			remainder = decimalNumber % 16;
			hexadecimalNumber = hexCharacter.charAt(remainder)
					+ hexadecimalNumber;
			decimalNumber = decimalNumber / 16;
		}
		return hexadecimalNumber;
	}

	/*
	 * this function will convert hexa decimal number to deciml number.
	 */
	public int hexaToDecimal(String hexadecimalNumber) {
		int decimalNumber = 0;
		String hex = "0123456789ABCDEF";
		char characterIndex;
		int numberIndex;
		hexadecimalNumber = hexadecimalNumber.toUpperCase();
		for (int i = 0; i < hexadecimalNumber.length(); i++) {
			characterIndex = hexadecimalNumber.charAt(i);
			numberIndex = hex.indexOf(characterIndex);
			decimalNumber = 16 * decimalNumber + numberIndex;
		}
		return decimalNumber;
	}
}
