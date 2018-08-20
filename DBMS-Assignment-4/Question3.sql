/*Identify the columns require indexing in order, product, category tables and create indexes.*/

#table orders
ALTER TABLE orders ADD INDEX index_bill_amount(bill_amount);

ALTER TABLE orders ADD INDEX index_placed_date(placed_date);

#table order_status
ALTER TABLE order_status ADD INDEX index_status(status);

ALTER TABLE order_status ADD INDEX index_order_id(order_id);

ALTER TABLE order_status ADD INDEX index_product_id(product_id);

#table product
ALTER TABLE product ADD UNIQUE index_product_name(product_name);

ALTER TABLE product ADD INDEX index_amount(amount);

#table category
ALTER TABLE category ADD UNIQUE index_category_name(category_name);

ALTER TABLE category ADD INDEX index_parent_category(parent_category);

#table parent_category_relation
ALTER TABLE product_category_relation ADD INDEX index_product_id(product_id);

ALTER TABLE product_category_relation ADD INDEX index_category_id(category_id);

#show index from category;

