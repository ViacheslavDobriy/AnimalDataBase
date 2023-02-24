USE animal_nursery;
CREATE TABLE CATS
(
catId INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
catName CHAR(20) NOT NULL,
birthDate DATE NOT NULL,
commands TEXT
);

INSERT INTO animal_nursery.CATS (catName, birthDate, commands)
VALUES
	('барсик', '2020-12-01', "драть диван, обижать тапки, носиться как бешеный"),
    ('персик', '2019-02-22', "драть диван, обижать тапки, носиться как бешеный"),
    ('мурзик', '2018-06-12', "драть диван, обижать тапки, носиться как бешеный"),
    ('котофей', '2016-10-11', "драть диван, носиться как бешеный"),
    ('барсик', '2022-03-14', "драть диван, обижать тапки"),
    ('барсик', '2021-08-12', "носиться как бешеный"),
    ('вася', '2023-01-01', "носиться как бешеный, спать как убитый");

CREATE TABLE DOGS
(
dogId INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
dogName CHAR(20) NOT NULL,
birthDate DATE NOT NULL,
commands TEXT
);

INSERT INTO animal_nursery.DOGS (dogName, birthDate, commands)
VALUES
	('барбос', '2018-12-01', "лапу, место, лежать, голос"),
    ('шарик', '2015-02-22', "лапу, место, лежать"),
    ('дружок', '2012-06-12', "лапу, лежать, голос"),
    ('рекс', '2016-10-11', "место, лежать, голос"),
    ('пушок', '2018-03-14', "лапу, место, голос"),
    ('мощный', '2017-08-12', "лапу, место"),
    ('адский сатана', '2016-01-01', "храпеть как проклятый, жрать в три горла");

CREATE TABLE HAMSTERS
(
hamsterId INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
hamsterName CHAR(20) NOT NULL,
birthDate DATE NOT NULL,
commands TEXT
);

INSERT INTO animal_nursery.HAMSTERS (hamsterName, birthDate, commands)
VALUES
	('хомяк', '2020-12-01', "жевать, пугаться не по делу, размножаться"),
    ('хомяк', '2021-02-22', "жевать, пугаться не по делу, размножаться"),
    ('хомяк', '2020-06-12', "жевать, пугаться не по делу, размножаться"),
    ('хомяк', '2021-10-11', "жевать, пугаться не по делу, размножаться"),
    ('хомяк', '2020-03-14', "жевать, пугаться не по делу, размножаться"),
    ('хомяк', '2021-08-12', "жевать, пугаться не по делу, размножаться"),
    ('адский хомяк', '2022-01-01', "жевать, пугаться не по делу, размножаться, жрать как не в себя");

CREATE TABLE HORSES
(
horseId INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
horseName CHAR(20) NOT NULL,
birthDate DATE NOT NULL,
commands TEXT
);

INSERT INTO animal_nursery.HORSES (horseName, birthDate, commands)
VALUES
	('конь', '2012-12-01', "бежать быстро, бежать медленно"),
    ('лошадь', '2013-02-22', "бежать быстро, бежать медленно"),
    ('конь', '2015-06-12', "бежать быстро, бежать медленно"),
    ('лошадь', '2018-10-11', "бежать быстро, бежать медленно"),
    ('конь', '2020-03-14', "бежать быстро, бежать медленно"),
    ('лошадь', '2010-08-12', "бежать быстро, бежать медленно"),
    ('одичалый конь', '2005-01-01', "жевать, бежать быстро, бежать медленно, жрать как не в себя");


CREATE TABLE CAMELS
(
camelId INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
camelName CHAR(20) NOT NULL,
birthDate DATE NOT NULL,
commands TEXT
);

INSERT INTO animal_nursery.CAMELS (camelName, birthDate, commands)
VALUES
	('верблюд', '2005-12-01', "бежать быстро, бежать медленно, плеваться"),
    ('жора', '1821-02-22', "бежать быстро, бежать медленно, плеваться"),
    ('игнат', '2012-06-12', "бежать быстро, бежать медленно, плеваться"),
    ('верблюд', '2022-10-11', "бежать быстро, бежать медленно"),
    ('верблюд', '2015-03-14', "бежать быстро, бежать медленно"),
    ('верблюд', '2012-08-12', "бежать быстро, бежать медленно"),
    ('спортивный верблюд', '2020-01-01', "жевать, бежать очень быстро, жрать как не в себя, плеваться");

CREATE TABLE DONKEYS
(
donkeylId INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
doonkeyName CHAR(20) NOT NULL,
birthDate DATE NOT NULL,
commands TEXT
);

INSERT INTO animal_nursery.DONKEYS (doonkeyName, birthDate, commands)
VALUES
	('осёл', '2005-12-01', "не упрямиться, тащить телегу"),
    ('гена', '1821-02-22', "не упрямиться, тащить телегу"),
    ('акакий', '2012-06-12', "не упрямиться, тащить телегу"),
    ('осёл', '2022-10-11', "не упрямиться, тащить телегу"),
    ('осёл почти верблюд', '2015-03-14', "не упрямиться, тащить телегу"),
    ('осёл', '2012-08-12', "не упрямиться, тащить телегу"),
    ('самостоятельный осёл', '2020-01-01', "торговать на бирже, не упрямиться");

SELECT *, FORMAT(DATEDIFF(NOW(), birthDate)/360, 1) as возраст FROM DOGS;

# Объединить таблицы Лошади и ослы в одну таблицу.
SELECT * FROM HORSES
UNION
SELECT * FROM DONKEYS;

#  Создать новую таблицу “молодые животные” в которую попадут все
# животные старше 1 года, но младше 3 лет и в отдельном столбце с точностью
# до месяца подсчитать возраст животных в новой таблице

CREATE TABLE молодые_животные SELECT * FROM
(
SELECT catId as id, catName as имя, birthDate as дата_рождения, commands as выполняемые_команды, FORMAT(DATEDIFF(NOW(), birthDate)/360, 1) as возраст
FROM CATS
WHERE birthDate BETWEEN DATE_SUB(NOW(), INTERVAL 3 YEAR) AND DATE_SUB(NOW(), INTERVAL 1 YEAR)

UNION

SELECT *, FORMAT(DATEDIFF(NOW(), birthDate)/360, 1) as возраст
FROM DOGS WHERE birthDate BETWEEN DATE_SUB(NOW(), INTERVAL 3 YEAR) AND DATE_SUB(NOW(), INTERVAL 1 YEAR)

UNION

SELECT *, FORMAT(DATEDIFF(NOW(), birthDate)/360, 1) as возраст FROM HAMSTERS
WHERE birthDate BETWEEN DATE_SUB(NOW(), INTERVAL 3 YEAR) AND DATE_SUB(NOW(), INTERVAL 1 YEAR)

UNION

SELECT *, FORMAT(DATEDIFF(NOW(), birthDate)/360, 1) as возраст FROM HORSES
WHERE birthDate BETWEEN DATE_SUB(NOW(), INTERVAL 3 YEAR) AND DATE_SUB(NOW(), INTERVAL 1 YEAR)

UNION

SELECT *, FORMAT(DATEDIFF(NOW(), birthDate)/360, 1) as возраст FROM CAMELS
WHERE birthDate BETWEEN DATE_SUB(NOW(), INTERVAL 3 YEAR) AND DATE_SUB(NOW(), INTERVAL 1 YEAR)

UNION

SELECT *, FORMAT(DATEDIFF(NOW(), birthDate)/360, 1) as возраст FROM DONKEYS
WHERE birthDate BETWEEN DATE_SUB(NOW(), INTERVAL 3 YEAR) AND DATE_SUB(NOW(), INTERVAL 1 YEAR)
) as базовые_данные;

SELECT * FROM молодые_животные;