-- DROP TABLE IF EXISTS tb_categories;
CREATE TABLE tb_categories(
	id serial PRIMARY key,
	name VARCHAR(25)
);
-- drop table IF EXISTS tb_articles;
CREATE TABLE tb_articles(
	id serial PRIMARY KEY,
	title VARCHAR(50)  NULL,
	author VARCHAR(20)  NULL,
	description VARCHAR(1000)  NULL,
	image VARCHAR(50)  NULL,
	category_id SMALLINT,
	FOREIGN KEY(category_id) REFERENCES tb_categories(id) on DELETE CASCADE on UPDATE CASCADE
);

