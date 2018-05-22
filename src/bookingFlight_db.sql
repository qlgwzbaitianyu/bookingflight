


create table logintable(
	username varchar(40) primary key,
	password varchar(20)
);

create table passenger(
	pass_id int primary key,
	username varchar(20),
	usertype varchar(20),
	firstname varchar(20),
	lastname varchar(20),
	street varchar(45),
	city varchar(20),
	state varchar(20),
	zipcode int,
	email varchar(45)
);


alter table passenger
ADD FOREIGN KEY (username) REFERENCES logintable(username);


create table flight(
	flight_number int primary key,
	seat int,
	arrtime time,
	arrdate date,
	deptime time,
	depdate date,
	airport varchar(20),
	depart varchar(20),
	destination varchar(20),
	airplane_producer varchar(20)
);

create table seat(
	flight_number int not null primary key,
	first_class int,
	business_class int,
	economy_class int,
	FOREIGN KEY (flight_number) REFERENCES flight(flight_number)
);


create table booking(
	booking_id int not null auto_increment,
	flight_number int,
	pass_id int,
	seat_number int,
	baggage varchar(40),
	class varchar(20),
	reserv_status varchar(20),
	primary key (booking_id),
	FOREIGN KEY (flight_number) REFERENCES flight(flight_number),
	FOREIGN KEY (pass_id) REFERENCES passenger(pass_id)
);


 alter table flight
  modify column flight_number int not null auto_increment;

  alter table passenger
  modify column pass_id int not null auto_increment;
  
 alter table booking drop foreign key pass_id;
 ALTER TABLE t_name1 ADD FOREIGN KEY (column_name) REFERENCES t_name2(column_name)
 
 
alter table seat
 modify column first_class int not null;


insert into logintable values('annie', '123');
insert into logintable values('yasuo', '123');
insert into passenger values(1,'annie','user','annie', 'annie', 'mid', 'denton', 'tx', 76205, '123@gmail');
insert into passenger values(0,'nasus','user','nasus', 'dog', 'top', 'plano', 'tx', 77777, '666@gmail');
insert into passenger values(2,'yasuo','user','yasuo', 'yasuo', 'mid or top', 'jonesboro', 'arkansas', 45210, '456@gmail');


insert into flight values(1, 10, '08:30:00', '2018:06:10', '10:30:00', 
						  '2018:06:15', 'ORD', 'chicago', 'dallas', 'boeing 747');
insert into flight values(2, 5, '12:10:00', '2018:06:10', '7:40:00', 
						  '2018:06:15', 'ORD', 'chicago', 'dallas', 'boeing 767');
insert into flight values(3, 15, '10:40:00', '2018:06:10', '9:30:00', 
						  '2018:06:15', 'ORD', 'chicago', 'dallas', 'boeing 727');
						  
insert into flight values(4, 25, '11:40:00', '2018:06:10', '9:30:00', 
						  '2018:06:15', 'ORD', 'chicago', 'dallas', 'boeing 787');
						  
insert into flight values(5, 35, '13:40:00', '2018:06:10', '11:30:00', 
						  '2018:06:15', 'ORD', 'chicago', 'dallas', 'boeing 727');
						  
insert into seat values(2, 2, 2, 1);

insert into booking values(0, 2, 2, 0,'no baggage', 'economy', 'reserved');
						  
						  
select * 
from logintable 
inner join passenger 
on logintable.username = passenger.username
where logintable.username = 'annie' and logintable.password='123';

select booking_id from booking




select * from flight where depart = ? and destination = ? and depdate = ?;

update passenger
set street = 'top', city = 'kansas'
where pass_id = '2';


