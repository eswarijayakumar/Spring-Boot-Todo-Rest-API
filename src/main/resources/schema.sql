DROP TABLE IF EXISTS TODO;

CREATE TABLE TODO (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  todo_name VARCHAR(250) NOT NULL,
  todo_status VARCHAR(250) NOT NULL
);