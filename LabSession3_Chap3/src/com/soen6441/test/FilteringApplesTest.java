package com.soen6441.test;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import com.soen6441.FilteringApples;
import com.soen6441.FilteringApples.Apple;

public class FilteringApplesTest implements Comparator<Apple> {

static List<Apple> inventory;
	
	@BeforeClass
	public static void beforeClassMethod(){
		inventory = Arrays.asList(new Apple(80,"green"), new Apple(155, "green"), new Apple(120, "red"));	
	}
	
	@Test
	public void testFilterApplesByColor_ConditionWhenAppleIsPresent(){
		List<Apple> result = FilteringApples.filterApplesByColor(inventory, "red");
		for(int i=0; i<result.size(); i++)
			assertEquals(1, compare(new Apple(120, "red"), result.get(i)));
	}
	
	@Test
	public void testFilterApplesByColor_ConditionWhenAppleIsNotPresent(){
		List<Apple> result = FilteringApples.filterApplesByColor(inventory, "red");
		for(int i=0; i<result.size(); i++)
			assertEquals(0, compare(new Apple(120, "yellow"), result.get(i)));
	}
	
	@Test 
	public void testFilter_C(){
		
	}
	
	

	@Override
	public int compare(Apple o1, Apple o2) {
		return o1.getColor().equals(o2.getColor())?1:0;
	}

	
}
