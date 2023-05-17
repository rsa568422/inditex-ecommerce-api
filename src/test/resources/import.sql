INSERT INTO products (id, sequence) VALUES (1, 10);
INSERT INTO products (id, sequence) VALUES (2, 7);
INSERT INTO products (id, sequence) VALUES (3, 15);
INSERT INTO products (id, sequence) VALUES (4, 13);
INSERT INTO products (id, sequence) VALUES (5, 6);

INSERT INTO sizes (id, product_id, back_soon, special) VALUES (11, 1, true, false);
INSERT INTO sizes (id, product_id, back_soon, special) VALUES (12, 1, false, false);
INSERT INTO sizes (id, product_id, back_soon, special) VALUES (13, 1 , true, false);
INSERT INTO sizes (id, product_id, back_soon, special) VALUES (21, 2, false, false);
INSERT INTO sizes (id, product_id, back_soon, special) VALUES (22, 2, false, false);
INSERT INTO sizes (id, product_id, back_soon, special) VALUES (23, 2, true, true);
INSERT INTO sizes (id, product_id, back_soon, special) VALUES (31, 3, true, false);
INSERT INTO sizes (id, product_id, back_soon, special) VALUES (32, 3, true, false);
INSERT INTO sizes (id, product_id, back_soon, special) VALUES (33, 3, false, false);
INSERT INTO sizes (id, product_id, back_soon, special) VALUES (41, 4, false, false);
INSERT INTO sizes (id, product_id, back_soon, special) VALUES (42, 4, false, false);
INSERT INTO sizes (id, product_id, back_soon, special) VALUES (43, 4, false, false);
INSERT INTO sizes (id, product_id, back_soon, special) VALUES (44, 4, true, true);
INSERT INTO sizes (id, product_id, back_soon, special) VALUES (51, 5, true, false);
INSERT INTO sizes (id, product_id, back_soon, special) VALUES (52, 5, false, false);
INSERT INTO sizes (id, product_id, back_soon, special) VALUES (53, 5, false, false);
INSERT INTO sizes (id, product_id, back_soon, special) VALUES (54, 5, true, true);

INSERT INTO stocks (size_id, quantity) VALUES (11, 0);
INSERT INTO stocks (size_id, quantity) VALUES (12, 0);
INSERT INTO stocks (size_id, quantity) VALUES (13, 0);
INSERT INTO stocks (size_id, quantity) VALUES (22, 0);
INSERT INTO stocks (size_id, quantity) VALUES (31, 10);
INSERT INTO stocks (size_id, quantity) VALUES (32, 10);
INSERT INTO stocks (size_id, quantity) VALUES (33, 10);
INSERT INTO stocks (size_id, quantity) VALUES (41, 0);
INSERT INTO stocks (size_id, quantity) VALUES (42, 0);
INSERT INTO stocks (size_id, quantity) VALUES (43, 0);
INSERT INTO stocks (size_id, quantity) VALUES (44, 10);
INSERT INTO stocks (size_id, quantity) VALUES (51, 10);
INSERT INTO stocks (size_id, quantity) VALUES (52, 10);
INSERT INTO stocks (size_id, quantity) VALUES (53, 10);
INSERT INTO stocks (size_id, quantity) VALUES (54, 10);