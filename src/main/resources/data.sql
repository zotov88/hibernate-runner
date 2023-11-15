create table users
(
    id         bigserial primary key,
    username   varchar(128) unique,
    firstname  varchar(128),
    lastname   varchar(128),
    birth_date date,
    info       jsonb,
    role       varchar(32),
    company_id int references company (id)
);

create table company
(
    id   serial primary key,
    name varchar(128)
);

drop table users;
drop table company;
