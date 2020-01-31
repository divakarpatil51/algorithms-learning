package com.hashtable.problems;

//Check Permutation: Given two strings, write a method to decide if one is a permutation of the
//other
//#84, #122, #131
public class StringPermutationChecker {

	public static void main(String[] args) {
		// s = abcd
		// a = cbda
		// Questions:
		// Is string all small case?
		// If not, a == A ??

		// Approaches:
		// BCR --> O(n) --> we will got thru both the strings (both should have same length for permutation)
		// Searching --> we will have to perform sorting first which is O(n log n) > O(n)
		// Hashtable
		System.out.println(arePermutedUsingNormal("abcdefghijk", "jkiafedhgbz"));
	}

	private static boolean arePermutedUsingNormal(String str1, String str2) {
		int sum1 = 0;
		int sum2 = 0;

		if (str1.length() != str2.length()) {
			return false;
		}

		for (int i = 0; i < str1.length(); i++) {
			sum1 += str1.charAt(i);
		}

		for (int i = 0; i < str2.length(); i++) {
			sum2 += str2.charAt(i);
		}

		return sum1 == sum2;
	}
}
