package com.java8;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class CollectionsTest {
	
	private static List<String> tags = new ArrayList<>();
	static
	{
		tags.add("Java");
		tags.add("JavaScripts");
		tags.add("Ruby");
		tags.add("Python");
		tags.add("C");
		tags.add("C++");
		tags.add("Scala");
		tags.add("R");
		tags.add("Lisp");
		
	}
	
	class Innertemp{		
		private List<String> tags;
		public List<String> getTags() {
			return tags;
		}

		public void setTags(List<String> tags) {
			this.tags = tags;
		}

		
		
		
	}
	
	
	@Test
	public void testIter()
	{
		System.out.println(tags.contains("Subash"));
		
		System.out.println(tags.stream().filter(item->item.length()>4).count());
		tags.stream().filter(item->item.length()>4);
		System.out.println();
		
//		for(String item:tags)
//		{
//			
//			
//		}
	}

}
