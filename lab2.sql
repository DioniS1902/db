SELECT model,
       speed
FROM   pc
WHERE  price >= 400
       AND price <= 600
ORDER  BY hd;

SELECT date
FROM   pass_in_trip
WHERE  place LIKE "1%";

SELECT DISTINCT product.model,
                product.maker,
                pc.price
FROM   product
       LEFT JOIN pc
              ON pc.model = product.model;

SELECT DISTINCT maker
FROM   product
WHERE  product.type = 'Printer'
       AND maker IN(SELECT product.maker
                    FROM   pc
                           INNER JOIN product
                                   ON pc.model = product.model
                    WHERE  pc.ram = (SELECT Min(pc.ram)
                                     FROM   pc));

SELECT Date_format(date, '%Y.%m.%d') AS date
FROM   income;

SELECT date,
       Count((SELECT trip_no
              FROM   trip
              WHERE  Date(trip.time_out) LIKE Date(pass_in_trip.date)
                     AND trip.town_to = 'London')) AS count_of_trips
FROM   pass_in_trip
GROUP  BY date;

SELECT ship,
       (SELECT (SELECT numguns
                FROM   classes
                WHERE  classes.class = ships.class)
        FROM   ships
        WHERE  NAME = ship) AS numGuns,
       (SELECT (SELECT displacement
                FROM   classes
                WHERE  classes.class = ships.class)
        FROM   ships
        WHERE  NAME = ship) AS displacement
FROM   outcomes
WHERE  battle = 'Guadalcanal'
GROUP  BY ship;

SELECT outcome_o.point,
       outcome_o.date,
       outcome_o.out,
       income_o.inc
FROM   outcome_o
       LEFT OUTER JOIN income_o
                    ON outcome_o.point = income_o.point
                       AND outcome_o.date = income_o.date
GROUP  BY point,
          date;

SELECT ship
FROM   outcomes
WHERE  ( Length(ship) - Length(Replace(ship, ' ', '')) ) > 0
UNION
SELECT NAME AS ship
FROM   ships
WHERE  ( Length(NAME) - Length(Replace(NAME, ' ', '')) ) > 0; 