create schema cs206;
use cs206;

create table business(
bid int(11) not null primary key,
name varchar(25) not null,
bwaiting_time int(3) not null
);

 create table shop_tables(
 tid int(11) not null,
 bid int(11) not null,
 type int(1) not null,
 availability tinyint(1),
 constraint tables_pk primary key(tid,bid),
 constraint tables_fk foreign key(bid) references business(bid)
 );
 
 create table shopping_mall(
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
cwaiting_time int(3) not null
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

select * from orders;
 
 
 
 
 
 
 
 
 


