package sc;

import java.util.Calendar;

public class FixedOrderPromotion implements Promotion {
	double minPrice, discount;

	public double getMinimumPrice() {
		return minPrice;
	}

	public void setMinimumPrice() {
		minPrice = 500;
	}

	public double getFixedDiscount() {
		return discount;
	}

	public void setFixedDiscount() {
		discount = 300;
	}

	public boolean isPromotionApplicable(String code) {
		Calendar cal = Calendar.getInstance();
		int dayOfMonth = cal.get(Calendar.DAY_OF_MONTH);
		for (PromotionEnum promotion : PromotionEnum.values()) {
			if (code.equals(promotion.getCode())) {
				if (dayOfMonth > promotion.getStartDate()
						&& dayOfMonth < promotion.getEndDate()) {
					return true;
				}
			}
		}
		return false;
	}
}
