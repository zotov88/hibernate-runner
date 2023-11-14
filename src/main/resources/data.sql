create table users
(
    username  varchar(128) primary key,
    firstname varchar(128),
    lastname varchar(128),
    birth_date date,
    info jsonb,
    role varchar(32)
);

drop table users;