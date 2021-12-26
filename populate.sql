USE books;

INSERT INTO passwords (password) VALUES
('Aeln4ujey'),
('Wec007Aboba'),
('@poiuera#21234'),
('babas$6ojas82'),
('l!kincye1337');

INSERT INTO user_book (book_id, user_id) VALUES 
(1, 5),
(2, 4),
(3, 1),
(4, 2),
(5, 3);

INSERT INTO directory_tree (rubric, directory_tree_id) VALUES 
("novel", null),
("adventures", null),
("fantasy", null),
("romance novel", 1),
("horror novel", 1),
("fantasy horror", 3),
("fantasy drama", 3);

INSERT INTO users (
id,
login,
second_name, 
first_name, 
patronymic, 
birth_date,
birth_place, 
place_of_residence, 
note, 
rating, 
password_id) 
VALUES
(1,'yyasasrrr', 'Zmishenko', 'Valeriy', 'Albertovich', "2000-06-18", 'Zmierenka', 'Kyiv', 'topUser', 3, 1), 
(2,'wectrorrr', 'Andriy', 'Shumskiy', 'Vasylovich', "2003-04-03", 'Lviv', 'Lviv', 'abobus', 4, 2), 
(3,'eaglerrrr', 'Oleksandr', 'Chupka', 'Olegovich', "2002-08-01", 'Brody', 'Lviv', 'topUser', 3, 3),
(4,'tintrrrrr', 'Arsen', 'Trostinovich', 'Maximovich', "1986-07-05", 'Kyiv', 'Lviv', 'wisdom', 4, 4),  
(5,'ioandrrrr', 'Denis', 'Chuchanskiy', 'Valeriyovich', "2000-09-15", 'Odessa', 'Odessa', 'abobus', 4, 5);

INSERT INTO books.books (
id,
name, 
author, 
udc, 
raiting, 
directory_tree_id
) VALUES
(1,'Wonderful Wonder World', 'Quin Rose', 172.22, 4, 1),
(2,'Harry Potter', 'Joan Rawling', 654.12, 5, 2),
(3,'Kobzar', 'Taras Shevchenko', 777.15, 5, 3),
(4,'451 degrees Fahrenheit', 'Ray Bradbury', 465.82, 3, 4),
(5,'Dandelion wine', 'Ray Bradbury', 355.82, 4, 5);

INSERT INTO link (book_email_address, book_id) VALUES 
('wowowo@gmail.com', 1),
('harypotter@gmail.com', 2),
('kobzartop@gmail.com', 3),
('451degfar@gmail.com', 4),
('danwi@gmail.com', 5);
