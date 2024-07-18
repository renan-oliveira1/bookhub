create table if not exists USERS(
    ID varchar(100) primary key,
    NAME varchar(100) not null,
    LASTNAME varchar(100),
    EMAIL varchar(100) not null,
    PASSWORD varchar(100) not null,
    BIRTHDATE varchar(100),
    PHONE varchar(100),
    ROLE enum('ADMIN', 'USER'),
    CREATED_AT timestamp,
    UPDATED_AT timestamp
);

