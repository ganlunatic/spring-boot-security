insert into user_info(id,username,password) values (1,'001','123001');
insert into user_info(id,username,password) values (2,'002','123002');
insert into user_info(id,username,password) values (3,'003','123003');
insert into user_info(id,username,password) values (4,'004','123004');


INSERT into role_info(id,name) values (1,'normal');
INSERT into role_info(id,name) values (2,'admin');

insert into user_role_relation (id,user_id,role_id) values (1,1,1);
insert into user_role_relation (id,user_id,role_id) values (2,2,1);
insert into user_role_relation (id,user_id,role_id) values (3,3,1);
insert into user_role_relation (id,user_id,role_id) values (4,4,2);