-- Drop user first if they exist
DROP USER if exists 'jwt_example'@'%' ;

-- Now create user with prop privileges
CREATE USER 'jwt_example'@'%' IDENTIFIED BY 'jwt_example';

GRANT ALL PRIVILEGES ON * . * TO 'jwt_example'@'%';