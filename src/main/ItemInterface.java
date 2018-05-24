package main;

public interface ItemInterface {

	Integer getQuantity();
	String getName();
	boolean isImported();
	boolean isExempted();
	double getInitialPrice();
	double getPrice();
	
}