-- mb-01
-- 创建用户表
DROP TABLE IF EXISTS tb_user;
CREATE TABLE tb_user (
  id   INT(11) PRIMARY KEY AUTO_INCREMENT COMMENT '编号',
  name VARCHAR(18)         DEFAULT NULL COMMENT  '名称',
  sex CHAR(2) DEFAULT NULL  COMMENT '性别',
  age INT(5) DEFAULT  NULL COMMENT '年龄'
)CHARSET=utf8 COMMENT '用户表';

INSERT INTO tb_user(name, sex, age) VALUES ('jack','男',22);
INSERT INTO tb_user(name, sex, age) VALUES ('rose','女',19);
INSERT INTO tb_user(name, sex, age) VALUES ('tom','男',25);
INSERT INTO tb_user(name, sex, age) VALUES ('mary','女',20);

-- 班级表
DROP TABLE IF EXISTS tb_clazz;
CREATE TABLE tb_clazz(
  id INT(11) PRIMARY KEY AUTO_INCREMENT COMMENT '编号',
  code VARCHAR(18) DEFAULT NULL  COMMENT '班级编号'
)CHARSET=utf8 COMMENT '班级表';
INSERT INTO tb_clazz(code) VALUES ('j1601');
INSERT INTO tb_clazz(code) VALUES ('j1602');

-- 学生表
DROP  TABLE IF EXISTS tb_student;
CREATE TABLE tb_student(
  id INT PRIMARY KEY AUTO_INCREMENT COMMENT '编号',
  name VARCHAR(18) COMMENT '名称',
  sex CHAR(3) COMMENT '性别',
  age INT COMMENT '年龄',
  clazz_id INT COMMENT '对应班级',
  FOREIGN KEY (clazz_id) REFERENCES tb_clazz(id)
)CHARSET=utf8 COMMENT '学生表';
INSERT INTO  tb_student(name,sex,age,clazz_id) VALUES ('jack','男',22,1);
INSERT INTO  tb_student(name,sex,age,clazz_id) VALUES ('rose','女',18,1);
INSERT INTO  tb_student(name,sex,age,clazz_id) VALUES ('tom','男',25,2);
INSERT INTO  tb_student(name,sex,age,clazz_id) VALUES ('mary','女',20,2);


-- card person

DROP TABLE IF EXISTS tb_card;
CREATE TABLE tb_card(
  id INT  PRIMARY KEY AUTO_INCREMENT COMMENT '编号',
  code VARCHAR(18) COMMENT  '编号'
)CHARSET=utf8 COMMENT '身份证号表';

INSERT INTO tb_card(code) VALUES ('130428199301112953');

DROP TABLE IF EXISTS tb_person;
CREATE TABLE tb_person(
  id INT PRIMARY KEY  AUTO_INCREMENT COMMENT '编号',
  name VARCHAR(18) COMMENT '名称',
  sex VARCHAR(18) COMMENT '性别',
  age int COMMENT '年龄',
  card_id INT UNIQUE,
  FOREIGN KEY (card_id) REFERENCES tb_card(id)
)CHARSET=utf8 COMMENT '用户表';

INSERT INTO tb_person(name, sex, age, card_id) VALUES ('jack','男',23,1);



-- mb-02
-- 多对多测试

-- 用户表
DROP TABLE IF EXISTS tb_user;
CREATE TABLE tb_user(
  id INT PRIMARY KEY AUTO_INCREMENT COMMENT '编号',
  username VARCHAR(18) COMMENT '用户名',
  password VARCHAR(18) COMMENT '密码',
  phone VARCHAR(18) COMMENT '手机号',
  address VARCHAR(18) COMMENT '地址'
)CHARSET=utf8 COMMENT '用户表';
-- 插入用户表数据
INSERT INTO tb_user(username,password,phone,address) VALUES ('jack','123456','15801372602','广州');

-- 商品表
DROP TABLE IF EXISTS tb_article;
CREATE TABLE tb_article(
  id INT PRIMARY KEY AUTO_INCREMENT COMMENT '编号',
  name VARCHAR(18) COMMENT '商品名称',
  pric DOUBLE COMMENT '商品价格',
  remark VARCHAR(18) COMMENT '商品备注'
)CHARSET=utf8 COMMENT '商品表';


-- 插入商品数据
INSERT INTO tb_article(name, pric, remark) VALUES ('疯狂Java讲义',108.9,'李刚老师经典著作');
INSERT INTO tb_article(name, pric, remark) VALUES ('疯狂Android讲义',99.9,'李刚老师经典著作');
INSERT INTO tb_article(name, pric, remark) VALUES ('疯狂IOS讲义',89.9,'李刚老师经典著作');
INSERT INTO tb_article(name, pric, remark) VALUES ('SpringMVC + mybatis 企业开发',89.9,'李刚老师经典著作');

-- 订单表
DROP TABLE IF EXISTS tb_order;
CREATE TABLE tb_order(
  id INT PRIMARY KEY AUTO_INCREMENT COMMENT '编号',
  code VARCHAR(32) COMMENT '订单编号',
  total DOUBLE COMMENT '价格',
  user_id INT COMMENT '用户外键',
  FOREIGN KEY (user_id) REFERENCES tb_user(id)
)CHARSET=utf8 COMMENT '订单表';

-- 插入订单数据
INSERT INTO tb_order(code, total, user_id) VALUES ('2',388.6,1);
INSERT INTO tb_order(code, total, user_id) VALUES ('3',217.8,1);

-- 中间表
DROP TABLE IF EXISTS tb_item;
CREATE TABLE tb_item(
  order_id INT COMMENT '订单ID外键',
  article_id INT COMMENT '商品ID外键',
  amount INT COMMENT '',
  PRIMARY KEY (order_id,article_id),
  FOREIGN KEY (order_id) REFERENCES tb_order(id),
  FOREIGN KEY (article_id) REFERENCES tb_article(id)
)CHARSET=utf8 COMMENT '订单用户表';


INSERT INTO tb_item(order_id, article_id, amount) VALUES (1,1,1);
INSERT INTO tb_item(order_id, article_id, amount) VALUES (1,2,1);
INSERT INTO tb_item(order_id, article_id, amount) VALUES (1,3,2);
INSERT INTO tb_item(order_id, article_id, amount) VALUES (2,4,2);
INSERT INTO tb_item(order_id, article_id, amount) VALUES (2,1,1);

DROP TABLE IF EXISTS tb_employee;
CREATE TABLE tb_employee(
  id INT(11) PRIMARY KEY AUTO_INCREMENT COMMENT '编号',
  username VARCHAR(18) COMMENT '用户名称',
  password VARCHAR(18) COMMENT '用户密码',
  name VARCHAR(18) COMMENT '名称',
  sex CHAR(2) COMMENT '性别',
  age INT(11) COMMENT '年龄',
  phone VARCHAR(21) COMMENT '手机号',
  sal DOUBLE COMMENT '',
  state VARCHAR(18) COMMENT ''
);

INSERT INTO tb_employee(username, password, name, sex, age, phone, sal, state) VALUES ('jack','123456','杰克','男',26,'15801372600',9800,'ACTIVE');
INSERT INTO tb_employee(username, password, name, sex, age, phone, sal, state) VALUES ('rose','123456','露丝','女',21,'15801372601',6800,'ACTIVE');
INSERT INTO tb_employee(username, password, name, sex, age, phone, sal, state) VALUES ('tom','123456','汤姆','男',25,'15801372602',8800,'ACTIVE');
INSERT INTO tb_employee(username, password, name, sex, age, phone, sal, state) VALUES ('alice','123456','爱丽丝','女',20,'15801372604',5800,'ACTIVE');







