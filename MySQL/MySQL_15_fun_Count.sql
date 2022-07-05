#演示count()函数的使用
#统计一个班级总共有多少个学生
SELECT COUNT(*) FROM student
#统计数学成绩大于90的学生个数
SELECT COUNT(*) AS good_at_math_num FROM student WHERE math > 90
#统计总分大于250的人数
SELECT COUNT(*) AS total_score_beyond_250_num FROM student 
		WHERE (chinese + english + math) > 250
#count(*)和count(列)的区别
#count(*):返回满足条件的记录的行数
#count(列): 返回满足条件的某列有多少个，但是会排除null
CREATE TABLE t11(
	`name` VARCHAR(20)
);

INSERT t11 VALUES('tom');
INSERT t11 VALUES('myb');
INSERT t11 VALUES('jack');
INSERT t11 VALUES(NULL);
SELECT * FROM t11;
SELECT COUNT(*) FROM t11;
SELECT COUNT(`name`) FROM t11;