create TABLE IF NOT EXISTS questions (
    id   INTEGER  PRIMARY KEY AUTO_INCREMENT,
    text VARCHAR NOT NULL,
    image_url VARCHAR DEFAULT NULL
);

create TABLE IF NOT EXISTS answers (
    id   INTEGER  PRIMARY KEY AUTO_INCREMENT,
    text VARCHAR NOT NULL,
    correct BOOLEAN NOT NULL DEFAULT FALSE,
    question_id INTEGER NOT NULL,
    image_url VARCHAR DEFAULT NULL
);

create TABLE IF NOT EXISTS users (
    name VARCHAR NOT NULL unique
);

create TABLE IF NOT EXISTS user_correct_answers (
    user_name VARCHAR NOT NULL,
    question_id   INTEGER NOT NULL
);

INSERT INTO questions values (1, 'Where does the name Edwyn come from?', 'https://images.pexels.com/photos/3683107/pexels-photo-3683107.jpeg?auto=compress&cs=tinysrgb&w=630&h=375&dpr=1');

INSERT INTO answers values
(1, 'Edwin Hubble', true, 1, null),
(2, 'Vincent cat''s name', false, 1, null),
(3, 'Random word which sounds nice', false, 1, null);

INSERT INTO questions values (2, 'Which tools do we use for internal communication?', null);

INSERT INTO answers values
(4, 'Slack, Gmail', false, 2, null),
(5, 'Teams, Outlook', true, 2, null),
(6, 'Google meets', false, 2, null);

INSERT INTO questions values (3, 'Guess my W', 'https://www.edwyn.tech/wp-content/uploads/2021/08/symbol-07.png');

INSERT INTO answers values
(7, 'Mehdi', false, 3, null),
(8, 'Jerome', true, 3, null),
(9, 'Moustapha', false, 3, null);

INSERT INTO questions values (4, '', 'https://www.edwyn.tech/wp-content/uploads/2021/08/Sujet-10.png');

INSERT INTO answers values
(10, 'Michaël', false, 4, null),
(11, 'Vincent', true, 4, null),
(12, 'Pierrick', false, 4, null);

INSERT INTO users values ('alex');
