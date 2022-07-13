#演示事务：事务用于保证事件的一致性，由一组相关的dml语句组成，该组dml语句要么全成功要么全失败
#当执行事务操作，开始事务后，mysql会在表上加锁，防止其他用户更改表的数据
CREATE TABLE t18(
	id INT PRIMARY KEY,
	`name` VARCHAR(32));
#开始事务，事务是在数据库层面，可以横跨多个表的dml操作
START TRANSACTION;
#设置保存点
SAVEPOINT a;
INSERT INTO t18 VALUES(1, 'tom');
SAVEPOINT b;
INSERT INTO t18 VALUES(2, 'mybb');
SELECT * FROM t18;
#回退至保存点b
#注意：回退不能往后回退，即不能先回退至a，再回退至b
ROLLBACK TO b;
#回退至事务开始时
ROLLBACK;
#提交事务，所有操作生效，所有保持点全部消失无法回退
#注意：使用commit后，会确认事务的变化、结束事务、删除保存点、释放锁、数据生效、其他连接将可以查看到事务变化后的新数据
COMMIT;

#1、MySQL的事务机制需要innodb的存储引擎，myisam不行
#2、开始事务可以使用如下两种方式start transaction 或 set autocommit=off
#3、其实没有开始事务的话，数据库会在每个dml语句后自动执行一次commit