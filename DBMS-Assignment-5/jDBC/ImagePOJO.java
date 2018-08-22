package jDBC;
/**
 * ImagePOJO is used to store the data of image
 * @author Arjita
 *
 */
public class ImagePOJO {
	private String url;
	private String image_name;
	private int product_id;

	public ImagePOJO(String url, String image_name, int product_id) {
		this.url = url;
		this.image_name = image_name;
		this.product_id = product_id;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getImage_name() {
		return image_name;
	}

	public void setImage_name(String image_name) {
		this.image_name = image_name;
	}

	public int getProduct_id() {
		return product_id;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}

}
