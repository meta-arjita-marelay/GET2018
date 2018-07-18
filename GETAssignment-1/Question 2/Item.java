package sc;

public class Item
{
	private String name;
    private float price;
	private int quantity;

	public Item(String name, float price, int quantity) 
	{
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}
	public String getPname()
	{
		return name;
	}
	public float getPrice()
	{
		return price;
	}
	public float getQty()
	{
		return (float)quantity;
	}
	public void updatePname(String newName)
	{
		this.name = newName;
	}
	public void updatePprice(float newPrice)
	{
		this.price = newPrice;
	}
	public void updatePqty(int  newQty)
	{
		this.quantity = newQty;
	}
	public void printProduct()
	{
		System.out.println(this.name  + " " +this.price + " " +this.quantity+" "+this.price *(float)quantity)  ;
	}
}

