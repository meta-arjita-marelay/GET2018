package sc;

import java.util.Calendar;

public class FixedProductPromotion implements Promotion {
	double minQuantity, discount;

	public double getMinimumPrice() {
		return minQuantity;
	}

	public void setMinimumPrice() {
		minQuantity = 1;
	}

	public double getFixedDiscount() {
		return discount;
	}

	public void setFixedDiscount() {
		discount = 100;
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
