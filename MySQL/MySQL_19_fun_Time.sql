#介绍时间相关函数
#创建测试表
CREATE TABLE mes
(
	id INT,
	content VARCHAR(255),
	sendtime DATETIME
);
INSERT INTO mes VALUES(1, '北京新闻', NOW());
INSERT INTO mes VALUES(2, '广州新闻', NOW());
INSERT INTO mes VALUES(3, '深圳新闻', NOW());
SELECT * FROM mes;
#1、CURRENT_DATE() 返回当前日期，只包含年月日
#2、CURRENT_TIME() 返回当前时间，只包含时分秒
#3、CURRENT——TIMESTAMP() 返回当前时间戳，包含年月日时分秒
#4、YEAR||MONTH|DAY DATE(datetime) 返回datetime的年/月/日/日期

# 例：显示所有留言信息，但是发布日期只显示日期，不显示时间
SELECT id,content,DATE(sendtime) FROM mes;
SELECT id,content,DAY(sendtime) FROM mes;
#5、DATE_ADD(date, INTERVAL d_value d_type) 在date中加上日期或者时间,d_type可以是second/minute/hour/day/month/year

#例：查询在10分钟内发布的信息
SELECT * FROM mes WHERE DATE_ADD(sendtime, INTERVAL 20 MINUTE) >= NOW();
#6、DATE_SUB(date, INTERVAL d_value d_type) 在date中减去日期或者时间
SELECT * FROM mes WHERE DATE_SUB(NOW(), INTERVAL 20 MINUTE) <= sendtime;
#7、DATEDIFF(date1, date2) 返回两个时间差，结果是天

#例：求出2011-11-11 和 1990-1-1 相差多少天
SELECT DATEDIFF('2011-11-11', '1990-1-1') FROM DUAL;
#8、TIMEDIFF(date1, date2) 返回时间差，结果是时分秒
#9、NOW() 返回当前时间戳
#10、unix_timestamp 返回从1970-1-1到现在的总秒数
SELECT UNIX_TIMESTAMP() FROM DUAL;
#11、FROM_UNIXTIME() 将unix_timestamp()格式的转换为指定的格式
#'%Y-%m-%d %H:%i:%s' 是规定好的格式，代表年月日时分秒
SELECT FROM_UNIXTIME(1657117502, '%Y-%m-%d %H:%i:%s') FROM DUAL;
#例：如果你可以活80岁，求出你还能活多少天
SELECT DATEDIFF(DATE_ADD('1999-1-31', INTERVAL 80 YEAR), NOW()) FROM DUAL;



