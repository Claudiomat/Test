package main;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ShopBasket {
	
	public static void main(String[] args)
	{
		int n=0;
		
		Utilities.initialize();
    	System.out.println("INPUT");
    	System.out.println();
	    for (String fileName: args) {
	    	n++;
	    	Utilities.readFromFile(n, fileName);
	    }
    	System.out.println("OUTPUT");
    	System.out.println();
	    Utilities.printBasketOutput();
	}

	private final Map<Item, Integer> itemsMap = new HashMap<Item, Integer>();
	public Set<Item> getItems() {
		return itemsMap.keySet();
	}
	
	public int getQuantity(Item item){
		return itemsMap.get(item);	
	}

	public double getTotal() {
		double total = 0;
		for (Item item : itemsMap.keySet()) {		
			double subTotal = item.getPrice() * getQuantity(item);
			total += subTotal;
		}
		return Utilities.roundPrice(total);
	}
	
	public double getTotalWithTaxes() {
		double taxtotal = 0;
		for (Item item : itemsMap.keySet()) {		
			double subTotal = item.getPrice() * getQuantity(item);
			double subInitTotal = item.getInitialPrice() * getQuantity(item);
			taxtotal += subTotal - subInitTotal;
		}
		return taxtotal;
	}
	
	public void put (Item item, int count){
		if (!item.isExempted()) {
			item = new SalesTaxedItem(item);
		}
		if (item.isImported()) {
			item = new ImportedTaxedItem(item);
		}
		Integer i = this.itemsMap.get(item); 
		if ( i!= null) {
			count += i;
		}
		this.itemsMap.put(item, count);
	}	
	
	public void remove (Item item) {
		this.itemsMap.remove(item);
	}
	
	public void clear () {
		this.itemsMap.clear();
	}

	public void printInput(int n) {
		DecimalFormat df = new DecimalFormat("##.00");
		System.out.println("Input " + n + ":");
		for ( Item item : itemsMap.keySet() ){
			System.out.println(itemsMap.get(item) + " " + item.getName() + " at " + df.format(item.getInitialPrice()));
		}	
		System.out.println();
	}
	
	public void printOutput(int n) {	
		DecimalFormat df = new DecimalFormat("##.00");
		double taxtotal = 0;
		double total = 0;
		System.out.println("Output " + n + ":");
		Set<Item> taxedItems = itemsMap.keySet();
		for (Item item : taxedItems){		
			double subTotal = item.getPrice() * getQuantity(item);
			double subInitTotal = item.getInitialPrice() * getQuantity(item);
			taxtotal += subTotal - subInitTotal;
			total += subTotal;
			System.out.println(getQuantity(item) + " " + item.getName() + ": " + df.format(subTotal));
		}
		total = Utilities.roundPrice(total);
		System.out.println("Sales Taxes: "+df.format(taxtotal));
		System.out.println("Total: "+df.format(total));
		System.out.println();
	}


}
