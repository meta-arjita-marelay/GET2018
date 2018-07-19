package sc;

public enum PromotionEnum
{
	PROMO1("CODE1" ,1 ,10),
	PROMO2("CODE2" ,11 ,20),
	PROMO3("CODE3" ,21 ,30);
	
	private String code;
	private int startDate;
	private int endDate;
	private PromotionEnum(String s, int sDate , int eDate)
	{
		this.code=s;
		this.startDate=sDate;
		this.endDate=eDate;
	}
	public String getCode()
	{
		return code;
	}
	public int getStartDate()
	{
		return startDate;
	}
	public int getEndDate()
	{
		return endDate;
	}
	public static boolean checkPromo()
	{		
		return true;
	}
}
