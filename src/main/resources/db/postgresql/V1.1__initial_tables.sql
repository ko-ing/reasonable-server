create sequence if not exists user_id_seq;

create table users
(
    user_id serial not null,
    identification text not null ,
    password text not null,
    name text not null,
    primary key(user_id)
);

create sequence if not exists post_id_seq;

create table posts
(
    post_id serial  not  null,
    user_id integer references users (user_id),
    text text,
    tags text,
    created_at timestamp default now() not null,
    updated_at timestamp default now() not null,
    primary key(post_id)
);

create sequence if not exists photo_id_seq;

create table photos
(
    photo_id serial not null,
    post_id integer not null references posts (post_id),
    s3_url text not null,
    analyzed_raw text,
    photo_taken_at timestamp not null,
    created_at timestamp default now() not null,
    updated_at timestamp default now() not null,
    primary key(photo_id)
);

CREATE OR REPLACE FUNCTION trigger_set_timestamp()
    RETURNS TRIGGER AS $$
BEGIN
    NEW.updated_at = NOW();
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER set_timestamp
    BEFORE UPDATE ON posts
    FOR EACH ROW
EXECUTE PROCEDURE trigger_set_timestamp();

CREATE TRIGGER set_timestamp
    BEFORE UPDATE ON photos
    FOR EACH ROW
EXECUTE PROCEDURE trigger_set_timestamp();