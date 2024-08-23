INSERT INTO speciality (id, speciality_name) values (1, 'Orthopedic');
INSERT INTO speciality (id, speciality_name) values (2, 'Gynecology');
INSERT INTO speciality (id, speciality_name) values (3, 'Dermatology');
INSERT INTO speciality (id, speciality_name) values (4, 'ENT');

INSERT INTO symptom (id, symptom_name) values (1, 'Arthritis');
INSERT INTO symptom (id, symptom_name) values (2, 'Back pain');
INSERT INTO symptom (id, symptom_name) values (3, 'Tissue injuries');
INSERT INTO symptom (id, symptom_name) values (4, 'Dysmenorrhea');
INSERT INTO symptom (id, symptom_name) values (5, 'Skin infection');
INSERT INTO symptom (id, symptom_name) values (6, 'Skin burn');
INSERT INTO symptom (id, symptom_name) values (7, 'Ear pain');

INSERT INTO speciality_symptoms (speciality_id, symptom_id) values (1, 1);
INSERT INTO speciality_symptoms (speciality_id, symptom_id) values (1, 2);
INSERT INTO speciality_symptoms (speciality_id, symptom_id) values (1, 3);
INSERT INTO speciality_symptoms (speciality_id, symptom_id) values (2, 4);
INSERT INTO speciality_symptoms (speciality_id, symptom_id) values (3, 5);
INSERT INTO speciality_symptoms (speciality_id, symptom_id) values (3, 6);
INSERT INTO speciality_symptoms (speciality_id, symptom_id) values (4, 7);