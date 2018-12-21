package com.thy.loyalty.ms.common.operations;

public class Utils {

	// Turkce karakterleri temizleyip tum karakterli buyuk harfe cevirir.
	public static String toUpperCaseEnglish(String temp) {
		if (!CommonJava.strEqualNullOrEmpty(temp)) {
			temp = temp.replace((char) 214, (char) 79);
			temp = temp.replace((char) 246, (char) 79);
			// change to U
			temp = temp.replace((char) 220, (char) 85);
			temp = temp.replace((char) 252, (char) 85);
			// change to I
			temp = temp.replace((char) 305, (char) 73);
			temp = temp.replace((char) 304, (char) 73);
			temp = temp.replace((char) 105, (char) 73);
			// change to G
			temp = temp.replace((char) 286, (char) 71);
			temp = temp.replace((char) 287, (char) 71);
			// change to S
			temp = temp.replace((char) 350, (char) 83);
			temp = temp.replace((char) 351, (char) 83);
			// change to C
			temp = temp.replace((char) 199, (char) 67);
			temp = temp.replace((char) 231, (char) 67);

			temp = temp.toUpperCase();

			return temp;
		}
		return "";
	}
	
	/**
	 * @param input
	 * @return
	 * 
	 *         Input olarak gelen string bos ise true doner.
	 */
	public static boolean isEmptyString(String input) {
		if (input == null)
			return true;
		else if (input.trim().equals(""))
			return true;
		else
			return false;
	}
	
	// input null ise ya da bos ise, preferential parametreyi geri doner.
	public static String nvl(String input, String preferential) {

		if (input == null || input.trim().length() == 0) {
			return preferential;
		}
		return input;
	}
	
	/**
	 * Adds thousands separator to the input. If the input is not numeric,
	 * returns the input back.
	 * 
	 * @param input
	 * @return
	 */
	public static String formatCurrency(String input) {
		String output = "";
		String decimalPoints = "";
		String sign = "";

		if (input == null) {
			return "0";
		}

		// check if input is a number
		try {
			double check = Double.parseDouble(input);
		} catch (NumberFormatException e) {
			// if the input is not a number then return input;
			return input;
		}
		// keep the sign of the input
		if (input.substring(0, 1).equals("+")
				|| input.substring(0, 1).equals("-")) {
			sign = input.substring(0, 1);
			input = input.substring(1);
		}
		// keep the decimal points of the input
		if (input.indexOf(',') > 0) {
			decimalPoints = input.substring(input.indexOf(","));
			input = input.substring(0, input.indexOf(","));
		}

		// if there is already points remove them
		String temp = "";
		if (input.indexOf(".") > 0) {
			for (int i = 0; i < input.length(); i++) {
				if (input.charAt(i) != '.')
					temp += input.charAt(i);
			}
			input = temp;
		}

		// format input
		while (input.length() > 0) {
			if (input.length() > 3) {
				if (input.length() % 3 == 0) {
					output = output + input.substring(0, 3) + ".";
					input = input.substring(3);
				} else if (input.length() % 3 == 1) {
					output = output + input.substring(0, 1) + ".";
					input = input.substring(1);
				} else if (input.length() % 3 == 2) {
					output = output + input.substring(0, 2) + ".";
					input = input.substring(2);
				}
			} else {
				output = output + input;
				input = "";
			}
		}
		// add sign and decimal points again
		output = sign + output + decimalPoints;
		// return
		return output;
	}

}
