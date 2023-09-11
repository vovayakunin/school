create table driver
(
    id      serial primary key,
    name    varchar,
    age     int,
    license boolean
        auto_id references auto(id)
)

create table auto
(
    id    serial primary key,
    marka varchar,
    model varchar,
    price int
)