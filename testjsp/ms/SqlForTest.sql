create table catalog
(
	id int NOT NULL,
	name varchar(255),
	description varchar(1024),
	primary key(id)
);

insert into catalog (name,description) values('daopian','daopianpian');
insert into catalog (name,description) values('jijia','jijiajia');
insert into catalog (name,description) values('luyouqi','luyouqiluyouqi');
insert into catalog (name,description) values('chinese','中文');

create table ResourceTypeCatalog(
	id int not null auto_increment,
	resid int not null,
	name varchar(256),
	description varchar(1024),
	primary key(id)

);

insert into ResourceTypeCatalog(resid,name) values(101,'BladeServer');
insert into ResourceTypeCatalog(resid,name) values(102,'RackServer');
insert into ResourceTypeCatalog(resid,name) values(103,'SwitchRouter');
insert into ResourceTypeCatalog(resid,name) values(104,'GDevice');
insert into ResourceTypeCatalog(resid,name) values(105,'DiskStorage');

create table ProjCatalog(
	id int not null auto_increment,
	resid int not null,
	name varchar(256),
	description varchar(1024),
	primary key(id)
	);


create table serviceDevInformation(
	id int not null auto_increment,
	resid int not null ,
	machinetype varchar(256),
	ip  int unsigned,
	ostype varchar(256),
	diskinfo varchar(256),
	memory varchar(256),
	hab tinyint ,
	position varchar(256),
	mode tinyint not null,
	description varchar(1024),
	primary key(id)
);

create table deviceinformation(
	id int not null auto_increment,
	resid int not null ,
	machinetype varchar(256),
	ip  int unsigned,
	position varchar(256),
	mode tinyint not null,
	description varchar(1024),
	primary key(id)
);



create table Assignproj(
	id int not null auto_increment,
	deviceId int not null ,
	Assignedproj int not null,
	time timestamp,
	description varchar(1024),
	primary key(id)
);



















