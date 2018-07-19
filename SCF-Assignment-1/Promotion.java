package sc;

public interface Promotion {
	public double minPrice = 0, discount = 0;

	public double getMinimumPrice();

	public void setMinimumPrice(double minPrice);

	public double getFixedDiscount();

	public void setFixedDiscount(double discount);

	public boolean isPromotionApplicable(String code);

}
