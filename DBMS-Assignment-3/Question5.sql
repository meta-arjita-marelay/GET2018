USE storefront;
/*Create a view displaying the order information 
(Id, Title, Price, Shopper’s name, Email, Orderdate, Status)
with latest ordered items should be displayed first for last 60 days.*/
CREATE OR REPLACE VIEW displayorderinformation
AS
SELECT o.order_id, os.product_id, p.product_name, o.bill_amount, u.first_name, u.last_name, u.email_id, o.placed_date, os.status
FROM orders o, product p, users u, order_status os
   WHERE os.order_id = o.order_id 
   AND o.order_id = u.user_id 
   AND os.product_id = p.product_id 
   AND o.placed_date > (DATE_SUB(CURDATE(), INTERVAL 2 MONTH))
   ORDER BY os.order_id DESC LIMIT 60;
       
       
SELECT * FROM displayorderinformation;

/*Use the above view to display the Products(Items) which are in ‘shipped’ state.*/
SELECT product_name
FROM displayorderinformation
WHERE status= "shipped";

/*Use the above view to display the top 5 most selling products*/
SELECT product_name , COUNT(product_id) AS productcount
FROM displayorderinformation
GROUP BY product_id
ORDER BY productcount
LIMIT 5;








