#演示时间相关的类型
CREATE TABLE t10(
	birthday DATE, #生日，DATE日期，保存年月日
	job_time DATETIME,#DATETIME,保存年月日时分秒
	log_time TIMESTAMP
		NOT NULL DEFAULT CURRENT_TIMESTAMP
		ON UPDATE CURRENT_TIMESTAMP);#TIMESTAMP时间戳，配置了login_time 列自动更新
INSERT INTO t10(birthday, job_time) VALUES('2021-7-4', '2021-7-4 11:30:0')
INSERT INTO t10(birthday, job_time) VALUES('2021-8-4', '2021-8-4 10:30:0')

SELECT * FROM t10;