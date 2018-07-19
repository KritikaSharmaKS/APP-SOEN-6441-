//Task #2
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
import com.soen6441.FilteringApples.AppleWeightPredicate;

public class FilteringApplesTest implements Comparator<Apple> {

static List<Apple> inventory, inventory2;
	
	@BeforeClass
	public static void beforeClassMethod(){
		inventory = Arrays.asList(new Apple(80,"green"), new Apple(155, "green"), new Apple(120, "red"));
		inventory2 = Arrays.asList(new Apple(80,"green"), new Apple(155, "green"), new Apple(120, "red"), new Apple(180, "red"));
	}
	
	@Test
	public void testFilterApplesByColor_ConditionWhenAppleIsPresent(){
		List<Apple> result = FilteringApples.filterApplesByColor(inventory, "red");
		for(int i=0; i<result.size(); i++)
			assertEquals(1, compare(new Apple(120, "red"), result.get(i)));
	}
	
	@Test
	public void testFilterApplesByColor_ConditionWhenAppleIsNotPresent(){
		List<Apple> result = FilteringApples.filterApplesByColor(inventory, "yellow");
		for(int i=0; i<result.size(); i++)
			assertEquals(null, result.get(i));
	}
	
	@Test 
	public void testFilter_ConditionForAppleWeightPredicate(){
		assertEquals(1, FilteringApples.filter(inventory, new FilteringApples.AppleWeightPredicate()).size());
	}
	
	@Test 
	public void testFilter_ConditionForAppleColorPredicate(){
		assertEquals(2, FilteringApples.filter(inventory, new FilteringApples.AppleColorPredicate()).size());
	}
	
	@Test 
	public void testFilter_NoneConditionForAppleRedAndHeavyPredicate(){
		assertEquals(0, FilteringApples.filter(inventory, new FilteringApples.AppleRedAndHeavyPredicate()).size());
	}
	
	@Test 
	public void testFilter_IsPresentConditionForAppleRedAndHeavyPredicate(){
		assertEquals(1, FilteringApples.filter(inventory2, new FilteringApples.AppleRedAndHeavyPredicate()).size());
	}
	
/*	@Test 
	public void testprettyPrintApple_ConditionForAppleWeightDisplay(){
		for(int i=0; i<inventory.size();i++)
			assertEquals("weight="+inventory.get(i).getWeight().toString(), FilteringApples.prettyPrintApple(inventory, new FilteringApples.AppleWeightDisplay()));
	}
	
	@Test 
	public void testprettyPrintApple_ConditionForAppleColorDisplay(){
		assertEquals(1, FilteringApples.filter(inventory2, new FilteringApples.AppleRedAndHeavyPredicate()).size());
	}
	
	@Test 
	public void testprettyPrintApple_ConditionForClassifyAppleByWeightDisplay(){
		assertEquals(1, FilteringApples.filter(inventory2, new FilteringApples.AppleRedAndHeavyPredicate()).size());
	}*/

	@Override
	public int compare(Apple o1, Apple o2) {
		return o1.getColor().equals(o2.getColor())?1:0;
	}

	
}
