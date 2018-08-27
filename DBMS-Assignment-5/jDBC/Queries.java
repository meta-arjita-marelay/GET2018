package jDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Queries class contains method which will run the mysql queries
 * 
 * @author Arjita
 *
 */
public class Queries {
	/**
	 * Given the id of a user, fetch all orders (Id, Order Date, Order Total) of
	 * that user which are in shipped state. Orders should be sorted by order
	 * date column in chronological order.
	 * 
	 * @return list of OrderPOJO objects after storing the result the select
	 *         query
	 */
	public static List<OrderPOJO> selectQuery(int userid) {
		int rowCount = 0;
		List<OrderPOJO> orders = new ArrayList<OrderPOJO>();
		String queryString = "SELECT o.order_id, date(o.placed_date) as placed_date, os.product_id "
				+ "FROM orders o, order_status os "
				+ "WHERE os.status LIKE 'shipped' " + "AND o.user_id=?";
		try (
				// Step 1: Allocate a database 'Connection' object
				Connection conn = ConnectionFactory.getconnection();
				// Step 2: Allocate a 'Statement' object in the Connection
				PreparedStatement statement = conn
						.prepareStatement(queryString);) {
			// Step 3: Execute a SQL SELECT query, the query result
			// is returned in a 'ResultSet' object.
			System.out.println("The SQL query is: " + queryString); // Echo For
																	// debugging
			System.out.println();
			statement.setInt(1, userid);
			ResultSet resultSet = statement.executeQuery();

			// Step 4: Process the ResultSet by scrolling the cursor forward via
			// next().
			System.out.println("The records selected are:");
			
			while (resultSet.next()) { // Move the cursor to the next row,
										// return false if no more row
				int order_id = resultSet.getInt("order_id");
				Date placed_date = resultSet.getDate("placed_date");
				int product_id = resultSet.getInt("product_id");
				OrderPOJO order = new OrderPOJO();
				order.setOrderId(order_id);
				order.setPlacedDate(placed_date);
				order.setProductId(product_id);
				orders.add(order);
				System.out.println(order_id + ", " + placed_date + ", "
						+ product_id);
				++rowCount;
			}
			System.out.println("Total number of records = " + rowCount);

		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		// Step 5: Close the resources - Done automatically by try with resources
		return orders;
	}

	/**
	 * Insert five or more images of a product using batch insert technique.
	 * 
	 * @param images
	 *            list of images to be inserted in database
	 */
	public static int insertQuery(List<ImagePOJO> images) {
		String queryString = "insert into image (url, image_name, product_id) "
				+ "values(?,?,?)";
		try (
		// Step 1: Allocate a database 'Connection' object
		Connection conn = ConnectionFactory.getconnection();

				// Step 2: Allocate a 'Statement' object in the Connection
				PreparedStatement statement = conn
						.prepareStatement(queryString);) {
			try {
				conn.setAutoCommit(false);
				System.out.println("The SQL query is: " + queryString); // Echo
																		// For
																		// debugging
				System.out.println();

				for (int i = 0; i < images.size(); i++) {
					statement.setString(1, images.get(i).getUrl());
					statement.setString(2, images.get(i).getImage_name());
					statement.setInt(3, images.get(i).getProduct_id());
					statement.addBatch();
				}

				int[] result = statement.executeBatch();
				System.out.println("The number of rows inserted: "
						+ result.length);
				conn.commit();
				return result.length;

			} catch (SQLException ex) {
				ex.printStackTrace();
				conn.rollback();
			}
		}
		// Step 5: Close the resources - Done automatically by
		// try-with-resources
		catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	/**
	 * Update all those products which were not ordered by any Shopper in last 1
	 * year to inactive state. Return the number of products updated.
	 * 
	 * @return number of rows affected after running update query
	 */
	public static int updateQuery() {
		int affectedRows = 0;
		String queryString = "UPDATE product "
				+ "SET productstate='inactive' "
				+ "WHERE product.product_id NOT IN "
				+ "(SELECT os.product_id "
				+ "FROM orders o INNER JOIN order_status os "
				+ "ON o.order_id=os.order_id "
				+ "WHERE o.placed_date > (DATE_SUB(CURDATE(), INTERVAL 1 YEAR)) "
				+ "AND o.placed_date <> null);";
		try (
		// Step 1: Allocate a database 'Connection' object
		Connection conn = ConnectionFactory.getconnection();

				// Step 2: Allocate a 'Statement' object in the Connection
				PreparedStatement statement = conn
						.prepareStatement(queryString);) {
			try {
				conn.setAutoCommit(false);
				System.out.println("The SQL query is: " + queryString); // Echo
				affectedRows = statement.executeUpdate();
				System.out.println();

			} catch (SQLException ex) {
				ex.printStackTrace();
				conn.rollback();
			}
		}
		// Step 5: Close the resources - Done automatically by
		// try-with-resources
		catch (SQLException e) {
			e.printStackTrace();
		}
		return affectedRows;
	}

	/**
	 * Select and display the category title of all top parent categories sorted
	 * alphabetically and the count of their child categories.
	 * 
	 * @return
	 */
	public static List<CategoryPOJO> selectAndDisplay() {
		int rowCount = 0;
		List<CategoryPOJO> categories = new ArrayList<CategoryPOJO>();
		String queryString = "SELECT C.category_id ,C.category_name,COUNT(C.category_id) as count "
				+ "FROM category C "
				+ "LEFT JOIN category P "
				+ "ON P.parent_category = C.category_id "
				+ "WHERE P.parent_category IN "
				+ "(SELECT category_id FROM category "
				+ "WHERE parent_category IS NULL) "
				+ "GROUP BY C.category_id "
				+ "ORDER BY category_name;";

		try (
				// Step 1: Allocate a database 'Connection' object
				Connection conn = ConnectionFactory.getconnection();
				// Step 2: Allocate a 'Statement' object in the Connection
				PreparedStatement statement = conn
						.prepareStatement(queryString);) {
			   // Step 3: Execute a SQL SELECT query, the query result
			   // is returned in a 'ResultSet' object.

			System.out.println("The SQL query is: " + queryString); 
			System.out.println();

			ResultSet resultSet = statement.executeQuery();

			// Step 4: Process the ResultSet by scrolling the cursor forward via
			// next().
			System.out.println("The records selected are:");

			while (resultSet.next()) {
				int categoryId = resultSet.getInt("category_id");
				String categoryName = resultSet.getString("category_name");
				int count = resultSet.getInt("count");
				CategoryPOJO category = new CategoryPOJO();
				category.setCategoryId(categoryId);
				;
				category.setCategoryName(categoryName);
				;
				category.setCount(count);
				;
				categories.add(category);

				System.out.println(categoryId + ", " + categoryName + ", "
						+ count);
				++rowCount;
			}
			System.out.println("Total number of records = " + rowCount);

		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return categories;
	}
}
