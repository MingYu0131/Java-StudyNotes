#索引练习
CREATE TABLE `order`(
	id INT PRIMARY KEY,
	goods_name VARCHAR(32) NOT NULL DEFAULT ' ',
	buyer VARCHAR(32) NOT NULL DEFAULT ' ',
	nums INT NOT NULL DEFAULT 0 );
CREATE TABLE `order`(
	id INT UNIQUE NOT NULL,
	goods_name VARCHAR(32) NOT NULL DEFAULT ' ',
	buyer VARCHAR(32) NOT NULL DEFAULT ' ',
	nums INT NOT NULL DEFAULT 0,
	PRIMARY KEY (id) );
DESC `order`;
SHOW INDEX IN `order`;

#菜谱表meun
CREATE TABLE meun(
	id INT PRIMARY KEY,
	buyer_id INT UNIQUE);
CREATE TABLE meun2(
	id INT PRIMARY KEY,
	buyer_id INT);
#注意：创建索引时要指定索引的名字
ALTER TABLE meun2 ADD UNIQUE INDEX buyer_id_index(buyer_id);
CREATE UNIQUE INDEX buyer_id_index ON meun2(buyer_id);
SHOW INDEX IN meun;

#运动员表
CREATE TABLE sportman(
	id INT PRIMARY KEY,
	`name` VARCHAR(32) NOT NULL DEFAULT ' ',
	hobby VARCHAR(32) NOT NULL DEFAULT ' ');

CREATE INDEX name_index ON sportman(`name`);
#使用DROP删除INDEX 
DROP INDEX name_index ON sportman;
ALTER TABLE sportman ADD INDEX name_index(`name`);



