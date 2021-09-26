drop table if exists hibernate_sequence;

drop table if exists user;

create table test.hibernate_sequence
(
    next_val bigint null
);

create table test.user
(
    id bigint not null
        primary key,
    age int null,
    first_name varchar(255) null,
    last_name varchar(255) null
);