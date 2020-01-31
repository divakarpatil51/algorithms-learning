package com.hashtable.problems;

//Implement an algorithm to determine if a string has all unique characters. What if you
//cannot use additional data structures?
public class UniqueStringValues {

	public static void main(String[] args) {
		// Questions:
		// 1. Are all small letters?
		// 2. If not, is a == A?
		String nonUnique = "aaaa";
		String unique = "abcd";
		System.out.println(worstWayUnique(nonUnique));
		System.out.println(worstWayUnique(unique));

		System.out.println(bestWayUnique(nonUnique));
		System.out.println(bestWayUnique(unique));
	}

	/**
	 * Time Complexity: O(n^2- n) = O(n^2)
	 * 
	 * @param string
	 * @return
	 */
	private static boolean worstWayUnique(String string) {
		char[] charArr = string.toCharArray();
		for (int i = 0; i < charArr.length; i++) { // O(n)
			for (int j = i + 1; j < charArr.length; j++) { // O(n-1)
				if (charArr[i] == charArr[j]) {
					return false;
				}
			}
		}

		return true;
	}

	/**
	 * BCR: O(n) --> bcz we will have to go thru all the elements Will sorting work?
	 * -- Yes, but sorting is O(nlogn) which is > O(n). Hence, do not sort Will
	 * searching work? -- but we will need to sort first which is not feasible. Lets
	 * try with hash table --> time complexity O(n)
	 * 
	 * @param string
	 * @return
	 */
	private static boolean bestWayUnique(String string) {
		char[] charArr = string.toCharArray();
		int[] freq = new int[26];
		for (int i = 0; i < charArr.length; i++) { //O(n)
			int index = hashValue(charArr[i]);
			freq[index]++;
		}
		for (int i = 0; i < freq.length; i++) { //O(26)
			if (freq[i] > 1) {
				return false;
			}
		}
		// O(n + 26) ===> O(n)
		return true;
	}

	private static int hashValue(char c) {
		return c - 'a';
	}
}
