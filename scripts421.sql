--
ALTER TABLE student
    ADD CONSTRAINT age_check CHECK (age >= 16);
--
ALTER TABLE student
    ADD CONSTRAINT name_check UNIQUE (name);
ALTER TABLE student
    ALTER COLUMN name SET NOT NULL ;
--
ALTER TABLE faculty
    ADD CONSTRAINT color_name_unique UNIQUE (color, name);
--
ALTER TABLE student
    ALTER age SET DEFAULT 20;
