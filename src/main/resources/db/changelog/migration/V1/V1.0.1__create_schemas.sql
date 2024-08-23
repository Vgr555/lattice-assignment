CREATE TABLE IF NOT EXISTS doctor(
    doctor_id       VARCHAR PRIMARY KEY,
    name            VARCHAR NOT NULL,
    city            VARCHAR NOT NULL,
    email           VARCHAR,
    phone_number    VARCHAR NOT NULL,
    speciality      VARCHAR NOT NULL
);

CREATE TABLE IF NOT EXISTS patient(
    patient_id      VARCHAR PRIMARY KEY,
    name            VARCHAR NOT NULL,
    city            VARCHAR NOT NULL,
    email           VARCHAR,
    phone_number    VARCHAR NOT NULL,
    symptom         VARCHAR NOT NULL
);

CREATE TABLE IF NOT EXISTS speciality(
    id              INT PRIMARY KEY,
    speciality_name VARCHAR NOT NULL UNIQUE
);

CREATE TABLE IF NOT EXISTS symptom(
    id              INT PRIMARY KEY,
    symptom_name    VARCHAR NOT NULL UNIQUE
);

--A join table to represent the @OneToMany relationship between Speciality and Symptom
CREATE TABLE IF NOT EXISTS speciality_symptoms(
    speciality_id   INT NOT NULL,
    symptom_id      INT NOT NULL,
    PRIMARY KEY(speciality_id, symptom_id),
    FOREIGN KEY(speciality_id) REFERENCES speciality(id),
    FOREIGN KEY(symptom_id) REFERENCES symptom(id)
);