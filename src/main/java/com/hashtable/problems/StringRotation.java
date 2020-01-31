package com.hashtable.problems;

public class StringRotation {

	public static void main(String[] args) {
		System.out.println(isRotation("waterbottle", "bottlewater"));
	}

	private static boolean isRotation(String string, String string2) {
		if(string.length() != string2.length()) {
			return false;
		}
		
		String s1 = string + string;
		return isSubString(s1, string2);
	}

	private static boolean isSubString(String s1, String string2) {
		return s1.contains(string2);
	}
	
}
