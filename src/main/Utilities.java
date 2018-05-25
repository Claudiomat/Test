package main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Utilities {

	private static List<ShopBasket> shopBasketList = null;
	private static Set<String> ItemsToExempt = null;
	private static String patternRegularExp = "(\\d+)\\s((\\w+\\s)+)at\\s(\\d+.\\d+)"; 	
	
	public static double adjust(double value) {
		
		BigDecimal temp = new BigDecimal(Math.ceil(value * 20)/20);
		double toRet = temp.setScale(2,RoundingMode.HALF_UP).doubleValue();

		return toRet;
	}

	public static String getPatternRegularExp() {
		return patternRegularExp;
	}

	public static double roundPrice(double value) {

		BigDecimal temp = new BigDecimal(value);
		double toRet = temp.setScale(2, RoundingMode.HALF_UP).doubleValue();

		return toRet;
	}
	
	static	{
		ItemsToExempt = new HashSet<String>();
		ItemsToExempt.add("book");
		ItemsToExempt.add("pills");
		ItemsToExempt.add("headache pills");
		ItemsToExempt.add("chocolate");
		ItemsToExempt.add("chocolate bar");
		ItemsToExempt.add("box of chocolates");
		ItemsToExempt.add("packet of headache pills");
		ItemsToExempt.add("box of imported chocolates");
		ItemsToExempt.add("imported box of chocolates");
	}
	
	public static boolean isExempted(String name) {
		return ItemsToExempt.contains(name);
	}
	
	public static void initialize() {
		shopBasketList = new ArrayList<ShopBasket>();
	}
	
	public static void readFromFile(int n, String fileName) {
		ShopBasket shopBasket = new ShopBasket();
		try {
		    BufferedReader in = new BufferedReader(new FileReader(fileName));
		    String str;
		    while ((str = in.readLine()) != null) {
		    	if (FileInputParser.matches(str) && !str.isEmpty()) {
		    		shopBasket.put(FileInputParser.fileParser(str), FileInputParser.count(str)); 
		    	} else if (!str.isEmpty()) {
		    		System.out.println("unknown line format: " + str);
		    	}
		    }
		    in.close();
		} catch (IOException e) {
			System.out.println("error:" + e.getMessage());
			return;
		}

		shopBasketList.add(shopBasket);
		printBasketInput(n, shopBasket);
	}
	
	public static void printBasketInput(int n, ShopBasket shopBasket) {
		shopBasket.printInput(n);
	}
	
	public static void printBasketOutput() {
		int n=0;
		for (ShopBasket shopBasket : shopBasketList) {
			n++;
			shopBasket.printOutput(n);
		}
	}
	
}