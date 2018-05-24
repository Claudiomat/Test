package main;

public class SalesTaxedItem extends TaxedItem {

	final double TAX_RATE = 0.1;
	
	private ItemInterface taxedItem;

	public SalesTaxedItem(ItemInterface item) {
		super(item);
		this.taxedItem = item;
	}

	@Override
	double getTaxRate() {
		return this.TAX_RATE;
	}
	
	public boolean isImported() {
		return taxedItem.isImported();
	}

	@Override
	public boolean isExempted() {
		return taxedItem.isExempted();
	}
	
	@Override
	public Integer getQuantity() {
		return taxedItem.getQuantity();
	}

	public String getName() {
		return taxedItem.getName();
	}

	public double getInitialPrice() {
		return taxedItem.getInitialPrice();
	}

	@Override
	public int hashCode() {
		return this.getName().hashCode();
	}

	@Override
	public boolean equals(Object obj) {

		if (obj == null) {
			return false;
		} else if (obj instanceof ItemInterface) {
			return (((ItemInterface) obj).hashCode() == this.hashCode());

		} else
			return false;
	}

}