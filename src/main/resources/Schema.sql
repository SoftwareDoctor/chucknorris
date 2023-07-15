DROP schema chucknorris;
CREATE schema chucknorris;
USE chucknorris;

CREATE TABLE battuta (
	id INT PRIMARY KEY AUTO_INCREMENT,
    value VARCHAR(3000) NOT NULL,
    updated_at DATE NOT NULL
    );
