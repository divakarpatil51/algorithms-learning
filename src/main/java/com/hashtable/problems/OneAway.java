package com.hashtable.problems;

//There are three types of edits that can be performed on strings: insert a character,
//remove a character, or replace a character. Given two strings, write a function to check if they are
//one edit (or zero edits) away.
public class OneAway {

	public static void main(String[] args) {
		System.out.println(isMaximumOneAway("geak", "geek"));
	}

	private static boolean isMaximumOneAway(String string, String string2) {
		if (Math.abs(string.length() - string2.length()) > 1) {
			return false;
		}

		int[] arr = new int[256];
		for (int i = 0; i < string.length(); i++) {
			arr[string.charAt(i)]++;
		}

		for (int i = 0; i < string2.length(); i++) {
			arr[string2.charAt(i)]++;
		}
		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			if((arr[i] & 1) != 0) {
				count++;
			}
		}
		return count <= 2;
	}
}
