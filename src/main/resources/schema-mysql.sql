DROP TABLE IF EXISTS user_info;
create table user_info(
  id bigint not null PRIMARY KEY ,
  username varchar(32) not null,
  password varchar(32) not null
);

DROP TABLE IF EXISTS role_info;
create table role_info(
  id bigint not null PRIMARY KEY ,
  name varchar(32)
);

DROP TABLE IF EXISTS user_role_relation;
create table user_role_relation(
  id bigint not null PRIMARY KEY ,
  user_id bigint not null,
  role_id bigint not null
);


