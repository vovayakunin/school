alter table student
    add constraint age_16 check (age >= 16);

alter table student
    add constraint uniq_name unique (name);

alter table student
    alter column name set not null;

alter table faculty
    add constraint uniq_name_color unique (name, color);

alter table student
    alter column age set default 20;