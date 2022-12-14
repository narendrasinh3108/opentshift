public class Product{
	private String name;
	private int stockLevel;
	private double price;
	
	public Product(String name, int stockLevel, double price) {
		super();
		this.name = name;
		this.stockLevel = stockLevel;
		this.price = price;
	}
	
	public String getName() {
		return name;
	}

	public int getStockLevel() {
		return stockLevel;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double newPrice) {
		this.price = newPrice;
	}

	public double buyStock(int newStock) {
		stockLevel+=newStock;
		return newStock*price;
	}
	
	public boolean sell(int sellItems) {
		if(stockLevel>=sellItems) {
			stockLevel-=sellItems;
			return true;
		}
		return false;
	}

	@Override
	public String toString() {
		return "ProductName=" + name + ", StockLevel=" + stockLevel + ", Price=" + price;
	}
	
	
}