package Hexadecimal;

public class HexCalc {
	public static void main(String[] args) {
		Operations hexaCalculation = new Operations();
		System.out.println("Addition "
				+ hexaCalculation.addHexadecimal("A", "5"));
		System.out.println("Subtraction "
				+ hexaCalculation.subtractHexadecimal("A", "5"));
		System.out.println("Multiplication "
				+ hexaCalculation.multiplyHexadecimal("A", "5"));
		System.out.println("Division "
				+ hexaCalculation.divideHexadecimal("A", "2"));
		System.out.println("A and 0A is equal:"
				+ hexaCalculation.equalHexadecimal("A", "0A"));
		System.out.println("AB and 0A is equal:"
				+ hexaCalculation.equalHexadecimal("AB", "0A"));
		System.out.println("A is greater than 0B:"
				+ hexaCalculation.greaterHexadecimal("A", "0B"));
		System.out.println("A is less than 10:"
				+ hexaCalculation.smallerHexadecimal("A", "10"));

	}
}
