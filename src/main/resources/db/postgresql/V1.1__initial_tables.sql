
create table users
(
    user_id uuid not null,
    user_account_id text not null unique,
    password text not null,
    email text ,
    name text not null,
    primary key(user_id)
);

create table posts
(
    post_id uuid not null,
    user_id uuid,
    text text,
    tags text,
    created_at timestamp default now() not null,
    updated_at timestamp default now() not null,
    primary key(post_id)
);

create table photos
(
    photo_id uuid not null,
    post_id uuid,
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