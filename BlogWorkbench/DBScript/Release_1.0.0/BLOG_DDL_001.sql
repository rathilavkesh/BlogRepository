create table COUNTRY
(
	COUNTRY_ID int(4) not null AUTO_INCREMENT,
	NAME varchar(100),
	primary key (COUNTRY_ID)
);

create table ROLE
(
	ROLE_ID int(2) not null AUTO_INCREMENT,
	ROLE_NAME varchar(50) not null,
	primary key (ROLE_ID)
);

create table USER
(
	USER_ID int(20) not null AUTO_INCREMENT,
	FIRST_NAME varchar(50) NOT NULL,
	LAST_NAME varchar(50) not null,
	EMAIL varchar(100) not null,
	PASSWORD varchar(15) not null,
	ROLE_ID int(20),
    IS_ACTIVE boolean not null default true,
    CREATED_DATE datetime not null,
    UPDATED_DATE datetime,
	primary key (USER_ID),
	CONSTRAINT FK_USER_ROLE FOREIGN KEY (ROLE_ID) REFERENCES ROLE (ROLE_ID)	
);

create table USER_DETAILS
(
	USER_DETAILS_ID int(20) not null,    
	OCCUPATION varchar(100),
	COMPANY varchar(100),
    COUNTRY_ID int(4) not null,
    CITY varchar(100),
    STATE varchar(100),
    ZIP_CODE varchar(10),
	unique key (USER_DETAILS_ID),
    CONSTRAINT FK_USER_DETAILS_COUNTRY FOREIGN KEY (COUNTRY_ID) REFERENCES COUNTRY (COUNTRY_ID),
    CONSTRAINT FK_USER_DETAILS_USER FOREIGN KEY (USER_DETAILS_ID) REFERENCES USER (USER_ID)
);

create table BLOG
(
	BLOG_ID int(20) not null,
	DESCRIPTION varchar(500),
	CONTENT TEXT not null,
	TYPE CHAR(1) not null,
	expiry_period int(20),
	IS_VERIFIED int(1),
    SUBMITTED_BY int(20) not null,	
	SUBMITTED_DATE datetime not null,
    UPDATED_BY int(20) not null,	
	UPDATED_DATE datetime not null,
	primary key (BLOG_ID),
    CONSTRAINT FK_BLOG_SUBMIT_USER FOREIGN KEY (SUBMITTED_BY) REFERENCES USER (USER_ID),
    CONSTRAINT FK_BLOG_UPDATE_USER FOREIGN KEY (UPDATED_BY) REFERENCES USER (USER_ID)
);

create table BLOG_TRAIL
(
	BLOG_TRAIL_ID int(20) not null,
    BLOG_ID int(20) not null,
	CONTENT TEXT not null,
	PARENT_ID int(20),
    SUBMITTED_BY int(20) not null,	
	SUBMITTED_DATE datetime not null,
	primary key (BLOG_TRAIL_ID),
    CONSTRAINT FK_BLOCK_TRAIL_BLOG FOREIGN KEY (BLOG_ID) REFERENCES BLOG (BLOG_ID),
    CONSTRAINT FK_BLOCK_TRAIL_SUBMIT_USER FOREIGN KEY (SUBMITTED_BY) REFERENCES USER (USER_ID),
    CONSTRAINT FK_BLOCK_TRAIL_PARENT FOREIGN KEY (PARENT_ID) REFERENCES BLOG_TRAIL (BLOG_ID)
);

-- removed created by and created date from below table
create table TAG
(
	TAG_ID int(20) not null,
	TAG_NAME varchar(50),
	primary key (TAG_ID)
);

create table BLOG_TAG_MAPPING
(
	BLOG_ID int(20),
	TAG_ID int(20),
    unique key (BLOG_ID, TAG_ID),
    CONSTRAINT FK_BLOG_TAG_MAPPING_BLOG FOREIGN KEY (BLOG_ID) REFERENCES BLOG (BLOG_ID),
    CONSTRAINT FK_BLOG_TAG_MAPPING_TAG FOREIGN KEY (TAG_ID) REFERENCES TAG (TAG_ID)
);







