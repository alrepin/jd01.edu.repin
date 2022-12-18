SELECT s.name AS student,
       s.age  AS age,
       f.name AS faculty
FROM student AS s
         LEFT JOIN faculty as f
                   ON s.faculty_id = f.id
ORDER BY s.id ASC;
--
SELECT s.name      AS student,
       s.age       AS age,
       f.name      AS faculty,
       a.file_path AS avatar
FROM student AS s
         INNER JOIN avatar as a
                    ON s.id = a.student_id
         LEFT JOIN faculty as f
                   ON s.faculty_id = f.id
ORDER BY s.id ASC;
