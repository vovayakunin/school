-- liquibase formatted sql

-- changeset vladimir:01-std_ind
CREATE INDEX student_name_index ON student (name);
-- changeset vladimir:02-fac_ind
CREATE INDEX faculty_ind ON faculty (name, color);
