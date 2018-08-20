#Assignment2
USE storefront;

/*Display Recent 50 orders placed(Id, order Date, order Total)*/
SELECT order_id,placed_date,bill_amount 
FROM orders 
ORDER BY placed_date DESC LIMIT 50;

/*Display 10 most expensive orders.*/
SELECT order_id,bill_amount
FROM orders
ORDER BY bill_amount DESC LIMIT 10;

/*Display all the orders which are placed more than 10 days old and one or more items from those orders are still not shipped.*/
SELECT o.order_id , o.bill_amount
FROM orders o
WHERE
o.placed_date < (DATE_SUB(CURDATE(), INTERVAL 10 DAY))
AND
o.order_id IN (SELECT DISTINCT osnested.order_id FROM order_status osnested WHERE osnested.status="placed");

#Display list of shoppers which haven't ordered anything since last month.
SELECT user_id, first_name 
FROM users
WHERE users.user_id NOT IN
(
SELECT user_id AS active_user 
FROM orders O
WHERE placed_date > (DATE_SUB(CURDATE(), INTERVAL 1 MONTH))
)
AND users.user_type = "shopper";

#Display list of shopper alONg with orders placed BY them in lASt 15 days.
SELECT u.user_id , u.first_name , o.bill_amount 
FROM orders o INNER JOIN users u
ON u.user_id = o.user_id
WHERE placed_date > (DATE_SUB(CURDATE(), INTERVAL 1 MONTH));

#Display list of order items which are in “shipped” state for particular order Id (i.e.: 1020))
SELECT p.product_id , p.product_name
FROM product p INNER JOIN order_status o
ON p.product_id = o.product_id
WHERE o.status="shipped" AND o.order_id=2;

#Display list of order items alONg with order placed date which fall between Rs 20k to Rs 50k price.
SELECT p.product_name , o.placed_date
FROM product p INNER JOIN order_status os
ON os.product_id=p.product_id
INNER JOIN orders o
ON o.order_id = os.order_id
WHERE p.amount >=20000 AND p.amount<=50000;

#UPDATE first 20 order items status to “Shipped” which are placed today.
SET SQL_SAFE_UPDATES = 0;
UPDATE order_status os
SET os.status="shipped"
WHERE os.order_id IN
(
SELECT o.order_id 
from orders o LEFT JOIN order_status os
ON o.order_id=os.order_id
WHERE DATE(o.placed_date)=CURDATE()
AND os.status="placed"
)
LIMIT 20 ;








