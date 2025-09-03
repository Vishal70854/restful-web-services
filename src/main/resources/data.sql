INSERT INTO user_details(birth_date, id, name)
VALUES ('1995-08-15', 1001, 'Vishal');

INSERT INTO user_details(birth_date, id, name)
VALUES ('1995-01-20', 1002, 'gaurav');

INSERT INTO user_details(birth_date, id, name)
VALUES ('1995-04-25', 1003, 'shivam');

INSERT INTO post(id, description, user_id)
VALUES(2001, 'I want to learn AWS', 1001);

INSERT INTO post(id, description, user_id)
VALUES(2002, 'I want to learn Dev ops', 1001);
--
INSERT INTO post(id, description, user_id)
VALUES(2003, 'I want to get Certified in Gcp', 1002);

INSERT INTO post(id, description, user_id)
VALUES(2004, 'I want to learn python', 1003);