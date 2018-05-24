package main;

public abstract class TaxedItem implements Item {

	public Item item;
	public double rate;

	public TaxedItem(Item item) {
		this.item = item;
	}

	public double getPrice(){
		double salesTax = Utilities.adjust(this.getTaxRate() * this.item.getInitialPrice());
		return Utilities.roundPrice(this.item.getPrice() + salesTax);
	}
	
	abstract double getTaxRate();
}