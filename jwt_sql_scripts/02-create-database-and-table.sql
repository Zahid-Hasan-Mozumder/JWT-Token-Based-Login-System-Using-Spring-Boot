create database if not exists `jwt_example`;

use `jwt_example`;

drop table if exists `person`;

create table if not exists `person`(
`id` int not null auto_increment,
`first_name` varchar(255) default null,
`last_name` varchar(255) default null,
`email` varchar(255) default null,
`password` varchar(255) default null,
`role` varchar(255) default null,
primary key(`id`),
unique key `jwt_example_uk` (`email`)
) engine=InnoDB auto_increment=1 default charset=latin1;
