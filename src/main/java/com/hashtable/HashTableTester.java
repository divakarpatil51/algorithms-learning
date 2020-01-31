package com.hashtable;

public class HashTableTester {

	public static void main(String[] args) {
		LinkedHashTable<String, String> hashTable = new LinkedHashTable<>();
		
		hashTable.put("divakar", "patil");
		hashTable.put("divakar", "new");
		hashTable.put(null, "null1");
		hashTable.put(null, "null2");
		System.out.println(hashTable.get("divakar"));
		System.out.println(hashTable.get(null));
	}
}
