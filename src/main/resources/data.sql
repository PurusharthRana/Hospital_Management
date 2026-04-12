INSERT INTO patient (name, birth_date, email, gender, blood_group)
VALUES
    ('Tony Stark', '1970-05-29', 'tony@stark.com', 'Male', 'B_Positive'),
    ('Puru', '2005-03-13', 'puru@rana.com', 'Male', 'O_Positive'),
    ('Divya', '2005-11-24', 'divya@verma.com', 'Female', 'AB_Positive'),
    ('Matt Murdock', '1980-07-18', 'matt@murdock.com', 'Male', 'O_Positive');


INSERT INTO doctor (name, specialization, email)
VALUES
    ('Dr. Tony Stark', 'Neurosurgeon', 'tony@stark.com'),
    (' Dr. Puru', 'Physiology', 'puru@rana.com'),
    ('Dr. Divya', 'Cardiology', 'divya@verma.com');


INSERT INTO appointment (appointment_time, reason, doctor_id, patient_id)
VALUES
    ('2026-07-08 10:30:00', 'Allergy', '2', '2'),
    ('2026-07-08 10:30:00', 'Stress', '2', '3'),
    ('2026-07-08 10:30:00', 'Fever', '3', '2'),
    ('2026-07-08 10:30:00', 'Cold', '3', '2'),
    ('2026-07-08 10:30:00', 'Headache', '1', '2'),
    ('2026-07-08 10:30:00', 'Injury', '3', '1');

