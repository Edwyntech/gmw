create TABLE IF NOT EXISTS questions (
    id   INTEGER  PRIMARY KEY AUTO_INCREMENT,
    type VARCHAR NOT NULL,
    text VARCHAR NOT NULL
);

create TABLE IF NOT EXISTS answers (
    id   INTEGER  PRIMARY KEY AUTO_INCREMENT,
    type VARCHAR NOT NULL,
    text VARCHAR NOT NULL,
    correct BOOLEAN NOT NULL DEFAULT FALSE,
    question_id INTEGER NOT NULL
);

INSERT INTO questions values (1, 'TEXT', 'Where does the name Edwyn come from?');

INSERT INTO answers values (1, 'TEXT', 'Edwin Hubble', true, 1),
(2, 'TEXT', 'Vincent cat''s name', false, 1),
(3, 'TEXT', 'Random word which sounds nice', false, 1);
