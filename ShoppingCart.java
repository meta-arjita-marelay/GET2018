package sc;

public class ShoppingCart 
{
	public static void main(String[] args) 
    {
        
        Shopping newCart = new Shopping() ;
        newCart.addItem("hello", (float) 1,10000);
        newCart.addItem("hello2", (float) 3,4);
        newCart.printCart();
        newCart.Bill();
        newCart.addItem("hello3", (float) 2, 200);
        newCart.Bill();
        newCart.removeItem("hello3");
        newCart.Bill();
    }
}
