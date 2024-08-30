-- Brand data
INSERT INTO brand (id, name) VALUES (1, 'Zara');

-- Product data
INSERT INTO product (id, name) VALUES (35455, 'Basic Black T-Shirt');

-- Price data
INSERT INTO price (brand_id, product_id, price_list, priority, currency, price, start_date, end_date) VALUES
(1, 35455, 1, 0, 'EUR', 35.50, '2020-06-14 00:00:00', '2020-12-31 23:59:59'),
(1, 35455, 2, 1, 'EUR', 25.45, '2020-06-14 15:00:00', '2020-06-14 18:30:00'),
(1, 35455, 3, 1, 'EUR', 30.50, '2020-06-15 00:00:00', '2020-06-15 11:00:00'),
(1, 35455, 4, 1, 'EUR', 38.95, '2020-06-15 16:00:00', '2020-12-31 23:59:59');
