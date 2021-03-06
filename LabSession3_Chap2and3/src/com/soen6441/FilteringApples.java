//Task #3
package com.soen6441;

import java.util.*;

public class FilteringApples{

	public static void main(String ... args){

		List<Apple> inventory = Arrays.asList(new Apple(80,"green"), new Apple(155, "green"), new Apple(120, "red"));	

		// [Apple{color='green', weight=80}, Apple{color='green', weight=155}]
		List<Apple> greenApples = filterApplesByColor(inventory, "green");
		System.out.println(greenApples);

		// [Apple{color='red', weight=120}]
		List<Apple> redApples = filterApplesByColor(inventory, "red");
		System.out.println(redApples);

		// [Apple{color='green', weight=80}, Apple{color='green', weight=155}]
		List<Apple> greenApples2 = filter(inventory, new AppleColorPredicate());
		System.out.println(greenApples2);

		// [Apple{color='green', weight=155}]
		List<Apple> heavyApples = filter(inventory, new AppleWeightPredicate());
		System.out.println(heavyApples);

		// []
		List<Apple> redAndHeavyApples = filter(inventory, new AppleRedAndHeavyPredicate());
		System.out.println(redAndHeavyApples);

		// [Apple{color='red', weight=120}]
		List<Apple> redApples2 = filter(inventory, new ApplePredicate() {
			public boolean test(Apple a){
				return a.getColor().equals("red"); 
			}
		});
		System.out.println(redApples2);
		
		prettyPrintApple(inventory, new AppleWeightDisplay());
		prettyPrintApple(inventory, new AppleColorDisplay());
		prettyPrintApple(inventory, new ClassifyAppleByWeightDisplay());
	}

	/*public static List<Apple> filterGreenApples(List<Apple> inventory){
		List<Apple> result = new ArrayList<>();
		for(Apple apple: inventory){
			if("green".equals(apple.getColor())){
				result.add(apple);
			}
		}
		return result;
	}*/

	//red->1 apple //blue->none
	public static List<Apple> filterApplesByColor(List<Apple> inventory, String color){
		List<Apple> result = new ArrayList<>();
		for(Apple apple: inventory){
			if(apple.getColor().equals(color)){
				result.add(apple);
			}
		}
		return result;
	}

	/*public static List<Apple> filterApplesByWeight(List<Apple> inventory, int weight){
		List<Apple> result = new ArrayList<>();
		for(Apple apple: inventory){
			if(apple.getWeight() > weight){
				result.add(apple);
			}
		}
		return result;
	}*/

	//AppleWeightPredicate -> 1
	//AppleColorPredicate -> 2
	//AppleRedAndHeavyPredicate -> 0
	public static List<Apple> filter(List<Apple> inventory, ApplePredicate p){
		List<Apple> result = new ArrayList<>();
		for(Apple apple : inventory){
			if(p.test(apple)){
				result.add(apple);
			}
		}
		return result;
	}       

	//AppleWeightDisplay -> "weight="+a.getWeight().toString();
	//AppleColorDisplay -> "color="+a.getColor();
	//ClassifyAppleByWeightDisplay -> "heavy apple: "+a.toString(); for 1, "light apple: "+a.toString(); for 2  
	public static void prettyPrintApple(List<Apple> inventory, AppleFormatter appleFormatter){
	    for(Apple apple: inventory) {
		String output = appleFormatter.display(apple);
		System.out.println(output);
	    }
	}
	
	public static class Apple {
		private int weight = 0;
		private String color = "";

		public Apple(int weight, String color){
			this.weight = weight;
			this.color = color;
		}

		public Integer getWeight() {
			return weight;
		}

		public void setWeight(Integer weight) {
			this.weight = weight;
		}

		public String getColor() {
			return color;
		}

		public void setColor(String color) {
			this.color = color;
		}

		public String toString() {
			return "Apple{" +
					"color='" + color + '\'' +
					", weight=" + weight +
					'}';
		}
	}

	interface ApplePredicate{
		public boolean test(Apple a);
	}

	interface AppleFormatter{
		public String display(Apple a);
	}
	
	public static class AppleWeightDisplay implements AppleFormatter{
		@Override
		public String display(Apple a) {
			return "weight="+a.getWeight().toString();
		}
	}
	
	static class AppleColorDisplay implements AppleFormatter{
		@Override
		public String display(Apple a) {
			return "color="+a.getColor();
		}
	}
	
	static class ClassifyAppleByWeightDisplay implements AppleFormatter{
		@Override
		public String display(Apple a) {
			if(a.getWeight()>150)
				return "heavy apple: "+a.toString();
			
			return "light apple: "+a.toString();
			
		}
	}
	
	public static class AppleWeightPredicate implements ApplePredicate{
		public boolean test(Apple apple){
			return apple.getWeight() > 150; 
		}
	}
	public static class AppleColorPredicate implements ApplePredicate{
		public boolean test(Apple apple){
			return "green".equals(apple.getColor());
		}
	}

	public static class AppleRedAndHeavyPredicate implements ApplePredicate{
		public boolean test(Apple apple){
			return "red".equals(apple.getColor()) 
					&& apple.getWeight() > 150; 
		}
	}
	
	
	
	
}