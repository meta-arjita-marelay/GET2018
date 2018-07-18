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
	}
}
