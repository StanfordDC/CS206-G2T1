use cs206;

create table business(
bid BIGINT not null auto_increment primary key,
uen varchar(10),
name varchar(255) not null,
password varchar(20) not null,
phone_no int not null,
sid bigint not null,
no_of_2pax int,
no_of_5pax int,
bwaiting_time_2pax datetime,
bwaiting_time_5pax datetime,
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
bid bigint not null,
availability bit(1) not null,
name varchar(255) not null,
price float not null,
quantity int not null,
image blob not null
);

create table mall(
sid bigint not null primary key,
name varchar(255) not null
 );
 
create table order_food(
ofid bigint not null primary key,
oid bigint not null,
fid bigint not null,
name varchar(255) not null,
price float not null,
quantity int not null,
image blob not null
 );
 
create table orders(
oid bigint not null auto_increment primary key,
bid bigint not null,
cid bigint not null,
odate datetime,
order_status int not null,
pax int not null,
payment_status int not null,
total_price float not null,
cwaiting_time datetime
 );
 
create table shop_tables(
tid bigint not null auto_increment primary key,
bid bigint not null,
availability bit(1),
type int not null,
twaiting_time datetime,
FOREIGN KEY (bid) REFERENCES business(bid)
 );
 
create table waiting_time_history(
wid bigint not null primary key,
bid bigint not null,
pax int not null,
type int not null,
waiting_time varchar(7) not null
 );
