/*Display Shopper’s information along with number of orders he/she placed during last 30 days.*/
SELECT u.user_id , u.first_name , COUNT(o.user_id)
FROM users u INNER JOIN orders o
ON u.user_id=o.user_id
WHERE o.placed_date > (DATE_SUB(CURDATE(), INTERVAL 1 MONTH))
GROUP BY o.user_id;

/*Display the top 10 Shoppers who generated maximum number of revenue in last 30 days*/
SELECT u.user_id, u.first_name , SUM(o.bill_amount) as sum
FROM orders o INNER JOIN users u
ON o.user_id = u.user_id
WHERE o.placed_date > (DATE_SUB(CURDATE(), INTERVAL 1 MONTH))
GROUP BY o.user_id
ORDER BY sum DESC
LIMIT 10;

/*Display top 20 Products which are ordered most in last 60 days along with numbers*/
SELECT p.product_id ,  p.product_name , COUNT(os.product_id) as productcount
FROM product p INNER JOIN order_status os
ON p.product_id = os.product_id
INNER JOIN orders o
ON os.order_id = o.order_id
WHERE o.placed_date > (DATE_SUB(CURDATE(), INTERVAL 2 MONTH))
GROUP BY os.product_id
ORDER BY productcount
LIMIT 20;

/*Display Monthly sales revenue of the StoreFront for last 6 months. It should display each month’s sale*/
SELECT MONTHNAME(o.placed_date) AS month , SUM(o.bill_amount) AS totalorder
FROM orders o
WHERE o.placed_date > (DATE_SUB(CURDATE(), INTERVAL 6 MONTH))
GROUP BY MONTH(o.placed_date);

/*Mark the products as Inactive which are not ordered in last 90 days.*/
SET SQL_SAFE_UPDATES = 0;
ALTER TABLE product 
ADD productstate varchar(8) DEFAULT "active"
AFTER description;

UPDATE product
SET productstate="inactive"
WHERE product.product_id IN 
                    (SELECT os.product_id
                     FROM orders o INNER JOIN order_status os
                     ON o.order_id=os.order_id
                     WHERE o.placed_date < (DATE_SUB(CURDATE(), INTERVAL 3 MONTH))
                     );
                     
/*Given a category search keyword, display all the Products present in this category/categories*/
SELECT p.product_name
FROM product p INNER JOIN product_category_relation pcr  
ON p.product_id = pcr.product_id
INNER JOIN category c
ON c.category_id=pcr.category_id
WHERE c.category_name = "Mobile Accessories";

/*Display top 10 Items which were cancelled most.*/
SELECT p.product_id , p.product_name , COUNT(os.status) as cancelcount
FROM product p INNER JOIN order_status os
ON p.product_id = os.product_id
WHERE os.status="cancelled"
GROUP BY os.product_id
ORDER BY cancelcount DESC
LIMIT 10;





























