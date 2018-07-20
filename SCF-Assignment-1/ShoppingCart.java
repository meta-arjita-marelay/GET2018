package sc;

public class ShoppingCart {
	public static void main(String[] args) {

		Shopping newCart = new Shopping();
		newCart.addItem("hello", (float) 1, 10000);
		newCart.addItem("hello2", (float) 3, 4);
		newCart.printCart();
		double bill = newCart.Bill();
		System.out.println("Total bill" + bill);// total bill without discount
		// discount on whole order
		double minimumPrice = 500;
		double discountGiven = 100;
		FixedOrderPromotion addDiscount = new FixedOrderPromotion();
		addDiscount.setMinimumPrice(minimumPrice);
		double minPrice = addDiscount.getMinimumPrice();
		if (bill > minPrice) {
			if (addDiscount.isPromotionApplicable("CODE2")) {
				addDiscount.setFixedDiscount(discountGiven);
				double discount = addDiscount.getFixedDiscount();
				bill = bill - discount;
			}
		}
		System.out.println("Total bill after promo code " + bill);
		// discount on product
		double minProdPrice = 1;
		double discountOnProd = 50;
		FixedProductPromotion productDiscount = new FixedProductPromotion();
		productDiscount.setMinimumPrice(minProdPrice);
		double prodMinPrice = productDiscount.getMinimumPrice();
		if ((newCart.getProductQuantity()) > prodMinPrice) {
			if (addDiscount.isPromotionApplicable("CODE2")) {
				productDiscount.setFixedDiscount(discountOnProd);
				double prodDiscount = productDiscount.getFixedDiscount();
				bill = bill - prodDiscount;
			}
		}
		System.out.println("Total bill after promo code " + bill);
	}
}
