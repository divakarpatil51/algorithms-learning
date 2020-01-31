package com.hashtable.problems;

//Implement a method to perform basic string compression using the counts
//of repeated characters. For example, the string aabcccccaaa would become a2blc5a3
public class StringCompression {

	public static void main(String[] args) {
		System.out.println(compressString("aabcccccaaa"));
	}

	private static String compressString(String stringToBeCompressed) {
		int count = 1;
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < stringToBeCompressed.length() - 1; i++) {
			if (stringToBeCompressed.charAt(i) != stringToBeCompressed.charAt(i + 1)) {
				builder.append(stringToBeCompressed.charAt(i));
				builder.append(count);
				count = 1;
			}else {
				count += 1;
			}
		}
		builder.append(stringToBeCompressed.charAt(stringToBeCompressed.length()-1));
		builder.append(count);
		return builder.toString();
	}
}