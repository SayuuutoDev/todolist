
CREATE TABLE IF NOT EXISTS  users (
	user_id integer PRIMARY KEY auto_increment,
	image varchar(255) NULL,
	name varchar(255) NULL
);

CREATE TABLE IF NOT EXISTS  tasks (
	status bool NULL,
	task_id integer PRIMARY KEY auto_increment,
	user_id integer NULL,
	description varchar(255) NULL,
	title varchar(255) NOT NULL
);

