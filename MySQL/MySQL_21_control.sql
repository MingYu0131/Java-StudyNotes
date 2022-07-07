#演示流程控制语句
#1、IF(exp0, exp1, exp2) 如果exp0为真就执行exp1，否则执行exp2
#2、IFNULL(exp0, exp1) 如果exp0为null就执行exp1，否则就是exp0
#查询emp表，如果comm是null，就显示0.0
SELECT *,IFNULL(comm, 0.0) AS comm FROM emp;
#注意，MySQL中使用IS NULL而不是 == null
SELECT ename,IF(comm IS NULL, 0.0, comm) AS comm FROM emp;
#3、SELECT CASE WHEN exp0 THEN exp1 
#		WHEN exp2 THEN exp3 
#		WHEN exp4 THEN exp5 ..
#		ELSE exp6 END		类似于多分支选择结构
#如果emp的job是CLERK就显示职员，如果是MANAGER则显示经理，如果是SALESMAN则显示销售人员，其他正常显示
SELECT ename,(SELECT CASE 
		WHEN job = 'CLERK' THEN '职员'
		WHEN job = 'MANAGER' THEN '经理'
		WHEN job = 'SALESMAN' THEN '销售人员'
		ELSE job END) AS job
		FROM emp;