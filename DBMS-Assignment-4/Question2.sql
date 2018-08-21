/*Create a Stored procedure to retrieve average sales of each product in a month. 
Month and year will be input parameter to function.*/

DELIMITER $$
CREATE PROCEDURE average_sale_of_month(month INT , year INT)
BEGIN
SELECT p.product_id, p.product_name, AVG(p.amount) 
FROM product p , orders o, order_status os
WHERE p.product_id = os.product_id
AND o.order_id = os.order_id
AND MONTH(o.placed_date) = month
AND YEAR(o.placed_date) = year
GROUP BY os.product_id;
END$$

CALL average_sale_of_month(07,2018);

/*Create a stored procedure to retrieve table having order detail with status for a given period. 
Start date and end date will be input parameter. 
Put validation on input dates like start date is less than end date. 
If start date is greater than end date take first date of month as start date.*/

DELIMITER $$
CREATE FUNCTION date_validation(start_date DATE , end_date DATE)
RETURNS DATE NOT DETERMINISTIC
BEGIN
DECLARE set_start_date DATE;
    IF(start_date < end_date) 
        THEN
            RETURN start_date;
    ELSE
        SET set_start_date = CONCAT(DATE_FORMAT(end_date, '%Y-%m-'), '01');
            RETURN set_start_date;
    END IF;
END$$

DELIMITER $$ 
CREATE PROCEDURE order_details(IN start_date DATE, IN end_date DATE)
BEGIN
DECLARE set_start_date DATE;
    SET set_start_date = date_validation(start_date, end_date);
    SELECT o.order_id, o.placed_date, os.status, o.bill_amount
    FROM orders o INNER JOIN order_status os
    WHERE o.placed_date BETWEEN set_start_date AND end_date;
END$$

CALL order_details('2018-07-20','2018-08-18');