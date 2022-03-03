create schema cs206;
use cs206;

create table mall(
sid int not null primary key,
name varchar(25) not null
 );

create table business(
bid int not null primary key,
sid int not null,
name varchar(25) not null,
bwaiting_time varchar(5) not null,
uen varchar(10) not null,
phone_no int not null,
website varchar(60) not null,
password varchar(20) not null,
constraint business_fk foreign key(sid) references mall(sid)
);

 create table shop_tables(
 tid int not null,
 bid int not null,
 type int not null,
 availability tinyint(1),
 constraint tables_pk primary key(tid,bid),
 constraint tables_fk foreign key(bid) references business(bid)
 );
 

 
 create table menu(
mid int not null,
bid int not null,
name varchar(25) not null,
constraint menu_pk primary key(mid),
constraint menu_fk foreign key(bid) references business(bid)
 );
 
 
create table customers(
cid int not null primary key,
name varchar(25) not null,
email varchar(30),
phone_no int,
password varchar(20) not null,
card_no int,
card_name varchar(20),
expiry_date varchar(10),
security_code int

);
 
create table orders(
oid int not null,
bid int not null,
cid int not null,
name varchar(25) not null,
total_price decimal(8,2) not null,
odate datetime not null,
cwaiting_time int not null,
pax int not null,
order_status int,
refund_status int,
constraint orders_pk primary key(oid),
constraint orders_fk1 foreign key(bid) references business(bid),
constraint orders_fk2 foreign key(cid) references customers(cid)
);


create table waiting_time_history(
wid int not null primary key,
bid int not null,
type int not null,
waiting_time int not null,
pax int not null,
constraint waiting_time_history_fk1 foreign key(bid) references business(bid)
);

create table food(
fid int not null primary key,
mid int not null,
name varchar(15) not null,
price decimal(8,2) not null,
availability tinyint(1),
constraint food_fk foreign key(mid) references menu(mid)
);

create table order_food(
fid int not null,
oid int not null,
quantity int not null,
constraint order_food_pk primary key(fid,oid),
constraint order_food_fk1 foreign key(fid) references food(fid),
constraint order_food_fk2 foreign key(oid) references orders(oid)

);

select * from orders;
 
 
 
 

 

 



