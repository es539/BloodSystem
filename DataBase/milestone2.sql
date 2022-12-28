create schema systemDB;
use systemDB;

create table civilregistry(
id bigint not null,
    primary key(id)
);
select * from civilregistry;

create table userProfile (
    id bigint NOT null,
    userpassword varchar(50) not null,
    userName varchar(30),
    age int,
    weight int,
    bloodtype char(4),
    address varchar(255),
    city varchar(30),
    region varchar(30),
    primary key (id),
    foreign key (id) references civilregistry(id)
);
select * from userProfile;

create table authoritytax(
	tax char(9) not null,
    primary key(tax)
);
select * from authoritytax;
create table authority(
	tax char(9),
    authpassword varchar(50) not null,
    authName varchar(30),
	email varchar(100),
    phone varchar(11),
    address varchar(266),
    city varchar(30),
    region varchar(30),
    workinghours_start time,
    workinghours_close time,
    donationtimeFrom time,
    donationtimeTo time,
    primary key(tax)
);


select * from authority;

CREATE TABLE bagsNumber (
    tax char(9),
    Aplus_needed INT,
    Aplus_exist INT,
    Aminus_needed INT,
    Aminus_exist INT,
    Bplus_needed INT,
    Bplus_exist INT,
    Bminus_needed INT,
    Bminus_exist INT,
    ABplus_needed INT,
    ABplus_exist INT,
    ABminus_needed INT,
    ABminus_exist INT,
    Oplus_needed INT,
    Oplus_exist INT,
    Ominus_needed INT,
    Ominus_exist INT
);

select * from bagsNumber;

alter table bagsNumber
    ADD constraint FK_1 FOREIGN KEY (tax) references authority (tax) on update cascade on delete cascade;
    
create table regions(
city varchar(30),
    region varchar(30)
    );

insert into regions values ("cairo","Abbassia");
insert into regions values ("cairo","Ain Shams");
insert into regions values ("cairo","Azbakeya");
insert into regions values ("cairo","Bulaq");
insert into regions values ("cairo","Daher");
insert into regions values ("cairo","Al-Darb al-Ahmar");
insert into regions values ("cairo","El Marg");
insert into regions values ("cairo","Helwan");
insert into regions values ("cairo","Mokattam");
insert into regions values ("Giza","Dokki");
insert into regions values ("Giza","Agouza");
insert into regions values ("Giza","Bulaq ad Dakrur");
insert into regions values ("Giza","Imbabah");
insert into regions values ("Giza","Haram");
insert into regions values ("Giza","Omrania");
insert into regions values ("Giza","Monib");
insert into regions values ("Giza","Kafr Tuhurmus");
insert into regions values ("Giza","Faisal");


insert into regions values ("Alexandria","Dekhela");
insert into regions values ("Alexandria","Amreya");
insert into regions values ("Alexandria","Ataren");
insert into regions values ("Alexandria","Gomrok")
;insert into regions values ("Alexandria","Labban");
insert into regions values ("Alexandria","Mansheya");
insert into regions values ("Alexandria","Montaza");
insert into regions values ("Alexandria","El Raml");
insert into regions values ("Alexandria","Bab Sharqi");
insert into regions values ("Alexandria","Borg El Arab");
insert into regions values ("Alexandria","Karmouz");
insert into regions values ("Alexandria","Moharam Bek");
insert into regions values ("Alexandria","Sidi Gaber");
insert into regions values ("Aswan","Abu Simbel");
insert into regions values ("Aswan","Nasser City");
insert into regions values ("Aswan","Aswan 1");
insert into regions values ("Aswan","Aswan 2");
insert into regions values ("Aswan","Daraw");
insert into regions values ("Aswan","Edfu");
insert into regions values ("Aswan","Kom Ombo");
insert into regions values ("Aswan","Aswan");
insert into regions values ("Aswan","Tushka");

insert into regions values ("Luxor","Qurna");
insert into regions values ("Luxor","Armant");
insert into regions values ("Luxor","Esna");
insert into regions values ("Luxor","Tiba");
insert into regions values ("Luxor","Luxor");
insert into regions values ("Sharm El Sheikh","Na'ama Bay");
insert into regions values ("Sharm El Sheikh","Sharks Bay");
insert into regions values ("Sharm El Sheikh","Nabq Bay");
insert into regions values ("Sharm El Sheikh","Ras Um Sid/Hadaba");
insert into regions values ("Sharm El Sheikh","Sharm el-Maya or Old Sharm");

insert into regions values ("Port Said","Al-Ganoub");
insert into regions values ("Port Said","Al-Zohour");
insert into regions values ("Port Said","Al-Dawahy");
insert into regions values ("Port Said","Al-Sharq");
insert into regions values ("Port Said","Al-Manakh");
insert into regions values ("Port Said","Al-Arab");
insert into regions values ("Port Said","Al-Gharb");
insert into regions values ("suez","Arbaeen");
insert into regions values ("suez","Ganayen");
insert into regions values ("suez","Suez");
insert into regions values ("suez","Attaka");
insert into regions values ("suez","Faisal");
insert into regions values ("suez","Port Suez Police Department");
insert into regions values ("Al Fayyum","Faiyum");
insert into regions values ("Al Fayyum","Ibsheway");
insert into regions values ("Al Fayyum","Itsa");
insert into regions values ("Al Fayyum","New Faiyum");
insert into regions values ("Al Fayyum","Sinnuris");
insert into regions values ("Al Fayyum","Tamiya");
insert into regions values ("Al Fayyum","Yousef El Seddik");
select * from authority;
select * from civilregistry;
select * from authoritytax;
UPDATE bagsNumber SET Aplus_exist = 7 WHERE tax = '162359781';

select * from bagsNumber where tax = '162359781';

create table donation(
fromtype varchar(10) not null,
totype varchar(10) not null
);
insert into donation values ('A+','A+');
insert into donation values ('A+','AB+');
insert into donation values ('A-','A+');
insert into donation values ('A-','A-');
insert into donation values ('A-','AB+');
insert into donation values ('A-','AB-');
insert into donation values ('B+','B+');
insert into donation values ('B+','AB+');
insert into donation values ('B-','AB+');
insert into donation values ('B-','AB-');
insert into donation values ('B-','B+');
insert into donation values ('B-','B-');
insert into donation values ('O+','AB+');
insert into donation values ('O+','B+');
insert into donation values ('O+','A+');
insert into donation values ('O+','O+');
insert into donation values ('O-','AB+');
insert into donation values ('O-','AB-');
insert into donation values ('O-','A+');
insert into donation values ('O-','A-');
insert into donation values ('O-','B+');
insert into donation values ('O-','B-');
insert into donation values ('O-','O+');
insert into donation values ('O-','O-');
insert into donation values ('AB+','AB+');
insert into donation values ('AB-','AB+');
insert into donation values ('AB-','AB-');

create table acception(
btype varchar(10) not null,
acceptFrom varchar(10) not null
);
insert into donation values ('A+','A+');
insert into donation values ('A+','A-');
insert into donation values ('A+','O+');
insert into donation values ('A+','O-');
insert into donation values ('A-','A-');
insert into donation values ('A-','O-');
insert into donation values ('B+','O+');
insert into donation values ('B+','B+');
insert into donation values ('B+','O-');
insert into donation values ('B+','B-');

insert into donation values ('B-','B-');
insert into donation values ('B-','O-');
insert into donation values ('AB+','O-');
insert into donation values ('AB+','O+');
insert into donation values ('AB+','AB+');
insert into donation values ('AB+','AB-');
insert into donation values ('AB+','A+');
insert into donation values ('AB+','A-');
insert into donation values ('AB+','B+');
insert into donation values ('AB+','B-');
insert into donation values ('O-','O-');
insert into donation values ('AB-','AB-');
insert into donation values ('AB-','B-');
insert into donation values ('AB-','A-');
insert into donation values ('AB-','O-');
