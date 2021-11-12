drop table if exists `library_memb` CASCADE;
create table 
    `library_memb`
(
    id integer AUTO_INCREMENT, 
    name varchar(255), 
    address varchar(255), 
    email varchar(255), 
    primary key (id)
);