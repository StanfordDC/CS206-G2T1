create schema cs206;
use cs206;

create table business(
bid int(11) not null primary key,
mid int(11) not null,
name varchar(25) not null,
bwaiting_time varchar(5) not null,
uen varchar(10) not null,
phone_no int(8) not null,
website varchar(60) not null,
password varchar(20) not null,
constraint business_fk foreign key(mid) references mall(bid)
);

 create table shop_tables(
 tid int(11) not null,
 bid int(11) not null,
 type int(1) not null,
 availability tinyint(1),
 constraint tables_pk primary key(tid,bid),
 constraint tables_fk foreign key(bid) references business(bid)
 );
 
 create table mall(
sid int(11) not null primary key,
name varchar(25) not null
 );
 
 create table menu(
mid int(11) not null,
bid int(11) not null,
name varchar(25) not null,
price decimal(5,2) not null,
constraint menu_pk primary key(mid,bid),
constraint menu_fk foreign key(bid) references business(bid)
 );
 
 
create table customers(
cid int(11) not null primary key,
name varchar(25) not null,
email varchar(30),
phone_no int(8),
password varchar(20) not null,
cwaiting_time int(3) not null,
card_no int(16),
card_name varchar(20),
expiry_date varchar(10),
security_code int(4)e

);
 
create table orders(
oid int(11) not null,
bid int(11) not null,
cid int(11) not null,
name varchar(25) not null,
total_price decimal(8,2) not null,
odate datetime not null,
constraint orders_pk primary key(oid,bid,cid),
constraint orders_fk1 foreign key(bid) references business(bid),
constraint orders_fk2 foreign key(cid) references customers(cid)
);


create table food(

);

select * from orders;
 
 
 
 
 
 
 
 
 


