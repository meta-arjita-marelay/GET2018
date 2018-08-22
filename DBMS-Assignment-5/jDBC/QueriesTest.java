package jDBC;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;

public class QueriesTest {

	/*
	 * @Test public void testInsertQuery() { List<ImagePOJO> images = new
	 * ArrayList<ImagePOJO>(); ImagePOJO images1 = new
	 * ImagePOJO("image.com/id101","image1",2); images.add(images1); ImagePOJO
	 * images2 = new ImagePOJO("image.com/id101","image2",3);
	 * images.add(images2); ImagePOJO images3 = new
	 * ImagePOJO("image.com/id101","image3",2); images.add(images3);
	 * assertEquals(3,Queries.insertQuery(images)); }
	 */
	@Test
	public void testSelectQuery() throws ParseException {
		List<OrderPOJO> expectedresult = new ArrayList<OrderPOJO>();
		OrderPOJO order1 = new OrderPOJO();
		order1.setOrderId(2);

		SimpleDateFormat objSDF = new SimpleDateFormat("yyyy-MM-dd");
		Date date1 = objSDF.parse("2018-07-04");

		order1.setPlacedDate(date1);
		order1.setProductId(6);
		expectedresult.add(order1);

		OrderPOJO order2 = new OrderPOJO();
		order2.setOrderId(2);
		SimpleDateFormat objSDF1 = new SimpleDateFormat("yyyy-MM-dd");
		Date date2 = objSDF1.parse("2018-07-04");
		order2.setPlacedDate(date2);
		order2.setProductId(5);
		expectedresult.add(order2);

		List<OrderPOJO> actualresult = new ArrayList<OrderPOJO>();
		actualresult = Queries.selectQuery(3);

		for (int i = 0; i < actualresult.size(); i++) {
			assertEquals(expectedresult.get(i).getOrderId(), actualresult
					.get(i).getOrderId());
			assertEquals(expectedresult.get(i).getPlacedDate(), actualresult
					.get(i).getPlacedDate());
			assertEquals(expectedresult.get(i).getProductId(), actualresult
					.get(i).getProductId());
		}
	}

	@Test
	public void testUpdateQuery() {
		assertEquals(10, Queries.updateQuery());
	}

	@Test
	public void testSelectQueryCategory() throws ParseException {
		List<CategoryPOJO> expectedresult = new ArrayList<CategoryPOJO>();
		CategoryPOJO category1 = new CategoryPOJO();
		category1.setCategoryId(1);
		;
		category1.setCategoryName("Eletronics");
		category1.setCount(2);
		expectedresult.add(category1);

		CategoryPOJO category2 = new CategoryPOJO();
		category2.setCategoryId(6);
		;
		category2.setCategoryName("Fashion");
		category2.setCount(2);
		expectedresult.add(category2);

		CategoryPOJO category3 = new CategoryPOJO();
		category3.setCategoryId(11);
		;
		category3.setCategoryName("Sports");
		category3.setCount(2);
		expectedresult.add(category3);

		List<CategoryPOJO> actualresult = new ArrayList<CategoryPOJO>();
		actualresult = Queries.selectAndDisplay();

		for (int i = 0; i < actualresult.size(); i++) {
			assertEquals(expectedresult.get(i).getCategoryId(), actualresult
					.get(i).getCategoryId());
			assertEquals(expectedresult.get(i).getCategoryName(), actualresult
					.get(i).getCategoryName());
			assertEquals(expectedresult.get(i).getCount(), actualresult.get(i)
					.getCount());
		}
	}
}
