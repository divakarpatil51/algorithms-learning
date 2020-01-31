package com.hashtable.problems;

//Write a method to replace all spaces in a string with '%20'.
public class Urlify {

	public static void main(String[] args) {
		System.out.println(urlify("Mr. Smith has    ", 13));
	}

	private static String urlify(String string, int trueLength) {
		char[] charArr = new char[string.length()];
		int index = charArr.length - 1;
		for (int i = trueLength - 1; i >= 0; --i) {
			char currentChar = string.charAt(i);
			if (currentChar == ' ') {
				charArr[index] = '0';
				charArr[index - 1] = '2';
				charArr[index - 2] = '%';
				index -= 3;
			} else {
				charArr[index] = currentChar;
				index--;
			}
		}

		return new String(charArr);
	}
}
