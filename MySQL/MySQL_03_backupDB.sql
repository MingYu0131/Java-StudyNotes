#备份需求，需要在cmd下执行mysqldump指令，因为mysq/bin目录下有个mysqldump.exe，所以需要在cmd下执行
#1、备份mybb_01到D:\\bak.sql
mysqldump -u root -p -B mybb_01 mybb_01 > d:\\bak.sql
#注意备份文件其实是一系列的sql语句，备份的原理其实就是把数据库从开始到现在的sql语句保存起来
#数据库恢复的原理就是重新执行这些sql语句
#删除mybb_01进行测试
DROP DATABASE mybb_01
#2、恢复数据库方式1：(注意：进入 Mysql 命令行再执行)
source d:\\bak.sql
#恢复数据库方式2：将bak.sql中的语句复制再去mysql中执行

#3、需求：备份表，如下是备份mybb_01的t1表的命令
mysqldump -u root -p mybb_01 t1 > d:\\bak_t1.sql

#练习：这是一个 ecshop 的数据库，包括 ecshop 所有的表，请导入到 mysql 数据库中[备份]