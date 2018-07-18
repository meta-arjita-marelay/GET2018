package Hexadecimal;

public class Operations {
	ConversionClass convert = new ConversionClass();

	/*
	 * this function will add two hexadecimal numbers by firstly converting them
	 * to decimal then result will be converted to hexadecimal again.
	 */
	public String addHexadecimal(String hexaValue1, String hexaValue2) {
		int decimalValue1 = convert.hexaToDecimal(hexaValue1);
		int decimalValue2 = convert.hexaToDecimal(hexaValue2);
		int decimalValue3 = decimalValue1 + decimalValue2;
		String hexaValue3 = convert.decimalToHexa(decimalValue3);
		return hexaValue3;
	}

	/*
	 * this function will add two hexadecimal numbers by firstly converting them
	 * to decimal then result will be converted to hexadecimal again.
	 */
	public String subtractHexadecimal(String hexaValue1, String hexaValue2) {
		int decimalValue1 = convert.hexaToDecimal(hexaValue1);
		int decimalValue2 = convert.hexaToDecimal(hexaValue2);
		int decimalValue3 = decimalValue1 - decimalValue2;
		String hexaValue3 = convert.decimalToHexa(decimalValue3);
		return hexaValue3;
	}

	/*
	 * this function will add two hexadecimal numbers by firstly converting them
	 * to decimal then result will be converted to hexadecimal again.
	 */
	public String multiplyHexadecimal(String hexaValue1, String hexaValue2) {
		int decimalValue1 = convert.hexaToDecimal(hexaValue1);
		int decimalValue2 = convert.hexaToDecimal(hexaValue2);
		int decimalValue3 = decimalValue1 * decimalValue2;
		String hexaValue3 = convert.decimalToHexa(decimalValue3);
		return hexaValue3;
	}

	/*
	 * this function will add two hexadecimal numbers by firstly converting them
	 * to decimal then result will be converted to hexadecimal again.
	 */
	public String divideHexadecimal(String hexaValue1, String hexaValue2) {
		int decimalValue1 = convert.hexaToDecimal(hexaValue1);
		int decimalValue2 = convert.hexaToDecimal(hexaValue2);
		int decimalValue3 = decimalValue1 / decimalValue2;
		String hexaValue3 = convert.decimalToHexa(decimalValue3);
		return hexaValue3;
	}
	/*
	 * this function will check if two hexadecimal numbers are equal
	 */
	public boolean equalHexadecimal(String hexaValue1, String hexaValue2) {
		hexaValue1 = removeLeadingZero(hexaValue1);
		hexaValue2 = removeLeadingZero(hexaValue2);
		if (isHexadecimal(hexaValue1) && isHexadecimal(hexaValue2)) {
			if (hexaValue1.equalsIgnoreCase(hexaValue2)) {
				return true;
			}
		}
		return false;
	}
	/*
	 * this function will check if first hexadecimal number is greater than other
	 */
	public boolean greaterHexadecimal(String hexaValue1, String hexaValue2) {
		hexaValue1 = removeLeadingZero(hexaValue1);
		hexaValue2 = removeLeadingZero(hexaValue2);
		if (isHexadecimal(hexaValue1) && isHexadecimal(hexaValue2)) {
			if (hexaValue1.compareToIgnoreCase(hexaValue2) > 0) {
				return true;
			}
		}
		return false;
	}
	
	/*
	 * this function will check if first hexadecimal number is smaller than other
	 */
	public boolean smallerHexadecimal(String hexaValue1, String hexaValue2) {
		hexaValue1 = removeLeadingZero(hexaValue1);
		hexaValue2 = removeLeadingZero(hexaValue2);
		if (isHexadecimal(hexaValue1) && isHexadecimal(hexaValue2)) {
			if (hexaValue1.compareToIgnoreCase(hexaValue2) < 0) {
				return true;
			}
		}
		return false;
	}
	/*
	 * this function will remove the leading zeroes from hexadecimal number
	 */
	public String removeLeadingZero(String hexaValue) {
		hexaValue = hexaValue.replaceFirst("^0+(?!$)", "");

		return hexaValue;
	}
	/*
	 * this function will check if number is hexadecimal or not.
	 */
	public boolean isHexadecimal(String hexaValue) {
		String patternCheck = "^[0-9A-Fa-f]+$";
		if (hexaValue.matches(patternCheck)) {
			return true;
		} else {
			return false;
		}
	}
}
