
create table emotions
(
    emotion_id uuid not null,
    photo_id uuid not null,
    person_id uuid,
    bound_left decimal not null,
    bound_top decimal not null,
    bound_width decimal not null,
    bound_height decimal not null,
    calm decimal not null,
    sad decimal not null,
    angry decimal not null,
    happy decimal not null,
    confused decimal not null,
    surprised decimal not null,
    disgusted decimal not null,
    fear decimal not null,
    created_at timestamp default now(),
    updated_at timestamp default now(),
    primary key(emotion_id)
);
