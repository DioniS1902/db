-- DELETE PASSWORD
DROP TRIGGER IF EXISTS passwordCheckDeleteFK;
DELIMITER //
CREATE TRIGGER passwordCheckDeleteFK
BEFORE DELETE
ON passwords FOR EACH ROW
BEGIN
	IF (old.id IN (SELECT password_id from users))
		THEN SIGNAL SQLSTATE "45000"
			SET MESSAGE_TEXT = "Cannot delete password some users are still using it";
    END IF;
END //
DELIMITER ;
-- UPDATE PASSWORD
DROP TRIGGER IF EXISTS regionCheckUpdateFK;
DELIMITER //
CREATE TRIGGER regionCheckUpdateFK
BEFORE UPDATE
ON passwords FOR EACH ROW
BEGIN
	IF (old.id IN (SELECT password_id from users))
		THEN SIGNAL SQLSTATE "45000"
			SET MESSAGE_TEXT = "Cannot update password some user are still using it";
    END IF;
END //
DELIMITER ;

-- INSERT USER

DROP TRIGGER IF EXISTS userCheckInsertFK;
DELIMITER //
CREATE TRIGGER userCheckInsertFK
BEFORE INSERT
ON users FOR EACH ROW
BEGIN
	IF (new.password_id NOT IN (SELECT id from passwords))
		THEN SIGNAL SQLSTATE "45000"
			SET MESSAGE_TEXT = "No such password in table passwords";
    END IF;
    IF (new.id NOT IN (SELECT user_id from user_book))
		THEN SIGNAL SQLSTATE "45000"
			SET MESSAGE_TEXT = "Invalid id no such id in user_book table";
    END IF;
END //
DELIMITER ;

-- UPDATE USER

DROP TRIGGER IF EXISTS userCheckUpdateFK;
DELIMITER //
CREATE TRIGGER userCheckUpdateFK
BEFORE UPDATE
ON users FOR EACH ROW
BEGIN
	IF (new.id NOT IN (SELECT user_id from user_book))
		THEN SIGNAL SQLSTATE "45000"
			SET MESSAGE_TEXT = "Invalid id no such id in user_book table";
    END IF;
    IF (old.id IN (SELECT user_id from user_book))
		THEN SIGNAL SQLSTATE "45000"
			SET MESSAGE_TEXT = "Cannot update user there is fk on id from user_book table";
    END IF;
	IF (new.password_id NOT IN (SELECT id from passwords))
		THEN SIGNAL SQLSTATE "45000"
			SET MESSAGE_TEXT = "No such password in table passwords";
    END IF;
    IF (old.password_id IN (SELECT id from passwords))
		THEN SIGNAL SQLSTATE "45000"
			SET MESSAGE_TEXT = "First delete old password from table";
    END IF;
END //
DELIMITER ;

-- DELETE USER

DROP TRIGGER IF EXISTS userCheckDeleteFK;
DELIMITER //
CREATE TRIGGER userCheckDeleteFK
BEFORE DELETE
ON users FOR EACH ROW
BEGIN
	IF (old.password_id IN (SELECT id from passwords))
		THEN SIGNAL SQLSTATE "45000"
			SET MESSAGE_TEXT = "First delete old password from table";
    END IF;
	IF (old.id IN (SELECT user_id FROM user_book))
		THEN SIGNAL SQLSTATE "45000"
			SET MESSAGE_TEXT = "Cannot delete user there is fk on id from user_book table";
    END IF;
END //
DELIMITER ;

-- INSERT LINK

DROP TRIGGER IF EXISTS linkCheckInsertFK;
DELIMITER //
CREATE TRIGGER linkCheckInsertFK
BEFORE INSERT
ON link FOR EACH ROW
BEGIN
	IF (new.book_id NOT IN (SELECT id from books))
		THEN SIGNAL SQLSTATE "45000"
			SET MESSAGE_TEXT = "No such fk book_id in table books";
    END IF;
    
END //
DELIMITER ;

-- UPDATE LINK

DROP TRIGGER IF EXISTS linkCheckUpdateFK;
DELIMITER //
CREATE TRIGGER linkCheckUpdateFK
BEFORE UPDATE
ON link FOR EACH ROW
BEGIN
	IF (new.book_id NOT IN (SELECT id from books))
		THEN SIGNAL SQLSTATE "45000"
			SET MESSAGE_TEXT = "No such fk book_id in table books";
    END IF;
    IF (old.book_id IN (SELECT id from books))
		THEN SIGNAL SQLSTATE "45000"
			SET MESSAGE_TEXT = "First delete old book from table";
    END IF;
END //
DELIMITER ;

-- DELETE LINK

DROP TRIGGER IF EXISTS linkCheckDeleteFK;
DELIMITER //
CREATE TRIGGER linkCheckDeleteFK
BEFORE DELETE
ON link FOR EACH ROW
BEGIN
	 IF (old.book_id IN (SELECT id from books))
		THEN SIGNAL SQLSTATE "45000"
			SET MESSAGE_TEXT = "First delete old book from table";
    END IF;
END //
DELIMITER ;

-- INSERT DIRECTORY

DROP TRIGGER IF EXISTS directoryCheckInsertFK;
DELIMITER //
CREATE TRIGGER directoryCheckInsertFK
BEFORE INSERT
ON directory_tree FOR EACH ROW
BEGIN
	IF (new.directory_tree_id != null)
		THEN IF (new.directory_tree_id NOT IN (SELECT id from directory_tree))
				THEN SIGNAL SQLSTATE "45000"
				SET MESSAGE_TEXT = "Invalid  directory_tree_id";
			END IF;
    END IF;
    
END //
DELIMITER ;

-- UPDATE DIRECTORY

DROP TRIGGER IF EXISTS directoryCheckUpdateFK;
DELIMITER //
CREATE TRIGGER directoryCheckUpdateFK
BEFORE UPDATE
ON directory_tree FOR EACH ROW
BEGIN
	IF (old.directory_tree_id = null)
		THEN IF (old.directory_tree_id IN (SELECT id from directory_tree WHERE old.directory_tree_id = directory_tree_id))
				THEN SIGNAL SQLSTATE "45000"
				SET MESSAGE_TEXT = "Invalid  directory_tree_id";
			END IF;
    END IF;
    IF (new.directory_tree_id != null)
		THEN IF (new.directory_tree_id NOT IN (SELECT id from directory_tree))
				THEN SIGNAL SQLSTATE "45000"
				SET MESSAGE_TEXT = "Invalid  directory_tree_id";
			END IF;
    END IF;
END //
DELIMITER ;

-- DELETE DIRECTORY

DROP TRIGGER IF EXISTS directoryCheckDeleteFK;
DELIMITER //
CREATE TRIGGER directoryCheckDeleteFK
BEFORE DELETE
ON directory_tree FOR EACH ROW
BEGIN
	 IF (old.directory_tree_id = null)
		THEN IF (old.directory_tree_id IN (SELECT id from directory_tree WHERE old.directory_tree_id = directory_tree_id))
				THEN SIGNAL SQLSTATE "45000"
					SET MESSAGE_TEXT = "Invalid  directory_tree_id";
			END IF;
    END IF;
    IF (old.id IN (SELECT directory_tree_id from books))
		THEN SIGNAL SQLSTATE "45000"
			SET MESSAGE_TEXT = "There is fk to id in book table";
	END IF;
END //
DELIMITER ;

-- INSERT BOOK

DROP TRIGGER IF EXISTS bookCheckInsertFK;
DELIMITER //
CREATE TRIGGER bookCheckInsertFK
BEFORE INSERT
ON books FOR EACH ROW
BEGIN
	IF (new.id NOT IN (SELECT book_id from user_book))
		THEN SIGNAL SQLSTATE "45000"
		SET MESSAGE_TEXT = "Invalid id no such id in user_book table";
    END IF;
    IF (new.directory_tree_id NOT IN (SELECT id from directory_tree))
		THEN SIGNAL SQLSTATE "45000"
			SET MESSAGE_TEXT = "Invalid id no such id in directory_tree table";
    END IF;
    
END //
DELIMITER ;

-- UPDATE BOOK

DROP TRIGGER IF EXISTS bookCheckUpdateFK;
DELIMITER //
CREATE TRIGGER bookCheckUpdateFK
BEFORE UPDATE
ON books FOR EACH ROW
BEGIN
	IF (new.id NOT IN (SELECT book_id from user_book))
		THEN SIGNAL SQLSTATE "45000"
			SET MESSAGE_TEXT = "Invalid id no such id in user_book table";
    END IF;
    IF (new.directory_tree_id NOT IN (SELECT id from directory_tree))
		THEN SIGNAL SQLSTATE "45000"
			SET MESSAGE_TEXT = "Invalid id no such id in directory_tree table";
    END IF;
    
END //
DELIMITER ;

-- DELETE BOOK

DROP TRIGGER IF EXISTS bookCheckDeleteFK;
DELIMITER //
CREATE TRIGGER bookCheckDeleteFK
BEFORE DELETE
ON books FOR EACH ROW
BEGIN
	IF (old.id IN (SELECT book_id from user_book))
		THEN SIGNAL SQLSTATE "45000"
			SET MESSAGE_TEXT = "There is fk to id in user_book table";
    END IF;
    IF (old.id IN (SELECT book_id from link))
		THEN SIGNAL SQLSTATE "45000"
			SET MESSAGE_TEXT = "There is fk to id in link table";
    END IF;
END //
DELIMITER ;

-- USER VALIDATE
DROP TRIGGER IF EXISTS userValid;
DELIMITER //
CREATE TRIGGER userValid
BEFORE INSERT
ON users FOR EACH ROW PRECEDES userCheckInsertFK 
BEGIN
	IF new.rating NOT BETWEEN 1 AND 5
		THEN SIGNAL SQLSTATE "45000"
			SET MESSAGE_TEXT = "rating must be in range[1;5]";
    END IF;
    IF new.login NOT REGEXP '[^0-9|^f].{8}'
		THEN SIGNAL SQLSTATE "45000"
			SET MESSAGE_TEXT = "invalid login";
    END IF;
    
   
END //
DELIMITER ;

-- LOG UPDATE BOOK

DROP TRIGGER IF EXISTS logUpdateBook;
DELIMITER //
CREATE TRIGGER logUpdateBook
AFTER UPDATE
ON books FOR EACH ROW
BEGIN
    INSERT INTO logUpadateBook (time_change) VALUES (now());
END //
DELIMITER ;
