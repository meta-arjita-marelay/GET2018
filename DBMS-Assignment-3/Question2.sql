/*Display the list of products (Id, Title, Count of Categories) which fall in more than one Categories*/
SELECT p.product_id , p.product_name , COUNT(pcr.product_id) AS countcategories
FROM product p INNER JOIN product_category_relation pcr
ON pcr.product_id=p.product_id
GROUP BY pcr.product_id
HAVING countcategories>1;

/*Display Count of products as per price range*/
SELECT pnew.rangeofprice , count(*) 
FROM (SELECT CASE
       WHEN amount>0 AND amount<100 THEN '0-100'
       WHEN amount>100 AND amount<500 THEN '100-500'
       ELSE 'Above 500' END AS rangeofprice
   FROM product) pnew
GROUP BY pnew.rangeofprice;

/*Display the Categories along with number of products under each category.*/
SELECT c.category_id , c.category_name , COUNT(pcr.category_id)
FROM category c INNER JOIN product_category_relation pcr
ON c.category_id = pcr.category_id
GROUP BY pcr.category_id;