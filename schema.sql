create sequence counter
    start with 1
    increment by 1000;

create table urls
(
    hash       varchar(7) primary key,
    long_url   varchar(2048) not null,
    created_at timestamptz not null default now()
);
