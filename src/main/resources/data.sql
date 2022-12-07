create TABLE IF NOT EXISTS questions (
    id   INTEGER  PRIMARY KEY AUTO_INCREMENT,
    type VARCHAR NOT NULL,
    text VARCHAR NOT NULL,
    image_url VARCHAR
);

create TABLE IF NOT EXISTS answers (
    id   INTEGER  PRIMARY KEY AUTO_INCREMENT,
    type VARCHAR NOT NULL,
    text VARCHAR NOT NULL,
    correct BOOLEAN NOT NULL DEFAULT FALSE,
    question_id INTEGER NOT NULL
);

INSERT INTO questions values (1, 'TEXT', 'Where does the name Edwyn come from?', 'https://images.pexels.com/photos/3683107/pexels-photo-3683107.jpeg?auto=compress&cs=tinysrgb&w=630&h=375&dpr=1');

INSERT INTO answers values
(1, 'TEXT', 'Edwin Hubble', true, 1),
(2, 'TEXT', 'Vincent cat''s name', false, 1),
(3, 'TEXT', 'Random word which sounds nice', false, 1);

INSERT INTO questions values (2, 'TEXT', 'Which tools do we use for internal communication?', null);

INSERT INTO answers values
(4, 'TEXT', 'Slack, Gmail', false, 2),
(5, 'TEXT', 'Teams, Outlook', true, 2),
(6, 'TEXT', 'Google meets', false, 2);
