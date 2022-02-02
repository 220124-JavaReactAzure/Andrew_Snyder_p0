package com.revature.bankDriver.util;

public class TemporaryDriver {
	public static void main(String[] args) {
		List<String> myStringList = new LinkedList<>();
		
		myStringList.add("Hello");
		myStringList.add("There");
		myStringList.add("General");
		myStringList.add("Kenobi");
		System.out.println(myStringList.contains("Hello"));
		System.out.println(myStringList.contains("There"));
		System.out.println(myStringList.contains("General"));
		System.out.println(myStringList.contains("Kenobi"));
	}

}
