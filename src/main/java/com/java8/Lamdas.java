package com.java8;

import java.util.Comparator;

public class Lamdas {
	
	public static void main(String[] args)
	{
		Comparator<Integer> cmp = (x, y) -> (x < y) ? -1 : ((x > y) ? 1 : 0);
		System.out.println("compare 10,5 -- > " + cmp.compare(10,5));
		
		
	}

}
