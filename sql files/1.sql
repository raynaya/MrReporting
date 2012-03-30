create table login(loginid varchar2(25),loginpassword  varchar2(20),status number(1));

create table statemaster(statename varchar2(30) constraint pk_statemaster primary key);

create table hqmaster(statename varchar2(30),hqname varchar2(30), constraint pk_hqmaster primary key(statename,hqname));

alter table hqmaster add constraint fk_hqmaster foreign key(statename) references statemaster(statename) ;

create table citymaster(statename varchar2(30),hqname varchar2(30),cityname varchar2(30),constraint pk_citymaster primary key (statename,hqname,cityname));

alter table citymaster add constraint fk_citymaster foreign key(hqname,statename) references hqmaster(hqname,statename) ;


create table areamaster(statename varchar2(30),hqname varchar2(30),cityname varchar2(30),areaname varchar2(20),constraint pk_areamaster primary key(statename,hqname,cityname,areaname));

alter table areamaster add constraint fk_areamaster foreign key(hqname,statename,cityname) references citymaster(hqname,statename,cityname) ;

create table distancemaster(statename varchar2(30),hqname varchar2(30),cityname varchar2(30),from_area varchar2(30),to_area varchar2(30),fromarea varchar2(30),distance number(12,2));



create table degreemaster(degreename varchar2(30) constraint pk_degreemaster primary key );

create table specializationmaster(spl varchar2(30) constraint pk_specialization primary key);

create table chemistmaster(stateCode varchar2(50),hqcode varchar2(50),citycode varchar2(50),areaname varchar2(50),name varchar2(50),addr varchar2(50),dob date,doa date,phone varchar2(50),mobile varchar2(50),marital char(6),sex char(2),constraint pk_chemistmaster primary key(statecode,hqcode,citycode,areaname,name));

create table stockistmaster(statecode varchar2(40),hqcode varchar2(50),citycode varchar2(50),areaname varchar2(50),name varchar2(50),addr varchar2(50),dob date,doa date,phone varchar2(50),mobile varchar2(50),marital char(4), sex char(4),constraint pk_stockistmaster primary key(statecode,hqcode,citycode,areaname,name));


create table productcategorymaster(cat_name varchar2(20) primary key);

create table productmaster(productCategory varchar2(50),productName varchar2(50) primary Key,price Number(15,2));


create table doctormaster(statename varchar2(50),hqname varchar2(50),cityname varchar2(50),areaname varchar2(50),docname varchar2(50),dob date,
sex char(6),grade  char(1),address varchar2(50),doa date,mobile varchar2(50),phoneno varchar2(50),marital varchar2(6),degree varchar2(50),specialization varchar2(50),remarks varchar2(200),constraint pk_doctormaster primary key(statename,hqname,cityname,areaname,docname));

alter table doctormaster add constraint fk_doctormaster foreign key(hqname,statename,cityname,areaname) references areamaster(hqname,statename,cityname,areaname) ;


create table docproducts(statename varchar2(50),hqname varchar2(50),cityname varchar2(50),areaname varchar2(50),docname varchar2(50),productname varchar2(50), constraint pk_docproduct primary key(statename,hqname,cityname,areaname,docname,productname));

alter table docproducts add constraint fk_docproduct foreign key(hqname,statename,cityname,areaname,docname) references doctormaster(hqname,statename,cityname,areaname,docname);

create table groupmaster(groupname varchar2(50),hqname varchar2(50),constraint pk_groupmaster primary key(hqname,groupname)); 



create table usermaster(groupname varchar2(50),hqname varchar2(50),statename varchar2(50),loginid varchar2(20),loginpassword varchar2(20),firstname varchar2(50),lastname varchar2(50),fathername varchar2(50),dob date,mailaddress varchar2(50),parmanentaddress varchar2(50),phonenumber varchar2(50),mobilenumber varchar2(50),sex char(2),maritalstatus char(3),doa date,doj date,basic number(15,2),hra number(15,2),eallowance number(15,2),communication number(15,2),vma number(15,2),cca number(15,2),userstatus char(1));


create table doctor_dcr(groupname varchar2(50),hqname varchar2(50),statename varchar2(50),loginid varchar2(20),dcrdate date,targetdcrdate date,latedcr char(2),areacode varchar2(50),docname varchar2(50),visittype char(1),visitStatus char(1),businessstatus Number(9),prodstatus char(1));

create table docdcrproduct(groupname varchar2(50),hqname varchar2(50),statename varchar2(50),loginid varchar2(20),dcrdate Date,productname varchar2(50),qty Number(5),sample char(1),doctorremark varchar2(200));


create table chemistdcr(groupname varchar2(50),hqname varchar2(50),statename varchar2(50),loginid varchar2(20),dcrdate date,targetdcrdate date,latedcr char(5),
areacode varchar2(50),name varchar2(50),ordernumber number(10),orderamount number(15,2));



create table expense_mr(groupname varchar2(50),hqname varchar2(50),statename varchar2(50),loginid varchar2(20),dcrdate date,targetdcrdate date,
latedcr char(2),areacode varchar2(50),expensetype char(1),amt number(15,2),remarks varchar2(200),approved char(4));


create table primarytarget(groupname varchar2(50),hqname varchar2(50),statename varchar2(50),areacode varchar2(50),loginid varchar2(20),productname varchar2(50),monthlastdate date,qty number(15,2));



