drop table profile;
drop table users;
drop table company;

create table company
(
    id   serial primary key,
    name varchar(128)
);

create table users
(
    id         bigserial primary key,
    username   varchar(128) unique,
    firstname  varchar(128),
    lastname   varchar(128),
    birth_date date,
    info       jsonb,
    role       varchar(32),
    company_id int references company (id) on delete cascade
);

create table profile
(
    id       bigserial primary key,
    user_id  bigint not null unique references users (id), -- обязан быть not null unique для OneToOne
    street   varchar(128),
    language char(2)
);



