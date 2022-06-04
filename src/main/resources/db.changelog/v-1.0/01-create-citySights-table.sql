create table if not exists citySights
(
    sights_id integer primary key,
    sights_name varchar(256),
    dateOfConstruction date,
    shortDesc text,
    typeOfSights varchar(256),
    city_id integer,
    constraint fk_city_id foreign key ( city_id ) references city ( city_id )

)









