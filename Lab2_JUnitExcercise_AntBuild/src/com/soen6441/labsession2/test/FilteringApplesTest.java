package com.soen6441.labsession2.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import com.soen6441.labsession2.main.FilteringApples;
import com.soen6441.labsession2.main.FilteringApples.Apple;

public class FilteringApplesTest {

static List<Apple> inventory;
	
	@BeforeClass
	public static void beforeClassMethod(){
		inventory = Arrays.asList(new Apple(80,"green"),
                new Apple(155, "green"),
                new Apple(120, "red"),
                new Apple(20, "brown"),
                new Apple(90, "brown"));	
	}
	
	@Test
	public void testSetWeight(){
		inventory.get(0).setWeight(100);
		Integer expected = 100;
		assertEquals(expected, inventory.get(0).getWeight());
	}
	
	@Test
	public void testSetColor(){
		inventory.get(2).setColor("yellow");
		assertEquals("yellow", inventory.get(2).getColor());
	}
	
	@Test
	public void testToStringApple(){
		assertEquals("Apple{color='green', weight=155}", inventory.get(1).toString());
	}
	
	
	@Test
	public void testIsGreenApple_basicPositiveCase() {
		assertTrue(FilteringApples.isGreenApple(inventory.get(0)));
	}
	
	@Test
	public void testIsGreenApple_basicNegativeCase() {
		assertFalse(FilteringApples.isGreenApple(inventory.get(2)));
	}
	
	@Test
	public void testIsHeavyApple_basicPositiveCase(){
		assertTrue(FilteringApples.isHeavyApple(inventory.get(1)));
	}
	
	@Test
	public void testIsHeavyApple_basicNegativeCase(){
		assertFalse(FilteringApples.isHeavyApple(inventory.get(2)));
	}
	
	@Test
	public void testfilterGreenApples(){
		assertEquals(2, FilteringApples.filterGreenApples(inventory).size());
	}
	
	@Test
	public void testfilterHeavyApples(){
		assertEquals(1, FilteringApples.filterHeavyApples(inventory).size());
	}
	
	@Test
	public void testfilteringApples_checkforGreenApples(){
		 // [Apple{color='green', weight=80}, Apple{color='green', weight=155}]
        assertEquals(2, FilteringApples.filterApples(inventory, FilteringApples::isGreenApple).size());
	}
	
	@Test
	public void testfilteringApples_checkforHeavyApples(){
        // [Apple{color='green', weight=155}]
        assertEquals(1, FilteringApples.filterApples(inventory, FilteringApples::isHeavyApple).size());
	}
	
	@Test
	public void testfilteringApples_checkforPredicate1(){
		 // [Apple{color='green', weight=80}, Apple{color='green', weight=155}]
		assertEquals(2, FilteringApples.filterApples(inventory, (Apple a) -> "green".equals(a.getColor())).size());
	}
	
	@Test
	public void testfilteringApples_checkforPredicate2(){
		// [Apple{color='green', weight=155}]
		 assertEquals(1, FilteringApples.filterApples(inventory, (Apple a) -> a.getWeight() > 150).size());
	}
	
	@Test
	public void testfilteringApples_checkforWeirdApples(){
		//[]
        assertEquals(2, FilteringApples.filterApples(inventory, (Apple a) -> a.getWeight() < 80 || 
                "brown".equals(a.getColor())).size());
	}
}
