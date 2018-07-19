package sc;
import java.util.ArrayList;
import java.util.List;
public class Shopping {
       
    private List<Item> Cart = new ArrayList<Item>();
    
    Shopping(){
    	
    }
 
    public void addItem(String pName,float pPrice,int pQuantity )
    {
        Item product= new Item(pName,pPrice,pQuantity);
        Cart.add(product);
    }
    
    public void removeItem(String pName)
    {
       for (Item prod: Cart) {
            if (prod.getPname() == pName) {
                Cart.remove(prod);
                break;
            }
        }
    }

    public void updatePname(String oldName,String newName)
    {
        for (Item prod: Cart) {
            if (prod.getPname() == oldName) {
                    prod.updatePname(newName);
            }
        }
    }
    
    public void updatePrice(String pName, float newPrice)
    {
        for (Item prod: Cart) {
            if (prod.getPname() == pName) 
            {
                    prod.updatePprice(newPrice);
            }
        }
    }
    
    public void updateQuantity(String pName, int newQty)
    {
        for (Item prod: Cart) 
        {
            if (prod.getPname() == pName) 
            {
                    prod.updatePqty(newQty);
            }
        }
    }
    
    public void printCart()
    {
        for (Item prod: Cart) 
        {
            prod.printProduct();
        }
    }
    
    public void Bill()
    {
      float totalBill=0;
      for (Item prod: Cart) 
      {
            totalBill = totalBill + prod.getPrice()*prod.getQty() ;
       }
      printCart();
      System.out.println("Total Bill: "+totalBill);
    }

    
   

    
    
}



