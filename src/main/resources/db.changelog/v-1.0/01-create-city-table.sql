create table if not exists city (
    city_id integer generated always as identity primary key,
    city_name varchar(256) not null,
    population integer not null,
    subway boolean not null,
    country varchar(32) not null
)

