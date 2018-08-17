use storefront;
INSERT INTO users(first_name, last_name, email_id, user_password, user_type) 
VALUES  ("arjita", "marelay", "arjita@gmail.com", "arjita", "admin"),
        ("deekshika", "sharma", "dee@gmail.com", "deek25", "shopper"),
        ("prakalpa", "rathore", "prakalpa@gmail.com", "praks", "shopper"),
        ("chirag", "jain", "chirag@gmail.com", "chirag","shopper"),
        ("richa", "jain", "richa@gmail.com", "richa","shopper");

INSERT INTO address(user_id,area,city,state,pin_code)
VALUES(2,"jayanti nagar","aligarh","up",101),
	  (2,"sitapura","jaipur","raj",102),
      (3,"bapu nagar","jaipur","raj",102),
      (4,"iet","alwar","raj",103),
      (5,"ashoka","alwar","raj",104),
      (5,"sitapura","jaipur","raj",102),
      (4,"mental asylum","udaipur","raj",123);

INSERT INTO category(category_name, parent_category)
VALUES  ("Eletronics", NULL),
        ("Mobile", 1),
        ("Laptops", 1),#3
        ("Mobile Accessories", 2),
        ("Laptop Accessories", 3),
        ("Fashion", NULL),#6
        ("Men's Fashion", 6),
        ("Women's Fashion", 6),
        ("Men's Watch", 7),#9
        ("Women's Watch", 8),
        ("Sports", NULL),
        ("Cricket", 11),#12
        ("Football", 11);

INSERT INTO product(product_name, desciption, stock, amount)
VALUES  ("Apple iPhone X", "Latest by apple", 13, 70000.00),
        ("Samsung S9", "Latest by samsung", 121, 62000.50),
        ("HP BS-164TU", "Top selling by HP", 34, 41000.00),#3
        ("Dell AB-220TX", "Top selling by Dell", 23, 47500.00),
        ("Sandisk Memory card 32 gb", "Top selling memory card by Sandisk", 45, 410.00),
        ("Sandisk pen drive 32 gb", "Top selling pen drive by Sandisk", 54, 540.00),#6
        ("Timex Men's Watch", "Best in men class", 132, 5000.00),
        ("Timex Women's Watch", "Best in women class", 123, 7000.00),
        ("SG Full Size Bat", "Best for batting", 546, 900.00),#9
        ("Adidas Football", "Best for football", 234, 1000.00);

INSERT INTO product_category_relation(product_id, category_id)
VALUES  (1, 2),
        (2, 2),
        (3, 3),
        (4, 3),
        (5, 4),
        (6, 5),
        (7, 9),
        (8, 10),
        (9, 12),
        (10, 13);
        
INSERT INTO image(product_id, image_name, url)
VALUES  (1, "iPhone image 1", "image.com/id101"),
        (1, "iPhone image 2", "image.com/id102"),
        (1, "iPhone image 3", "image.com/id103"),
        (2, "samsung image 1", "image.com/id201"),
        (3, "HP Laptop image 1", "image.com/id301"),
        (4, "Dell laptop image 1", "image.com/id401"),
        (7, "Men's watch image 1", "image.com/id701"),
        (8, "Women's watch image 1", "image.com/id801"),
        (8, "Women's watch image 2", "image.com/id802");
        
INSERT INTO orders(user_id, address_id, bill_amount, placed_date)
VALUES  (2, 1, 124000.00, NULL),
        (3, 3, 143580.00, '2018-07-04 14:29:36'),
        (5, 7, 820.00, '2018-07-07 14:29:36'),
        (5, 7, 1800.00, '2018-07-19 14:29:36');       
        
INSERT INTO order_status(product_id, order_id, status, quantity, ship_date, deliver_date)
VALUES  (2, 1, NULL, 2, NULL, NULL),
        (4, 2, "placed", 3, NULL, NULL),
        (6, 2, "shipped", 2, '2018-07-05 14:29:36', NULL),
        (5, 3, "delivered", 2, '2018-07-08 14:29:36', '2018-07-20 17:29:36'),
        (9, 4, "returned", 2, '2018-07-21 14:29:36', '2018-07-25 17:29:36');
        
        
        
        
        
        
        
