#讲解ORDER BY子句
#1、指定排序的列，排序的列可以是表中的列名，也可以是AS指定的列
#2、Asc 升序[默认]，Desc 降序
#3、ORDER BY子句应该位于SELECT语句的结尾

#对数学成绩排序后输出
SELECT * FROM student ORDER BY math
#对总分按降序输出
SELECT `name`, (chinese + english + math) AS total_score FROM student
	ORDER BY total_score DESC;
#对姓韩的学生成绩排序输出
INSERT INTO student
VALUES(8, '韩信', 80, 95, 96)

SELECT `name`, (chinese + english + math) AS total_score FROM student
	WHERE `name` LIKE '韩%'
	ORDER BY total_score DESC;
