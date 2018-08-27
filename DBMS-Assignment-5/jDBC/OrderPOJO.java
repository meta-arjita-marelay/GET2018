package jDBC;

import java.util.Date;
/**
 * OrderPOJO is used to store details of orders
 * @author Arjita
 *
 */
public class OrderPOJO {
	private int orderId;
	private Date placedDate;
	private int productId;

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public Date getPlacedDate() {
		return placedDate;
	}

	public void setPlacedDate(Date placedDate) {
		this.placedDate = placedDate;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}
}
