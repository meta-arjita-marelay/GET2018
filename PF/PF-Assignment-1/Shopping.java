package sc;
import java.util.ArrayList;
import java.util.List;
public class Shopping {
       
    private List<Item> Cart = new ArrayList<Item>();
    
    ShoppingCart(){
    	
    }
 
    public void addItem(String Pname,float Pprice,int Pquantity )
    {
        Item Product= new Item(Pname,Pprice,Pquantity);
        Cart.add(Product);
    }
    
    public void removeItem(String Pname) {
       Item delprod = null;
       for (Item prod: Cart) {
            if (prod.getPname() == Pname) {
                Cart.remove(prod);
                break;
            }
        }
    }

    public void updatePname(String OldName,String NewName)
    {
        for (Item prod: Cart) {
            if (prod.getPname() == OldName) {
                    prod.updatePname(NewName);
            }
        }
    }
    
    public void updatePrice(String Pname, float NewPrice)
    {
        for (Item prod: Cart) {
            if (prod.getPname() == Pname) {
                    prod.updatePprice(NewPrice);
            }
        }
    }
    
    public void updateQuantity(String Pname, int newQty)
    {
        for (Item prod: Cart) {
            if (prod.getPname() == Pname) {
                    prod.updatePqty(newQty);
            }
        }
    }
    
    public void printCart()
    {
        for (Item prod: Cart) {
            prod.printProduct();
        }
    }
    
    public void Bill()
    {
      float totalbill=0;
      for (Item prod: Cart) {
            totalbill = totalbill + prod.getPrice()*prod.getQty() ;
        }
      printCart();
      System.out.println("Total Bill: "+totalbill);
    }

    
    private static class Item {
            private String name;
            private float price;
            private int quantity;

        public Item(String name, float price, int quantity) {
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
         public void updatePname(String NewName)
                {
                      this.name = NewName;
                }
          public void updatePprice(float NewPrice)
                {
                      this.price = NewPrice;
                }
           public void updatePqty(int  NewQty)
                {
                      this.quantity = NewQty;
                }
           public void printProduct()
                {
                    System.out.println(this.name  + " " +this.price + " " +this.quantity+" "+this.price *(float)quantity)  ;
                }
    }

    public static void main(String[] args) {
        
        Shopping newcart = new Shopping() ;
//        String name;
//        float quan, price;
//        System.out.println("Enter your choice....1")
        newcart.addItem("hello", (float) 1,10000);
        newcart.addItem("hello2", (float) 3,4);
        newcart.printCart();
        newcart.Bill();
        newcart.addItem("hello3", (float) 2, 200);
        newcart.Bill();
        newcart.removeItem("hello3");
        newcart.Bill();
    }
    
}



