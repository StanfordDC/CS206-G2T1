use cs206;

create table business(
bid bigint not null primary key,
uen varchar(10) not null,
name varchar(255) not null,
password varchar(20) not null,
phone_no int not null,
sid bigint not null,
bwaiting_time varchar(7) not null,
website varchar(255)
);

create table customers(
cid bigint not null primary key,
card_name varchar(255) not null,
card_no bigint not null,
email varchar(255) not null,
expiry_date date not null,
name varchar(255) not null,
password varchar(20) not null,
phone_no int not null
);

create table food(
fid bigint not null primary key,
availability bit(1) not null,
mid bigint not null not null,
name varchar(255) not null,
price float not null
);

create table mall(
sid bigint not null primary key,
name varchar(255) not null
 );
 
create table menu(
mid bigint not null primary key,
bid bigint not null,
price float not null
 );
 
create table order_food(
ofid bigint not null primary key,
fid bigint not null,
quantity int
 );
 
create table orders(
oid bigint not null primary key,
bid bigint not null,
cid bigint not null,
odate datetime(6) not null,
order_status int not null,
pax int not null,
payment_status int not null,
total_price float not null,
cwaiting_time varchar(7) not null
 );
 
create table shop_tables(
tid bigint not null primary key,
availability bit(1) not null,
bid bigint not null,
type int not null
 );
 
create table waiting_time_history(
wid bigint not null primary key,
bid bigint not null,
pax int not null,
type int not null,
waiting_time varchar(7) not null
 );