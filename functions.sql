USE books;

DROP function IF EXISTS AvgRating;
DELIMITER //
CREATE FUNCTION AvgRating()
RETURNS INT READS SQL DATA
BEGIN
	RETURN (SELECT AVG(rating) FROM users);
END//
DELIMITER ;
SELECT AvgRating();

DROP function IF EXISTS GetPasswordFromUser;

DELIMITER //
CREATE FUNCTION GetPasswordFromUser(userID int)
RETURNS varchar(45) READS SQL DATA
BEGIN
    RETURN (SELECT password FROM passwords WHERE id = ANY(SELECT password_id FROM users where id = userID));
END//
DELIMITER ;

SELECT *,GetPasswordFromUser(id) FROM users;