// Code Started
import java.util.Scanner;
import java.util.regex.Pattern;

public class uniqueDigitsOfLargeNumber {

	public static String replaceDuplicate(String input, int length) {

		char start;
		int upperLimit = 0, searchIndex = 0;

		StringBuffer modifiedString = new StringBuffer(input);
		for (int i = 0; i < length; i++) {
			start = input.charAt(i);
			searchIndex = 0;
			upperLimit = 0;
			if (start != '*') {
				upperLimit = i + 1;
				searchIndex = input.indexOf(start, upperLimit);
				while (searchIndex > 0) {
					modifiedString.setCharAt(searchIndex, '*');
					upperLimit = searchIndex + 1;
					searchIndex = input.indexOf(start, upperLimit);
				}
			}
		}
		return modifiedString.toString();
	}

	private static char findMax(String str) {
		int max = -1;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) != '#') {
				if (str.charAt(i) > max) {
					max = str.charAt(i);
				}
			}
		}
		return (char) max;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		/*
		 * Given a large Number (n>0). You need to print the unique digits present in
		 * the number n, and the largest number possible using these unique digits.
		 * (Array not to be used)
		 */
		System.out.println("*****************************************");
		System.out.println("Please Input a Number");

		String inputNumber = sc.next();
		System.out.println("*****************************************");
		System.out.println("Your Input is : " + inputNumber);
		System.out.println("*****************************************");

		if (!Pattern.matches("[0-9]+", inputNumber)) {
			System.out.println("Please Enter Numeric Value only");
		} else {

			/* 1st Part - Eliminating Duplicate Elements by Replacing it with (*) */
			String firstOutput = replaceDuplicate(inputNumber, inputNumber.length());
			System.out.println("*****************************************");
			System.out.println("First Part Output = " + firstOutput);

			String uniqueElements = firstOutput.replaceAll("\\*", "");
			System.out.println("Unique Elements = " + uniqueElements);
			System.out.println("*****************************************");

			/*
			 * 2nd Part - find Largest Possible number from unique digits found previously
			 * by appending it to variable(lrg) rest Replace it with (#)
			 */
			String lrg = "";
			String str = uniqueElements;
			char max;
			for (int i = 0; i < str.length(); i++) {
				max = findMax(str);
				str = str.replace(max, '#');
				lrg += max;
			}

			System.out.println("*****************************************");
			System.out.println("Second Part Output[Largest Number] = " + lrg);
			System.out.println("Second part Output[String] = " + str);
			System.out.println("*****************************************");

			long finalOutput = Long.parseLong(lrg);
			System.out.println("*****************************************");
			System.out.println("Final Output : " + finalOutput);
			System.out.println("*****************************************");
		}
		
		sc.close();
	}

}
