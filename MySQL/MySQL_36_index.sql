#演示索引：可以提高数据库的查询性能，但是需要占用磁盘空间
#索引的原理：1、当我们没有索引时，select会进行全表扫描，而且就算已经找到了，是不会停止的，因为不知道有没有重复元素
#2、对某个属性建立了索引后，会以改属性构造一棵B+树，可以大大提高查找效率
#3、索引的代价：(1)磁盘占用(2)对DML(删除、修改等等)语句会造成效率影响，因为树删除修改节点相对于线性结构效率更低
#4、虽然索引有这些不好，但是索引对项目使用最多的查询优化很大，所以索引好处更多

#索引的类型：
#1、主键索引，主键自动会成为索引，成为主索引
#2、唯一索引，UNIQUE INDEX，唯一索引
#3、普通索引（用的最多），INDEX，因为有时需要将允许不唯一的字段设置为索引（例如name）
#4、全文索引FULLTEX，开发中用的较多的有全文搜索Solr和ElasticSearch（ES）

#创建测试表
CREATE TABLE t17(
	id INT PRIMARY KEY,
	`name` VARCHAR(32),
	`address` VARCHAR(32));
	
#主键已经自动生成了索引
SHOW INDEXES FROM t17;
#添加唯一索引
CREATE UNIQUE INDEX name_index ON t17(`name`);
#添加普通索引
CREATE INDEX name_index ON t17(`name`);
#什么时候用唯一索引，普通索引？当你认为该字段不会有重复时，可以使用唯一索引（更快），其他情况用普通索引
#添加普通索引方式2
ALTER TABLE t17 ADD INDEX name_index (`name`);

#删除索引
DROP INDEX name_index ON t17;
#删除主键索引
ALTER TABLE t17 DROP PRIMARY KEY;
#修改索引：先删除再添加即可

#查询索引1
SHOW INDEXES FROM t17;
#方式2：
SHOW INDEX FROM t17;
#方式3：
SHOW KEYS FROM t17;
#方式4，不推荐：
DESC t17;