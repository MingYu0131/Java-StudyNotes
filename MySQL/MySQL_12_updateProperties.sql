#DELETE语句，用于删除表的数据
#1、如果不使用WHERE子句，将删除表中的所有数据
#2、DELETE语句不能删除某一列的值（可使用update设为null或''）
#3、DELETE仅能删除记录，不能删除表本身，如果要删除表使用DROP TABLE
DELETE FROM emp WHERE user_name = 'wmy'