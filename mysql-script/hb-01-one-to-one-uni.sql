drop schema if exists `hb-01-one-to-one-uni`;
create schema `hb-01-one-to-one-uni`;
use `hb-01-one-to-one-uni`;
set foreign_key_checks =0;
drop table if exists `instructor_detail`;
create table `instructor_detail`(
	id int(11) not null auto_increment,
    youtube_channel varchar(128) default null,
    hobby varchar(45) default null,
    primary key(id)
)engine=InnoDB auto_increment=1 default charset=latin1;

drop table if exists `instructor`;

create table `instructor`(
	id int(11) not null auto_increment,
    `first_name` varchar(45) default null,
    `last_name` varchar(45) default null,
    `email` varchar(45) default null,
    `instructor_detail_id` int(11) default null,
    primary key(id),
    key `fk_detail_idx` (`instructor_detail_id`),
    constraint `fk_detail` foreign key (`instructor_detail_id`)
    references `instructor_detail` (`id`)
    on delete no action on update no action
)engine=InnoDB auto_increment=1 default charset=latin1;

set foreign_key_checks =1;