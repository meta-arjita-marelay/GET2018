#Assignment2
#Question2 after insertion question part

/*Display Id, Title, Category Title, Price of the products which are Active and recently added products should be at top.*/
SELECT p.product_id, p.product_name, c.category_name, p.amount 
FROM product p, category c, product_category_relation pcr 
WHERE pcr.product_id = p.product_id AND pcr.category_id = c.category_id AND stock > 0
ORDER BY p.product_id DESC;

/*Display the list of products which don't have any images*/
SELECT p.product_name 
FROM product p
WHERE product_id NOT IN (SELECT product_id FROM image);

/*Display all Id, Title and Parent Category Title for all the Categories listed, sorted by Parent Category Title and then Category Title.*/
SELECT child.category_id, child.category_name, IFNULL(parent.category_name, 'Top Category') AS parent_category 
FROM category child
LEFT JOIN category parent
ON child.parent_category = parent.category_id
ORDER BY parent.category_name, child.category_name;

/*Display Id, Title, Parent Category Title of all the leaf Categories*/
SELECT child.category_id, child.category_name, IFNULL(parent.category_name, 'Top Category') AS parent_category
FROM category child
INNER JOIN category parent
ON child.parent_category = parent.category_id
WHERE child.category_id NOT IN (SELECT DISTINCT parent_category FROM category WHERE parent_category IS NOT NULL);

/*Display Product Title, Price & Description which falls into particular category Title (i.e. “Mobile”)*/
SELECT p.product_name, p.amount, p.description
FROM product p, category c, product_category_relation pcr
WHERE pcr.product_id = p.product_id AND pcr.category_id = c.category_id
AND c.category_name="Laptops";

/*Display the list of Products whose Quantity on hand (Inventory) is under 50.*/
SELECT product_name
FROM product
WHERE stock < 50;

/*Increase the Inventory of all the products by 100.*/
UPDATE product
SET stock = stock + 100;







