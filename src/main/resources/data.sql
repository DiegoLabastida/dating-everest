
INSERT INTO tbl_profile(id,first_name,last_name,profession,balance,type) VALUES (1,'Harry','Potter','Wizard',1150,'client');
INSERT INTO tbl_profile(id,first_name,last_name,profession,balance,type) VALUES (2,'Mr','Robot','Hacker',231.11,'client');
INSERT INTO tbl_profile(id,first_name,last_name,profession,balance,type) VALUES (3,'John','Snow','Knows nothing',451.3,'client');
INSERT INTO tbl_profile(id,first_name,last_name,profession,balance,type) VALUES (4,'Ash','Kethcum','Pokemon master',1.3,'client');
INSERT INTO tbl_profile(id,first_name,last_name,profession,balance,type) VALUES (5,'John','Lenon','Musician',64,'contractor');
INSERT INTO tbl_profile(id,first_name,last_name,profession,balance,type) VALUES (6,'Linus','Torvalds','Programmer',1214,'contractor');
INSERT INTO tbl_profile(id,first_name,last_name,profession,balance,type) VALUES (7,'Alan','Turing','Programmer',22,'contractor');
INSERT INTO tbl_profile(id,first_name,last_name,profession,balance,type) VALUES (8,'Aragorn','II Elessar Telcontarvalds','Fighter',314,'contractor');

INSERT INTO tbl_contract(id,terms,status,profile_client_id,profile_contractor_id) VALUES (1,'bla bla bla','terminated',1,5);
INSERT INTO tbl_contract(id,terms,status,profile_client_id,profile_contractor_id) VALUES (2,'bla bla bla','in_progress',1,6);
INSERT INTO tbl_contract(id,terms,status,profile_client_id,profile_contractor_id) VALUES (3,'bla bla bla','in_progress',2,6);
INSERT INTO tbl_contract(id,terms,status,profile_client_id,profile_contractor_id) VALUES (4,'bla bla bla','in_progress',2,7);
INSERT INTO tbl_contract(id,terms,status,profile_client_id,profile_contractor_id) VALUES (5,'bla bla bla','new',3,8);
INSERT INTO tbl_contract(id,terms,status,profile_client_id,profile_contractor_id) VALUES (6,'bla bla bla','in_progress',3,7);
INSERT INTO tbl_contract(id,terms,status,profile_client_id,profile_contractor_id) VALUES (7,'bla bla bla','in_progress',4,7);
INSERT INTO tbl_contract(id,terms,status,profile_client_id,profile_contractor_id) VALUES (8,'bla bla bla','in_progress',4,6);
INSERT INTO tbl_contract(id,terms,status,profile_client_id,profile_contractor_id) VALUES (9,'bla bla bla','in_progress',4,8);

INSERT INTO tbl_job(description,price,contract_Id,paid,payment_date) VALUES ('work',200,1,NULL,NULL);
INSERT INTO tbl_job(description,price,contract_Id,paid,payment_date) VALUES ('work',201,2,NULL,NULL);
INSERT INTO tbl_job(description,price,contract_Id,paid,payment_date) VALUES ('work',202,3,NULL,NULL);
INSERT INTO tbl_job(description,price,contract_Id,paid,payment_date) VALUES ('work',200,4,NULL,NULL);
INSERT INTO tbl_job(description,price,contract_Id,paid,payment_date) VALUES ('work',200,7,NULL,NULL);
INSERT INTO tbl_job(description,price,contract_Id,paid,payment_date) VALUES ('work',2020,7,'true','2020-08-15T19:11:26.737Z');
INSERT INTO tbl_job(description,price,contract_Id,paid,payment_date) VALUES ('work',200,2,'true','2020-08-15T19:11:26.737Z');
INSERT INTO tbl_job(description,price,contract_Id,paid,payment_date) VALUES ('work',200,3,'true','2020-08-16T19:11:26.737Z');
INSERT INTO tbl_job(description,price,contract_Id,paid,payment_date) VALUES ('work',200,1,'true','2020-08-17T19:11:26.737Z');
INSERT INTO tbl_job(description,price,contract_Id,paid,payment_date) VALUES ('work',200,5,'true','2020-08-17T19:11:26.737Z');
INSERT INTO tbl_job(description,price,contract_Id,paid,payment_date) VALUES ('work',21,1,'true','2020-08-10T19:11:26.737Z');
INSERT INTO tbl_job(description,price,contract_Id,paid,payment_date) VALUES ('work',21,2,'true','2020-08-15T19:11:26.737Z');
INSERT INTO tbl_job(description,price,contract_Id,paid,payment_date) VALUES ('work',121,3,'true','2020-08-15T19:11:26.737Z');
INSERT INTO tbl_job(description,price,contract_Id,paid,payment_date) VALUES ('work',121,3,'true','2020-08-14T23:11:26.737Z');
