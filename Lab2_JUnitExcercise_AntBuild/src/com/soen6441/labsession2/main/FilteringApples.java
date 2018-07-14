package com.soen6441.labsession2.main;

import java.util.*;
import java.util.function.Predicate;

/**
 * Filters Apples based on different attributes
 * @author Kritika_2
 *
 */
public class FilteringApples{

	/**
	 * Creates an inventory of apples with different attributes
	 * @param args
	 */
    public static void main(String ... args){
        List<Apple> inventory = Arrays.asList(new Apple(80,"green"),
                                              new Apple(155, "green"),
                                              new Apple(120, "red"));	

        // [Apple{color='green', weight=80}, Apple{color='green', weight=155}]
        List<Apple> greenApples = filterApples(inventory, FilteringApples::isGreenApple);
        System.out.println(greenApples);
        
        // [Apple{color='green', weight=155}]
        List<Apple> heavyApples = filterApples(inventory, FilteringApples::isHeavyApple);
        System.out.println(heavyApples);
        
        // [Apple{color='green', weight=80}, Apple{color='green', weight=155}]
        List<Apple> greenApples2 = filterApples(inventory, (Apple a) -> "green".equals(a.getColor()));
        System.out.println(greenApples2);
        
        // [Apple{color='green', weight=155}]
        List<Apple> heavyApples2 = filterApples(inventory, (Apple a) -> a.getWeight() > 150);
        System.out.println(heavyApples2);
        
        // []
        List<Apple> weirdApples = filterApples(inventory, (Apple a) -> a.getWeight() < 80 || 
                                                                       "brown".equals(a.getColor()));
        System.out.println(weirdApples);
    }

    /**
     * Filters apples that are green in color
     * @param inventory of Apples
     * @return ArrayList of Apples that are green
     *   */
    public static List<Apple> filterGreenApples(List<Apple> inventory){
        List<Apple> result = new ArrayList<>();
        for (Apple apple: inventory){
            if ("green".equals(apple.getColor())) {
                result.add(apple);
            }
        }
        return result;
    }

    /**
     * Filters apples more than 150kg in weight
     * @param inventory of Apples
     * @return ArrayList of Apples that are heavy 
     */
    public static List<Apple> filterHeavyApples(List<Apple> inventory){
        List<Apple> result = new ArrayList<>();
        for (Apple apple: inventory){
            if (apple.getWeight() > 150) {
                result.add(apple);
            }
        }
        return result;
    }

    //apple1("green", 20)=> true, apple2("red", 150)=> false 
    /**
     * Checks if the apple is green or not
     * @param apple an object of type Apple 
     * @return boolean value depending on the color of the apple
     */
    public static boolean isGreenApple(Apple apple) {
        return "green".equals(apple.getColor()); 
    }

    //apple1("green", 150)=> false, apple2("green", 151)=> true 
    /**
     * Checks if the weight of an apple is greater than 150kg or not
     * @param apple object of type Apple
     * @return boolean value depending on the weight of the apple
     */
    public static boolean isHeavyApple(Apple apple) {
        return apple.getWeight() > 150;
    }

    /**
     * Filters apples based on the attribute defined by predicate
     * @param inventory of Apples
     * @param p Predicate tells the property to filter the apples
     * @return ArrayList of Apples filtered based on the predicate p
     */
    public static List<Apple> filterApples(List<Apple> inventory, Predicate<Apple> p){
        List<Apple> result = new ArrayList<>();
        for(Apple apple : inventory){
            if(p.test(apple)){
                result.add(apple);
            }
        }
        return result;
    }       

    /**
     * Creates Apple objects 
     * @author Kritika_2
     *
     */
    public static class Apple {
        private int weight = 0;
        private String color = "";

        /**
         * Constructs an apple object and sets its weight and color
         * @param weight 
         * @param color 
         */
        public Apple(int weight, String color){
            this.weight = weight;
            this.color = color;
        }

        /**
         * Gets weight of an apple
         * @return weight 
         */
        public Integer getWeight() {
            return weight;
        }

        /**
         * Sets weight of an apple
         * @param weight 
         */
        public void setWeight(Integer weight) {
            this.weight = weight;
        }

        /**
         * Gets color of an apple
         * @return color 
         */
        public String getColor() {
            return color;
        }

        /**
         * Sets color of an apple
         * @param color
         */
        public void setColor(String color) {
            this.color = color;
        }

        /**
         * Converts an apple object to a String
         * @return apple object as a String
         */
        public String toString() {
            return "Apple{" +
                   "color='" + color + '\'' +
                   ", weight=" + weight +
                   '}';
        }
    }

}
