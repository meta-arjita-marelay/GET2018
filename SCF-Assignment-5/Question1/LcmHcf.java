package Question1;

/**
 * 
 * this class contains method which will calculate HCF and LCM of two numbers
 * 
 * @author Arjita
 *
 */
public class LcmHcf {
	/**
	 * This function calculate HCF of two numbers
	 * 
	 * @param value1
	 *            first input value
	 * @param value2
	 *            second input value
	 * @return HCF of first and second number
	 */
	public static int calculateHCF(int value1, int value2) {
		// check if second value is zero then return first value
		if (value2 != 0) {
			return calculateHCF(value2, value1 % value2);
		}

		return value1;
	}

	/**
	 * This function calculate LCM of two numbers
	 * 
	 * @param value1
	 *            first input value
	 * @param value2
	 *            second input value
	 * @return LCM of two numbers
	 */
	public static int calculateLCM(int value1, int value2) {
		// calculate HCF of both numbers
		int hcf = calculateHCF(value1, value2);
		int lcm = (value1 * value2) / hcf;
		return lcm;
	}
}
