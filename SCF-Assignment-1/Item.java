package sc;

public class Item {
	private String name;
	private float price;
	private int quantity;

	public Item(String name, float price, int quantity) {
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}

	public String getName() {
		return name;
	}

	public float getPrice() {
		return price;
	}

	public float getQuantity() {
		return (float) quantity;
	}

	public float totalPrice() {
		return (float) quantity * price;
	}

	public void updateName(String newName) {
		this.name = newName;
	}

	public void updatePrice(float newPrice) {
		this.price = newPrice;
	}

	public void updateQuantity(int newQuantity) {
		this.quantity = newQuantity;
	}

	public void printProduct() {
		System.out.println(this.name + " " + this.price + " " + this.quantity
				+ " " + this.price * (float) quantity);
	}
}
