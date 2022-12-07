create TABLE IF NOT EXISTS questions (
    id   INTEGER  PRIMARY KEY AUTO_INCREMENT,
    text VARCHAR NOT NULL,
    image_url VARCHAR
);

create TABLE IF NOT EXISTS answers (
    id   INTEGER  PRIMARY KEY AUTO_INCREMENT,
    text VARCHAR NOT NULL,
    correct BOOLEAN NOT NULL DEFAULT FALSE,
    question_id INTEGER NOT NULL
);

INSERT INTO questions values (1, 'Where does the name Edwyn come from?', 'https://images.pexels.com/photos/3683107/pexels-photo-3683107.jpeg?auto=compress&cs=tinysrgb&w=630&h=375&dpr=1');

INSERT INTO answers values
(1, 'Edwin Hubble', true, 1),
(2, 'Vincent cat''s name', false, 1),
(3, 'Random word which sounds nice', false, 1);

INSERT INTO questions values (2, 'Which tools do we use for internal communication?', null);

INSERT INTO answers values
(4, 'Slack, Gmail', false, 2),
(5, 'Teams, Outlook', true, 2),
(6, 'Google meets', false, 2);
