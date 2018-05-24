package main;

public interface Item {

	Integer getQuantity();
	String getName();
	boolean isImported();
	boolean isExempted();
	double getInitialPrice();
	double getPrice();
	
}