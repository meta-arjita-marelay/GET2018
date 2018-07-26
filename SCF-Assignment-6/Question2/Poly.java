package Question2;

/**
 * Poly contains function which will perform different operations on polynomial
 * like evaluating the value of polynomial,calculating the degree the
 * polynomial, addition of two polynomial and multiplication of two polynomial
 * 
 * @author Arjita
 *
 */
public class Poly {
	private final int[][] polynomial;

	/**
	 * Poly constructor will initialise the private variable of class
	 * 
	 * @param polynomial
	 *            array to initialise the private member of class
	 */
	public Poly(int[][] polynomial) {
		this.polynomial = polynomial;
	}

	/**
	 * getter method for private member of class
	 * 
	 * @return return the polynomial array of class
	 */
	public int[][] getPolynomial() {
		return polynomial;
	}

	/**
	 * evaluate the value of polynomial according to the given value
	 * 
	 * @param value
	 *            input value for calculating the value of function
	 * @return value of polynomial for given value of variable
	 */
	public float evaluate(float value) {
		float result = 0;// store the result value
		for (int i = 0; i < polynomial.length; i++) {
			result += polynomial[i][0] * (Math.pow(value, polynomial[i][1]));
		}
		return result;
	}

	/**
	 * calculate the degree of polynomial
	 * 
	 * @return degree of polynomial
	 */
	public int degree() {
		int degree = 0;// store the degree
		for (int i = 0; i < polynomial.length; i++) {
			if (polynomial[i][1] > degree) {
				degree = polynomial[i][1];
			}
		}
		return degree;
	}

	/**
	 * addPoly will add two polynomial
	 * 
	 * @param polynomial1
	 *            object of first input polynomial
	 * @param polynomial2
	 *            object of second input polynomial
	 * @return object of addition of polynomial
	 */
	public static Poly addPoly(Poly polynomial1, Poly polynomial2) {
		int size;// size of resultant polynomial
		// size will be equal to maximum degree of both polynomial
		if (polynomial1.degree() > polynomial2.degree()) {
			size = polynomial1.degree();
		} else {
			size = polynomial2.degree();
		}
		// polyArray1 and polyArray2 will store the array of both objects
		int[][] polyArray1 = polynomial1.getPolynomial();
		int[][] polyArray2 = polynomial2.getPolynomial();
		// resultant array
		int[][] result = new int[size][2];
		int i = 0, j = 0;
		int k;
		for (k = 0; k < size && i < polyArray1.length && j < polyArray2.length; k++) {
			if (polyArray1[i][1] == polyArray2[j][1]) {
				result[k][0] = polyArray1[i][0] + polyArray2[j][0];
				result[k][1] = polyArray1[i][1];
				i++;
				j++;
			} else if (polyArray1[i][1] > polyArray2[j][1]) {
				result[k][0] = polyArray1[i][0];
				result[k][1] = polyArray1[i][1];
				i++;
			} else if (polyArray1[i][1] < polyArray2[j][1]) {
				result[k][0] = polyArray2[j][0];
				result[k][1] = polyArray2[j][1];
				j++;
			}
		}
		// check if first array elements are left
		while (i < polyArray1.length) {
			result[k][0] = polyArray1[i][0];
			result[k][1] = polyArray1[i][1];
			k++;
			i++;
		}
		// check if second array elements are left
		while (j < polyArray2.length) {
			result[k][0] = polyArray2[j][0];
			result[k][1] = polyArray2[j][1];
			k++;
			j++;
		}
		// store the result in object
		Poly polynomialResult = new Poly(result);
		polynomialResult.display();
		return polynomialResult;
	}

	/**
	 * multiplyPoly will multiply the two polynomials
	 * 
	 * @param p1
	 *            object of first input polynomial
	 * @param p2
	 *            object of second input polynomial
	 * @return object of multiplication of polynomial
	 */
	public static Poly multiplyPoly(Poly p1, Poly p2) {
		// polyArray1 and polyArray2 will store the array of both objects
		int polyArray1[][] = p1.getPolynomial();
		int polyArray2[][] = p2.getPolynomial();
		// resultant array's size will be equal to product of length of both
		// polynomials
		int resultArray[][] = new int[polyArray1.length * polyArray2.length][2];
		int k = 0;
		for (int i = 0; i < polyArray1.length; i++) {
			for (int j = 0; j < polyArray2.length; j++) {
				resultArray[k][1] = polyArray1[i][1] + polyArray2[j][1];
				// check if this power is already present in result array
				int index = powerPresent(resultArray[k][1], resultArray);
				if (index != -1) {
					resultArray[index][0] = resultArray[index][0]
							+ polyArray1[i][0] * polyArray2[j][0];
				} else {
					resultArray[k][0] = polyArray1[i][0] * polyArray2[j][0];
				}
				k++;
			}
		}
		// object of resultant array is made after reducing the array
		Poly resultPolynomial = reduce(resultArray);
		resultPolynomial.display();
		return resultPolynomial;
	}

	/**
	 * helper method to reduce the array
	 * 
	 * @param inputArray
	 *            array which is to be reduced
	 * @return array after removing the trailing zeroes coefficient
	 */
	private static Poly reduce(int inputArray[][]) {

		int j = 0;
		int zeroCoeff = 0;
		// calculation of new array's size
		for (int count = 0; count < inputArray.length; count++) {
			if (inputArray[count][0] == 0) {
				zeroCoeff++;
			}
		}
		int reduceArray[][] = new int[inputArray.length - zeroCoeff][2];
		// reducing the array
		for (int i = 0; i < inputArray.length && j < inputArray.length; i++) {
			if (inputArray[i][0] != 0) {
				reduceArray[j][0] = inputArray[i][0];
				reduceArray[j][1] = inputArray[i][1];
				j++;
			}
		}
		return new Poly(reduceArray);
	}

	/**
	 * helper method to check the if the power is present in array
	 * 
	 * @param power
	 *            which is to be searched in array
	 * @param array
	 *            2-D array in which power is to be searched
	 * @return index if that power is present otherwise -1
	 */
	private static int powerPresent(int power, int[][] array) {
		for (int i = 0; i < array.length; i++) {
			if (power == array[i][1]) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * display function to print the polynomial
	 */
	void display() {
		System.out.println();
		for (int i = 0; i < polynomial.length; i++) {
			System.out.print(polynomial[i][0] + "x^");
			System.out.print(polynomial[i][1]);
			if (i != polynomial.length - 1) {
				System.out.print("+");
			}

		}
	}
}
