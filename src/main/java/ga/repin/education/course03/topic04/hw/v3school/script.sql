
select * from student
where age>10 and age<20;

select name from student;

select * from student
where name like ('%t%');

select * from student
where age<student.id;

select * from student
ORDER BY age;
