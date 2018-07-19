package sc;

import java.util.ArrayList;
import java.util.List;

public class Shopping {

	private List<Item> Cart = new ArrayList<Item>();

	Shopping() {

	}

	public int returnProductQuantity() {
		int i = 0;
		for (Item prod : Cart) {
			i++;
		}
		return i;
	}

	public void addItem(String pName, float pPrice, int pQuantity) {
		Item product = new Item(pName, pPrice, pQuantity);
		Cart.add(product);
	}

	public void removeItem(String pName) {
		for (Item prod : Cart) {
			if (prod.getName() == pName) {
				Cart.remove(prod);
				break;
			}
		}
	}

	public void updatePname(String oldName, String newName) {
		for (Item prod : Cart) {
			if (prod.getName() == oldName) {
				prod.updateName(newName);
			}
		}
	}

	public void updatePrice(String pName, float newPrice) {
		for (Item prod : Cart) {
			if (prod.getName() == pName) {
				prod.updatePrice(newPrice);
			}
		}
	}

	public void updateQuantity(String pName, int newQty) {
		for (Item prod : Cart) {
			if (prod.getName() == pName) {
				prod.updateQuantity(newQty);
			}
		}
	}

	public void printCart() {
		for (Item prod : Cart) {
			prod.printProduct();
		}
	}

	public double Bill() {
		double totalBill = 0;
		for (Item prod : Cart) {
			totalBill = totalBill + prod.getPrice() * prod.getQuantity();
		}
		return totalBill;
	}
}
