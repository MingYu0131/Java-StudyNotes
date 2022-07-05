#统计每个学生的总分
SELECT `name`,math+chinese+english AS total_grade FROM student
#在赵云的总分上增加百分之60
SELECT `name`,(math+chinese+english)*1.6 AS total_grade FROM student WHERE `name` = '赵云'
#查询英语成绩大于90的同学
SELECT `name`,english FROM student WHERE english > 90
#查询总分大于200的同学
SELECT `name`,(math+chinese+english) AS total_grade FROM student WHERE (math+chinese+english) > 200
#查询math大于60并且id大于90的学生成绩
SELECT * FROM student WHERE math > 60 AND id > 4
#查询英语成绩大于语文成绩的同学
SELECT * FROM student WHERE english > chinese
#查询总分大于200且数学成绩小于语文成绩，姓韩的同学
#LIKE是模糊查询，%代表任意字符
SELECT * FROM student WHERE (math+chinese+english) > 200 AND math < chinese AND `name` LIKE '赵%'
#查询英语分数在80~90之间的同学
#BETWEEN AND结合使用，是闭区间
SELECT * FROM student WHERE english BETWEEN 80 AND 90
#查询数学分数为89，90，91的同学
SELECT * FROM student WHERE math IN (89,90,91)
#所有姓李货宋的学生成绩
SELECT * FROM student WHERE `name` LIKE '李%' OR `name` LIKE '宋%'
#查询数学分>80语文>80的同学
SELECT * FROM student WHERE math > 80 AND chinese > 80
#查询数学比语文多1分的同学
SELECT * FROM student WHERE math = chinese + 1





