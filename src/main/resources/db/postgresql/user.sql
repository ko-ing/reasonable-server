CREATE SEQUENCE IF NOT EXISTS user_seq;

CREATE TABLE user (
    user_id serial not null primary key,
    account_id text not null ,
    user_name
)