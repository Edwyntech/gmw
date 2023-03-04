create TABLE IF NOT EXISTS quizzes (
    id   INTEGER  PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR NOT NULL
);

create TABLE IF NOT EXISTS questions (
    id   INTEGER  PRIMARY KEY AUTO_INCREMENT,
    text VARCHAR NOT NULL,
    image_url VARCHAR DEFAULT NULL,
    quiz_id INTEGER NOT NULL
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

insert into quizzes values (1, 'Default quiz');
insert into quizzes values (2, 'Another quiz');


insert into questions values (1, 'Where does the name Edwyn come from?', 'https://images.pexels.com/photos/3683107/pexels-photo-3683107.jpeg?auto=compress&cs=tinysrgb&w=630&h=375&dpr=1', 1);

insert into answers values
(1, 'Edwin Hubble', true, 1, null),
(2, 'Vincent cat''s name', false, 1, null),
(3, 'Random word which sounds nice', false, 1, null);

insert into questions values (2, 'Which tools do we use for internal communication?', null, 1);

insert into answers values
(4, 'Slack, Gmail', false, 2, null),
(5, 'Teams, Outlook', true, 2, null),
(6, 'Google meets', false, 2, null);

insert into questions values (3, 'Guess my W', 'https://www.edwyn.tech/wp-content/uploads/2021/08/symbol-07.png', 1);

insert into answers values
(7, 'Mehdi', false, 3, null),
(8, 'Jerome', true, 3, null),
(9, 'Moustapha', false, 3, null);

insert into questions values (4, '', 'https://www.edwyn.tech/wp-content/uploads/2021/08/Sujet-10.png', 1);

insert into answers values
(10, 'Michaël', true, 4, null),
(11, 'Vincent', false, 4, null),
(12, 'Pierrick', false, 4, null);

insert into questions values (5, 'Can we have multiple quizzes?', null, 2);

insert into answers values
(13, 'Yes', true, 5, null),
(14, 'No', false, 5, null);

insert into users values ('alex');
