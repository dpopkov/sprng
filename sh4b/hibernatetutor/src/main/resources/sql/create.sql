# Create table Employee for Practice #8 "Read/Write Employee entity".

CREATE TABLE Employee
(
    id         integer not null auto_increment,
    first_name varchar(64),
    last_name  varchar(64),
    company    varchar(64),
    primary key (id)
);
