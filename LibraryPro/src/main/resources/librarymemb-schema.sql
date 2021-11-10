drop table if exists `librarymemb` CASCADE;
create table 
    `librarymemb`
(
    id integer AUTO_INCREMENT, 
    name varchar(255), 
    address varchar(255), 
    email varchar(255), 
    primary key (id)
);