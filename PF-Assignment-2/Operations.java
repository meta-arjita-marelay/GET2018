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

}
