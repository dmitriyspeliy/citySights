create table if not exists citySights
(
    sights_id integer generated always as identity primary key,
    sights_name varchar(256) not null,
    dateOfConstruction date not null,
    shortDesc text not null,
    typeOfSights varchar(256) not null,
    city_id integer not null,
    constraint fk_city_id foreign key ( city_id ) references city ( city_id )

)









