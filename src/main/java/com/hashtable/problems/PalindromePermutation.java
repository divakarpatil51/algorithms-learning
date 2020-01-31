package com.hashtable.problems;

public class PalindromePermutation {

	public static void main(String[] args) {
		System.out.println(canPermutePalindrome("tactcoa"));
	}
	
	private static boolean canPermutePalindrome(String s) {
        int[] map = new int[128];
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            map[s.charAt(i)]++;
            if (map[s.charAt(i)] % 2 == 0)
                count--;
            else
                count++;
        }
        System.out.println(count);
        return count <= 1;
    }
}
