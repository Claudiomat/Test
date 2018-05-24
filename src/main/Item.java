package main;

public class Item implements ItemInterface {

	private Integer quantity;
	private String name;
	private boolean isImported = false;
	private boolean isExempt = false;
	private double initialPrice;

	public Item(Integer quantity, String name, double initialPrice) {
		this.quantity = quantity;
		this.name = name;
		this.initialPrice = initialPrice;
	}
	
	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isImported() {
		return isImported;
	}

	public void setImported(boolean isImported) {
		this.isImported = isImported;
	}

	public boolean isExempted() {
		return isExempt;
	}

	public void setExempted(boolean isExempt) {
		this.isExempt = isExempt;
	}

	public double getPrice() {
		return this.initialPrice;
	}	
	
	public double getInitialPrice() {
		return this.initialPrice;
	}	

	public void setInitialPrice(double initialPrice) {
		this.initialPrice = initialPrice;
	}

	@Override
	public int hashCode() {
		return name.hashCode() + new Integer((int) (initialPrice * 100));
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