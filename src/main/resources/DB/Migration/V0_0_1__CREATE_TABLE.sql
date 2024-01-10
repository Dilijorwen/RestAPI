create table public.users
(
    id  bigserial primary key,
    password varchar(255),
    username varchar(255)
);

alter table public.users
    owner to daniil;

