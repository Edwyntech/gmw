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
    id   INTEGER  PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR NOT NULL,
    last_name VARCHAR NOT NULL,
    email VARCHAR NOT NULL unique
);

create TABLE IF NOT EXISTS user_correct_answers (
    user_id VARCHAR NOT NULL,
    question_id   INTEGER NOT NULL
);

INSERT INTO quizzes (name) VALUES ('Edwyn Quiz');

INSERT INTO questions (text, image_url, quiz_id) VALUES ('Définition du Test Driven Development', NULL, 1);
INSERT INTO answers (text, correct, question_id, image_url) VALUES ('Une approche où les développeurs testent leur code une fois le développement terminé', false, 1, NULL);
INSERT INTO answers (text, correct, question_id, image_url) VALUES ('Une méthode de développement de logiciel qui consiste à concevoir un logiciel par petits pas, de façon itérative et incrémentale, en écrivant chaque test avant d’écrire le code source et en remaniant le code continuellement', true, 1, NULL);
INSERT INTO answers (text, correct, question_id, image_url) VALUES ('Une technique qui vise à ignorer les tests unitaires lors du développement', false, 1, NULL);

INSERT INTO questions (text, image_url, quiz_id) VALUES ('À quoi fait référence le "L" de SOLID?', NULL, 1);
INSERT INTO answers (text, correct, question_id, image_url) VALUES ('A la solidité du code produit.', false, 2, NULL);
INSERT INTO answers (text, correct, question_id, image_url) VALUES ('A la légèreté des dépendances entre les classes.', false, 2, NULL);
INSERT INTO answers (text, correct, question_id, image_url) VALUES ('Au principe de substitution de Liskov.', true, 2, NULL);

INSERT INTO questions (text, image_url, quiz_id) VALUES ('Architecture hexagonale : définition simple', NULL, 1);
INSERT INTO answers (text, correct, question_id, image_url) VALUES ('Une approche architecturale qui favorise la séparation des préoccupations en organisant le code autour d''un noyau central, avec des ports d''entrée et de sortie pour interagir avec le reste du système', true, 3, NULL);
INSERT INTO answers (text, correct, question_id, image_url) VALUES ('Un style architectural qui divise le code en six parties égales, chacune représentant une fonctionnalité spécifique du système', false, 3, NULL);
INSERT INTO answers (text, correct, question_id, image_url) VALUES ('Une méthode de développement logiciel basée sur l''utilisation de six bibliothèques distinctes pour concevoir des systèmes modulaires et flexibles', false, 3, NULL);

INSERT INTO questions (text, image_url, quiz_id) VALUES ('Parmi ces frameworks de tests, lequel n''est pas un framework de test Java :', NULL, 1);
INSERT INTO answers (text, correct, question_id, image_url) VALUES ('JUnit', false, 4, NULL);
INSERT INTO answers (text, correct, question_id, image_url) VALUES ('Selenium', false, 4, NULL);
INSERT INTO answers (text, correct, question_id, image_url) VALUES ('Karma', true, 4, NULL);

INSERT INTO questions (text, image_url, quiz_id) VALUES ('Qui a écrit le "Clean Code" ?', NULL, 1);
INSERT INTO answers (text, correct, question_id, image_url) VALUES ('Robert C. Martin (Uncle Bob)', true, 5, NULL);
INSERT INTO answers (text, correct, question_id, image_url) VALUES ('Martin Fowler', false, 5, NULL);
INSERT INTO answers (text, correct, question_id, image_url) VALUES ('Kent Beck', false, 5, NULL);

INSERT INTO questions (text, image_url, quiz_id) VALUES ('À quoi fait référence la définition suivante dans SOLID : "Les clients ne doivent pas être contraints de dépendre d''interfaces qu''ils n''utilisent pas."', NULL, 1);
INSERT INTO answers (text, correct, question_id, image_url) VALUES ('Le principe de substitution de Liskov (Liskov Substitution Principle)', false, 6, NULL);
INSERT INTO answers (text, correct, question_id, image_url) VALUES ('Le principe d''inversion de dépendance (Dependency Inversion Principle)', true, 6, NULL);
INSERT INTO answers (text, correct, question_id, image_url) VALUES ('Le principe de responsabilité unique (Single Responsibility Principle)', false, 6, NULL);

INSERT INTO questions (text, image_url, quiz_id) VALUES ('Qu''est-ce qu''un test d''intégration ?', NULL, 1);
INSERT INTO answers (text, correct, question_id, image_url) VALUES ('Un type de test qui vérifie l''interaction entre différentes parties d''un système.', true, 7, NULL);
INSERT INTO answers (text, correct, question_id, image_url) VALUES ('Un test qui vérifie le bon fonctionnement d''une seule unité de code.', false, 7, NULL);
INSERT INTO answers (text, correct, question_id, image_url) VALUES ('Un test qui vérifie la performance d''une application en simulant un trafic élevé.', false, 7, NULL);

INSERT INTO questions (text, image_url, quiz_id) VALUES ('DDD pour ?', NULL, 1);
INSERT INTO answers (text, correct, question_id, image_url) VALUES ('Domain Driven Development', false, 8, NULL);
INSERT INTO answers (text, correct, question_id, image_url) VALUES ('Domain Driven Design', true, 8, NULL);
INSERT INTO answers (text, correct, question_id, image_url) VALUES ('Dynamic Domain Development', false, 8, NULL);
INSERT INTO answers (text, correct, question_id, image_url) VALUES ('Dependecy Data Domain', false, 8, NULL);

INSERT INTO questions (text, image_url, quiz_id) VALUES ('Qui a introduit pour la première fois le terme DDD ?', NULL, 1);
INSERT INTO answers (text, correct, question_id, image_url) VALUES ('Martin Fowler', false, 9, NULL);
INSERT INTO answers (text, correct, question_id, image_url) VALUES ('Robert C. Martin (Uncle Bob)', false, 9, NULL);
INSERT INTO answers (text, correct, question_id, image_url) VALUES ('Eric Evans', true, 9, NULL);

INSERT INTO questions (text, image_url, quiz_id) VALUES ('Quelle est la définition la plus exacte du DDD parmi ces réponses ?', NULL, 1);
INSERT INTO answers (text, correct, question_id, image_url) VALUES ('Une méthode de développement basée sur des tests unitaires.', false, 10, NULL);
INSERT INTO answers (text, correct, question_id, image_url) VALUES ('Une approche qui met l''accent sur la modélisation du domaine métier.', true, 10, NULL);
INSERT INTO answers (text, correct, question_id, image_url) VALUES ('Une technique qui encourage l''utilisation d''interfaces abstraites pour réduire les dépendances.', false, 10, NULL);

INSERT INTO questions (text, image_url, quiz_id) VALUES ('BONUS: De quelle année date la première édition de la Ncrafts ?', NULL, 1);
INSERT INTO answers (text, correct, question_id, image_url) VALUES ('2010', false, 11, NULL);
INSERT INTO answers (text, correct, question_id, image_url) VALUES ('2013', false, 11, NULL);
INSERT INTO answers (text, correct, question_id, image_url) VALUES ('2014', true, 11, NULL);

INSERT INTO questions (text, image_url, quiz_id) VALUES ('À quoi sert une couche d''anti-corruption (anti-corruption layer) de données ?', NULL, 1);
INSERT INTO answers (text, correct, question_id, image_url) VALUES ('A traduire les données provenant de systèmes externes dans un format compréhensible pour le système local.', true, 12, NULL);
INSERT INTO answers (text, correct, question_id, image_url) VALUES ('A protéger les données sensibles contre les attaques de pirates.', false, 12, NULL);
INSERT INTO answers (text, correct, question_id, image_url) VALUES ('A garantir la cohérence et l''intégrité des données stockées dans une base de données.', false, 12, NULL);

INSERT INTO questions (text, image_url, quiz_id) VALUES ('Pourquoi le flux d''authentification client_credentials de OAuth2 n''est pas adapté aux applications front-end?', NULL, 1);
INSERT INTO answers (text, correct, question_id, image_url) VALUES ('Il ne permet pas l''interaction avec l''utilisateur pour obtenir les informations d''identification.', true, 13, NULL);
INSERT INTO answers (text, correct, question_id, image_url) VALUES ('Il ne permet pas la gestion des sessions utilisateur nécessaires pour les applications front-end.', false, 13, NULL);
INSERT INTO answers (text, correct, question_id, image_url) VALUES ('Il ne prend pas en charge les protocoles de sécurité requis par les applications front-end.', false, 13, NULL);

INSERT INTO questions (text, image_url, quiz_id) VALUES ('Complète cette phrase : "les trois étape du TDD sont : Red-green- ?"', NULL, 1);
INSERT INTO answers (text, correct, question_id, image_url) VALUES ('Red', true, 14, NULL);
INSERT INTO answers (text, correct, question_id, image_url) VALUES ('Yellow', false, 14, NULL);
INSERT INTO answers (text, correct, question_id, image_url) VALUES ('Refactor', true, 14, NULL);
INSERT INTO answers (text, correct, question_id, image_url) VALUES ('Delete', false, 14, NULL);

INSERT INTO questions (text, image_url, quiz_id) VALUES ('Quel est l''horthographe du mot :', NULL, 1);
INSERT INTO answers (text, correct, question_id, image_url) VALUES ('Software Craftmanship', false, 15, NULL);
INSERT INTO answers (text, correct, question_id, image_url) VALUES ('Software Craftsmanship', true, 15, NULL);
INSERT INTO answers (text, correct, question_id, image_url) VALUES ('Software Craftemanchip', false, 15, NULL);
INSERT INTO answers (text, correct, question_id, image_url) VALUES ('Software Craftsmanchip', false, 15, NULL);
