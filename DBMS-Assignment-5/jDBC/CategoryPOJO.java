package jDBC;

/**
 * CategoryPOJO is used to store details of category.
 * 
 * @author Arjita
 *
 */
public class CategoryPOJO {
	private int categoryId;
	private String categoryName;
	private int count;

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
}
