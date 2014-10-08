INSERT INTO t_users(username,password,enabled)
VALUES ('admin','123456', TRUE);
INSERT INTO t_users(username,password,enabled)
VALUES ('user1','123456', TRUE);
 
INSERT INTO t_user_roles (username, ROLE)
VALUES ('user1', 'ROLE_USER');
INSERT INTO t_user_roles (username, ROLE)
VALUES ('admin', 'ROLE_ADMIN');
INSERT INTO t_user_roles (username, ROLE)
VALUES ('admin', 'ROLE_USER');