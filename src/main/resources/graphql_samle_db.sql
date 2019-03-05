DROP TABLE book;
DROP TABLE author;
DROP TABLE publisher;

CREATE TABLE author (
  author_id INTEGER PRIMARY KEY,
  forename VARCHAR(30),
  lastname VARCHAR(30)
);

CREATE TABLE publisher (
  publisher_id INTEGER PRIMARY KEY,
  company_name VARCHAR(40),
  zip INTEGER,
  city VARCHAR(30)
);

CREATE TABLE book (
  isbn INTEGER PRIMARY KEY,
  title VARCHAR(30),
  pages INTEGER,
  author INTEGER,
  publisher INTEGER,
  FOREIGN KEY (author) REFERENCES author(author_id),
  FOREIGN KEY (publisher) REFERENCES publisher(publisher_id)
);

START TRANSACTION;
INSERT INTO author(author_id,forename,lastname) VALUES
	(1,'Stephen','King'),
    (2,'Bram','Stoker');
INSERT INTO publisher(publisher_id,company_name,zip,city) VALUES
	(1,'Anaconda Verlag GmbH',50827,'Köln'),
    (2,'Bastei Lübbe AG',51063,'Köln');
INSERT INTO book(isbn,title,pages,author,publisher) VALUES
	(72938,'Dacula',502,2,1),
    (30085,'Shining',624,1,2),
    (35797,'Friedhof der Kuscheltiere',608,1,2);
COMMIT;