/*查找最晚入职员工的所有信息，为了减轻入门难度，目前所有的数据里员工入职的日期都不是同一天(sqlite里面的注释为--,mysql为comment)
CREATE TABLE `employees` (
`emp_no` int(11) NOT NULL,  -- '员工编号'
`birth_date` date NOT NULL,
`first_name` varchar(14) NOT NULL,
`last_name` varchar(16) NOT NULL,
`gender` char(1) NOT NULL,
`hire_date` date NOT NULL,
PRIMARY KEY (`emp_no`));*/
select * from employees where hire_date = (select max(hire_date) from employees);

-- 查找入职员工时间排名倒数第三的员工所有信息
select * from employees where hire_date = (select distinct hire_date from employees order by hire_date desc limit 2, 1);

/*查找各个部门当前(dept_manager.to_date='9999-01-01')领导当前(salaries.to_date='9999-01-01')薪水详情以及其对应部门编号dept_no
(注:请以salaries表为主表进行查询，输出结果以salaries.emp_no升序排序，并且请注意输出结果，dept_no列是最后一列)
CREATE TABLE `salaries` (
`emp_no` int(11) NOT NULL, --  '员工编号',
`salary` int(11) NOT NULL,
`from_date` date NOT NULL,
`to_date` date NOT NULL,
PRIMARY KEY (`emp_no`,`from_date`));
CREATE TABLE `dept_manager` (
`dept_no` char(4) NOT NULL, -- '部门编号'
`emp_no` int(11) NOT NULL, --  '员工编号'
`to_date` date NOT NULL,
PRIMARY KEY (`emp_no`,`dept_no`));
*/
select s.*, d.dept_no from salaries as s join dept_manager as d on s.emp_no = d.emp_no where d.to_date='9999-01-01' and s.to_date='9999-01-01';

--用一条SQL 语句 查询出每门课都大于80 分的学生姓名
select name from table group by name having min(grade) > 80

--学生表 Student
create table Student(Sid varchar(6), Sname varchar(10), Sage datetime, Ssex varchar(10));
--成绩表 SC
create table SC(Sid varchar(10), Cid varchar(10), score decimal(18,1));
--课程表 Course
create table Course(Cid varchar(10),Cname varchar(10),Tid varchar(10));
--教师表 Teacher
create table Teacher(Tid varchar(10),Tname varchar(10));

--查询平均成绩大于等于 80 分的同学的学生编号和学生姓名和平均成绩
select s.sid, sname, avg(score) as avg_score from student as s, sc
where s.sid = sc.sid group by s.sid having avg_score > 80

--查询所有同学的学生编号、学生姓名、选课总数、所有课程的总成绩(没成绩的显示为null)
select s.sid, s.sname, count(cid) as 选课总数, sum(score) as 总成绩
from student as s left join sc
on s.sid = sc.sid
group by s.sid