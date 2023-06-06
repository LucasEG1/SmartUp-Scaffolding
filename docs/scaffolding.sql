drop database if exists scaffolding;
create database if not exists scaffolding;
use scaffolding;

create table if not exists customer (
	id int primary key auto_increment,
	name VARCHAR(50),
	surname VARCHAR(50),
	dni VARCHAR(50),
	birthDate VARCHAR(50),
	address VARCHAR(50),
	zipCode VARCHAR(50),
	email VARCHAR(50)
);

create table if not exists passwords (
	id int primary key auto_increment,
    customer_id int not null,
    value varchar(75) not null,
    constraint fk_customer foreign key passwords (id) references Customer(id)
    ); 
insert into customer (name, surname, dni, birthDate, address, zipCode, email) values ('Jilly', 'Hannen', '411533850', '01/07/2008' , '5 Golf Course Street', '5857', 'jhannen0@globo.com');
select id from customer;