import java.util.Scanner;

public class ShopApp {
	private static Product[] product = new Product[5];
	private static int index = 0;

	public ShopApp() {
		product[0] = new Product("Tea", 10, 80.89);
		product[1] = new Product("Coffee", 10, 100.00);
		product[2] = new Product("Sempoo", 10, 40.00);
		product[3] = new Product("Mobile", 10, 15000);
		product[4] = new Product("Leptop", 10, 35000);
	}

	public void displayProducts() {
		for (int i = 0; i < product.length; i++) {
			System.out.println((i + 1) + ")  " + product[i].toString());
		}
	}

	public double buyStock(int newStock) {
		return product[index].buyStock(newStock);
	}

	public boolean sellStock(int sellItems) {
		return product[index].sell(sellItems);
	}

	public void rePrice(double newPrice) {
		product[index].setPrice(newPrice);
	}

	public double totalValue() {
		return product[index].getPrice() * product[index].getStockLevel();
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ShopApp shopApp = new ShopApp();
		boolean action = true;
		System.out.println("Please check below display Products -:");
		for (int i = 0; i < product.length; i++) {
			System.out.println((i + 1) + ")  " + product[i].getName());
		}
		System.out.println("Please check below some action you can take -:");
		System.out.println("1. Display All Products");
		System.out.println("2. Buy Stock");
		System.out.println("3. Sell Stock");
		System.out.println("4. Change the Price of Product");
		System.out.println("5. Total Value of Product");

		do {
			System.out.println("\n Please Provied the index no of action that you want to take -: ");
			int objectAction = sc.nextInt();
			if (objectAction != 1) {
				System.out.println("\n Please Select the Product by inserting the index no of Product -: ");
				index = sc.nextInt()-1;
			}

			if (objectAction == 1) {
				System.out.println("1. Display All Products -:");
				shopApp.displayProducts();
			}
			if (objectAction == 2) {
				System.out.println("2. Buy Stock of product "+product[index].getName()+" -:");
				System.out.println("\n Please insert the stock size of product -: ");
				double temp = shopApp.buyStock(sc.nextInt());
				System.out.println("Successful... \n The Value of your new buy stock is "+ temp);

			}
			if (objectAction == 3) {
				System.out.println("3. Sell Stock of product "+product[index].getName()+" -:");
				System.out.println("\n Please insert the total product Sell -: ");
				if(shopApp.sellStock(sc.nextInt())) {
					System.out.println("Sell Request Successfully Executed");
				}
				else {
					System.out.println("Failed... \n Product dosen't have enough Stock. Please buy new Stock.");
				}
			}
			if (objectAction == 4) {
				System.out.println("4. Change the Price of product "+product[index].getName()+" -:");
				System.out.println("\n Please insert the new Price of product -: ");
				shopApp.rePrice(objectAction);
				System.out.println("\n Price is Successfully Updated");
			}
			if (objectAction == 5) {
				System.out.println("5. Total Value of Product of product "+product[index].getName()+" is -: "+shopApp.totalValue());
			}
			
			System.out.println("If you want to close this program please provide Zero (0) as input -:");
			if(sc.nextInt()==0) {
				action = false;
			}
		} while (action);

		sc.close();
	}

}
