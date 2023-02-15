INSERT INTO user (id,email, firstName, lastName, password) VALUES (1,'admin@admin.com','admin','admin','admin');
INSERT INTO role(id, Name) VALUES (1,'ROLE_ADMIN');
INSERT INTO user_roles(fk_user, fk_role) VALUES (1,1);