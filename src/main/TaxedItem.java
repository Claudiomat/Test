package main;

public abstract class TaxedItem implements ItemInterface {

	public ItemInterface item;
	public double rate;

	public TaxedItem(ItemInterface item) {
		this.item = item;
	}

	public double getPrice(){
		double salesTax = Utilities.adjust(this.getTaxRate() * this.item.getInitialPrice());
		return Utilities.roundPrice(this.item.getPrice() + salesTax);
	}
	
	abstract double getTaxRate();
}