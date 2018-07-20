package sc;

public enum PromotionEnum {
	PROMO1("CODE1", 1, 10), PROMO2("CODE2", 11, 20), PROMO3("CODE3", 21, 30);

	private String code;
	private int startDate;
	private int endDate;

	private PromotionEnum(String code, int startDate, int endDate) {
		this.code = code;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public String getCode() {
		return code;
	}

	public int getStartDate() {
		return startDate;
	}

	public int getEndDate() {
		return endDate;
	}
}
