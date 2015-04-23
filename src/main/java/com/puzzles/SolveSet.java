package com.puzzles;

import org.junit.Test;


public class SolveSet {
	
	@Test
	public void testone()
	{
			String toRevers = "abcde";
			char[] letters = toRevers.toCharArray();
			for(int i=0;i<letters.length/2;i++)
			{
				
				swap(letters,i,letters.length-i-1);
			}
			System.out.println(letters);
			String result = reverseString("24gsfg342tgadfa42");
			System.out.println("Recursion --- "+ result);
		
	}

	private void swap(char[] letters, int i, int j) {
		
		System.out.print(letters);
		System.out.println(" :: "+letters[i] +" , "+letters[j]);
		
		char temp = letters[i];
		letters[i]= letters[j];
		letters[j] = temp;
		
	}
	
	private String reverseString(String input)
	{
		String result;
		if(input.length() == 1)
		{	
			return input ;
		}	
		
		String last = input.substring(input.length()-1);
		input = input.substring(0,input.length()-1);
		result = last + reverseString(input);
		return result;
	}
	
	@Test
	public void testdulplicate()
	{
		String test = "abcdefghijkl-";
		byte onebyte = 119;
		System.out.println(Integer.toBinaryString(onebyte));
		for(char letter:test.toCharArray())
		{
			int ascii = letter;
			byte bits = (byte) letter;
			System.out.println(letter + " bit rep :: "+bits);
			System.out.println(letter + " :: "+ascii);
			System.out.println(Integer.toBinaryString(ascii));
			
		}
		
		
		
	}

}
