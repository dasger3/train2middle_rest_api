drop table if exists enevt;

create table event
(
    id         int auto_increment primary key,
    title      varchar(255) not null,
    place      varchar(255) not null,
    speaker    varchar(255) not null,
    event_type varchar(255) not null,
    date_time  datetime
);

INSERT INTO event
VALUES (1, 'First event','First place','First speaker', 'BIRTHDAY',  now());
