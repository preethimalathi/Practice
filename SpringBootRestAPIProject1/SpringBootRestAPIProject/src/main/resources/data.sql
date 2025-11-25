CREATE DATABASE IF NOT EXISTS studentDatabase;

USE studentDatabase;

CREATE TABLE IF NOT EXISTS student (
    rollNo INT AUTO_INCREMENT PRIMARY KEY,
    student_name VARCHAR(100),
    student_percentage FLOAT,
    student_branch VARCHAR(50)
);

INSERT INTO student (student_name, student_percentage, student_branch)
VALUES ('John Doe', 85.5, 'Computer Science'),
       ('Jane Doe', 92.0, 'Mechanical Engineering'),
       ('Mark Smith', 78.3, 'Electrical Engineering');

       Select * from student;