-- -----------------------------------------
-- Sams Teach Yourself SQL in 10 Minutes
-- http://forta.com/books/0672336073/
-- Example table creation scripts for MySQL.
-- -----------------------------------------


-- ----------------------
-- Create Customer table
-- ----------------------
CREATE TABLE `customer`
(
  cust_id      int       AUTO_INCREMENT PRIMARY KEY NOT NULL ,
  cust_name    char(50)  NOT NULL ,
  cust_address char(50)  NULL ,
  cust_city    char(50)  NULL ,
  cust_state   char(5)   NULL ,
  cust_zip     char(10)  NULL ,
  cust_country char(50)  NULL ,
  cust_contact char(50)  NULL ,
  cust_email   char(255) NULL 
);

-- -----------------------
-- Create OrderItem table
-- -----------------------
CREATE TABLE `orderItem`
(
  order_item int          AUTO_INCREMENT PRIMARY KEY NOT NULL ,
  order_num  int          NOT NULL ,
  prod_id    int          NOT NULL ,
  quantity   int          NOT NULL ,
  item_price decimal(8,2) NOT NULL ,
);


-- -------------------
-- Create Order table
-- -------------------
CREATE TABLE `order`
(
  order_num  int      AUTO_INCREMENT PRIMARY KEY NOT NULL ,
  order_date datetime NOT NULL ,
  cust_id    int      NOT NULL
);

-- ---------------------
-- Create Product table
-- ---------------------
CREATE TABLE `product`
(
  prod_id    int           AUTO_INCREMENT PRIMARY KEY NOT NULL ,
  vend_id    int           NOT NULL ,
  prod_name  char(255)     NOT NULL ,
  prod_price decimal(8,2)  NOT NULL ,
  prod_desc  text          NULL ,
  deleted    int           DEFAULT 0
);

-- --------------------
-- Create Vendor table
-- --------------------
CREATE TABLE `vendor`
(
  vend_id      int      AUTO_INCREMENT PRIMARY KEY NOT NULL ,
  vend_name    char(50) NOT NULL ,
  vend_address char(50) NULL ,
  vend_city    char(50) NULL ,
  vend_state   char(5)  NULL ,
  vend_zip     char(10) NULL ,
  vend_country char(50) NULL ,
  deleted      int      DEFAULT 0
);

CREATE TABLE `file_info`
(
  file_id      int      AUTO_INCREMENT PRIMARY KEY NOT NULL ,
  file_name    char(50) NOT NULL ,
  file_path    char(50) NULL ,
  file_size    int  NULL ,
  extension    char(50) NULL
);

-- --------------------
-- 用户表
-- --------------------
CREATE TABLE `user`
(
  user_id      int      AUTO_INCREMENT PRIMARY KEY NOT NULL ,
  user_name    char(50) NOT NULL
);

-- --------------------
-- 角色表
-- --------------------
CREATE TABLE `role` (
  role_id      int      AUTO_INCREMENT PRIMARY KEY NOT NULL ,
  role_name    char(50) NOT NULL ,
  role_code    char(50) NOT NULL
);

-- --------------------
-- 权限表
-- --------------------
CREATE TABLE `access` (
  access_id      int      AUTO_INCREMENT PRIMARY KEY NOT NULL ,
  access_name    char(50) NOT NULL ,
  access_code    char(50) NOT NULL ,
  access_url     char(50) NOT NULL ,
  parent_id      int
);

-- --------------------
-- 用户角色关系表
-- --------------------
CREATE TABLE `userRole` (
  user_id      int NOT NULL ,
  role_id      int NOT NULL ,
  PRIMARY KEY (user_id, role_id),
  FOREIGN KEY (user_id) REFERENCES `user` (user_id),
  FOREIGN KEY (role_id) REFERENCES `role` (role_id)
);

-- --------------------
-- 角色权限关系表
-- --------------------
CREATE TABLE `roleAccess` (
  role_id        int NOT NULL ,
  access_id      int NOT NULL ,
  PRIMARY KEY (user_id, access_id),
  FOREIGN KEY (user_id) REFERENCES `user` (user_id),
  FOREIGN KEY (access_id) REFERENCES `access` (access_id)
);

-- --------------------
-- 用户文件关系表
-- --------------------
CREATE TABLE `userFile` (
  file_id        int NOT NULL ,
  user_id        int NOT NULL ,
  PRIMARY KEY (user_id, file_id),
  FOREIGN KEY (user_id) REFERENCES `user` (user_id),
  FOREIGN KEY (file_id) REFERENCES `file` (file_id)
);

-- -------------------
-- Define primary keys
-- -------------------
ALTER TABLE `customer` AUTO_INCREMENT ADD PRIMARY KEY (cust_id);
ALTER TABLE `orderItem` ADD PRIMARY KEY (order_num, order_item);
ALTER TABLE `order` ADD PRIMARY KEY AUTO_INCREMENT (order_num);
ALTER TABLE `product` ADD PRIMARY KEY AUTO_INCREMENT (prod_id);
ALTER TABLE `vendor` ADD PRIMARY KEY AUTO_INCREMENT (vend_id);
ALTER TABLE `user` ADD PRIMARY KEY AUTO_INCREMENT (user_id);
ALTER TABLE `role` ADD PRIMARY KEY AUTO_INCREMENT (role_id);
ALTER TABLE `access` ADD PRIMARY KEY AUTO_INCREMENT (access_id);
ALTER TABLE `userFile` ADD PRIMARY KEY (user_id, file_id);
ALTER TABLE `file` ADD PRIMARY KEY AUTO_INCREMENT (file_id);
ALTER TABLE `file` ADD created_by char(10);
ALTER TABLE `file` ADD created_at datetime;
-- -------------------
-- Define foreign keys
-- -------------------
ALTER TABLE `orderItem` ADD CONSTRAINT FK_OrderItem_Order FOREIGN KEY (order_num) REFERENCES `order` (order_num);
ALTER TABLE `orderItem` ADD CONSTRAINT FK_OrderItem_Product FOREIGN KEY (prod_id) REFERENCES `product` (prod_id);
ALTER TABLE `order` ADD CONSTRAINT FK_Order_Customer FOREIGN KEY (cust_id) REFERENCES `customer` (cust_id);
ALTER TABLE `product` ADD CONSTRAINT FK_Product_Vendor FOREIGN KEY (vend_id) REFERENCES `vendor` (vend_id);
ALTER TABLE `userRole` ADD CONSTRAINT FK_User_Role FOREIGN KEY (user_id) REFERENCES `user` (user_id);
ALTER TABLE `userRole` ADD CONSTRAINT FK_Role_User FOREIGN KEY (role_id) REFERENCES `role` (role_id);
ALTER TABLE `roleAccess` ADD CONSTRAINT FK_Role_Access FOREIGN KEY (role_id) REFERENCES `role` (role_id);
ALTER TABLE `roleAccess` ADD CONSTRAINT FK_Access_Role FOREIGN KEY (access_id) REFERENCES `access` (access_id);
ALTER TABLE `userFile` ADD CONSTRAINT FK_User_File FOREIGN KEY (user_id) REFERENCES `user` (user_id);
ALTER TABLE `userFile` ADD CONSTRAINT FK_File_User FOREIGN KEY (file_id) REFERENCES `file` (file_id);