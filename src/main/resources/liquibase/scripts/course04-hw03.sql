-- liquibase formatted sql

-- changeset alrepin:1
CREATE INDEX student_name_index ON student(name);

-- changeset alrepin:2
CREATE INDEX faculty_name_color_index on faculty(name, color);
