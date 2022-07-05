INSERT INTO emp 
#注意插入时间数据时也要带引号
VALUES(2, 'wmy', '1999-02-15', '2022-7-5', 'Boss', 20000, '我喜欢吃香蕉', '牛逼.jpg')

#将所有员工的薪水修改为50000
#不添加WHERE子句，会修改列的所有数据
UPDATE emp
SET Salary = 50000

#将姓名为myb的员工薪水调整为10000
UPDATE emp
SET Salary = 10000 WHERE user_name = 'myb'

#将wmy的薪水在原有的基础上追加1000元
UPDATE emp
SET Salary = Salary + 1000 WHERE user_name = 'wmy'

SELECT * FROM emp