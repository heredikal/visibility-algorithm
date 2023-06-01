-- -- V1__create_product_table.sql

CREATE TABLE product (
  id INT PRIMARY KEY,  
  sequence int
);

CREATE TABLE size (
  id INT PRIMARY KEY,
  product_id INT,
  back_soon BOOLEAN,
  special BOOLEAN,
  FOREIGN KEY (product_id) REFERENCES product(id)
);

CREATE TABLE stock (
  id INT AUTO_INCREMENT PRIMARY KEY,
  size_id INT,
  quantity INT,
  FOREIGN KEY (size_id) REFERENCES size(id)
);
