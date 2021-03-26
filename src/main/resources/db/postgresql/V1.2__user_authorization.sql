
create table authority
(
    authority text not null,
    user_id uuid not null,
    primary key(user_id, authority)
);