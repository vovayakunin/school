select s.name, s.age, f.name
from student s
         inner join faculty f on s.faculty_id = f.id;

SELECT student.name, student.age, avatar.file_path, avatar.file_size
FROM avatar
         LEFT JOIN student ON avatar.student_id = student.id;