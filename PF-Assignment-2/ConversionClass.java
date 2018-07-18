package Hexadecimal;

/*
 * this class includes function which will convert hexadecimal number to decimal number and vice versa.
 */
public class ConversionClass {
	/*
	 * this function will convert decimal number to hexadecimal number.
	 */
	public String decimalToHexa(int decimalNumber) {
		char hexaChar[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
				'A', 'B', 'C', 'D', 'E', 'F' };
		int remainder;
		String hexadecimalNumber = "";
		while (decimalNumber != 0) {
			remainder = decimalNumber % 16;
			hexadecimalNumber = hexaChar[remainder] + hexadecimalNumber;
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
