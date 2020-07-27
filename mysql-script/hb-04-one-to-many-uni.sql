drop schema if exists `hb-04-one-to-many-uni`;
create schema `hb-04-one-to-many-uni`;
use `hb-04-one-to-many-uni`;
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

drop table if exists `course`;

create table `course`(
	`id` int(11) not null auto_increment,
    `title` varchar(45) default null,
    `instructor_id` int(11)  default null,
    
    primary key (`id`),
    
    unique key `title_unique` (`title`),
    
    key `fk_instructor_idx` (`instructor_id`),
    
    constraint `fk_instructor`
    foreign key (`instructor_id`)
    references `instructor` (`id`)
    on delete no action on update no action
)engine=InnoDB auto_increment=10 default charset=latin1;

create table `review`(
	`id` int(11) not null auto_increment,
    `comment` varchar(45) default null,
    `course_id` int(11) default null,
    
    primary key (`id`),
    
    key `fk_course_id_idx` (`course_id`),
	
    constraint `fk_course`
    foreign key (`course_id`)
    references `course` (`id`)
    on delete no action on update no action
)engine=InnoDB auto_increment=10 default charset=latin1;
	