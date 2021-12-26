USE books;

DROP PROCEDURE IF EXISTS InsertBook;
DELIMITER //
CREATE PROCEDURE InsertBook(
	id INT,
	name VARCHAR(45),
    author VARCHAR(45),
    udc FLOAT,
    raiting INT,
    directory_tree_id INT
)
BEGIN
	INSERT INTO books (id,name, author, ucd, raiting, directory_tree_id)
	VALUES (id,name, author, ucd, raiting, directory_tree_id);
END//
DELIMITER ;

DROP PROCEDURE IF EXISTS RandomInsertPassword;
DELIMITER //
CREATE PROCEDURE RandomInsertPassword()
BEGIN
	DECLARE str varchar(45);
	DECLARE counter INT;
    DECLARE exist_seed INT;
    DECLARE seed INT;
	SET str = '', counter = 1, seed = RAND();
    label1:WHILE counter < 11 DO
		SET seed = ((seed+RAND()) + 1) + counter;
		IF NOT EXISTS (SELECT id FROM passwords WHERE seed = id)
		THEN
			SET counter = counter + 1;
            SET str = CONCAT('Noname',seed);
			INSERT INTO passwords(password) VALUES (str);
		END IF;
	END WHILE;
END //
DELIMITER ;


DROP PROCEDURE IF EXISTS CreateTableUserNameCursor;

DELIMITER //
CREATE PROCEDURE CreateTableUserNameCursor()
BEGIN
    DECLARE done INT DEFAULT FALSE;
    DECLARE LastName,FirstName VARCHAR(45);
    DECLARE UserNameCursor CURSOR FOR
    SELECT second_name, first_name FROM users;
    DECLARE CONTINUE HANDLER FOR NOT FOUND
    SET done = TRUE;
    SET @request= 'CREATE TABLE IF NOT EXISTS users_name (id INT AUTO_INCREMENT, second_name VARCHAR(45),first_name VARCHAR(45),PRIMARY KEY (id));';
    PREPARE myQuery FROM @request;
    EXECUTE myQuery;
    OPEN UserNameCursor;
    UserNameCursorLoop: LOOP
        FETCH UserNameCursor INTO LastName,FirstName;
        IF done = TRUE THEN LEAVE UserNameCursorLoop;
        END IF;
        SET @request = CONCAT('INSERT INTO users_name (second_name,first_name) VALUES ("',LastName,'","',FirstName,'");');
		PREPARE myQuery FROM @request;
		EXECUTE myQuery;
    END LOOP;
    DEALLOCATE PREPARE myQuery;
CLOSE UserNameCursor;
END//
DELIMITER ;