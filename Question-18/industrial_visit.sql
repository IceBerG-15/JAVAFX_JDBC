create table industrial_visit(
reg_no VARCHAR2(10) PRIMARY KEY,
name VARCHAR2(10) not NULL,
contact NUMBER(10) CHECK (LENGTH(contact)=10),
blood_grp VARCHAR2(3),
student_type VARCHAR2(15) CHECK (student_type in ('hosteller','day-scholer')),
willingness VARCHAR2(3) check (willingness in ('no','yes'))
);

insert into industrial_visit VALUES('&reg_no','&name',&contact,'&blood_grp','&student_type','&willingness');