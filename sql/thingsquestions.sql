#schema for things
DROP DATABASE IF EXISTS Things;
CREATE DATABASE Things;
USE Things;
CREATE TABLE ThingsQuestions
(
  ThingName      VARCHAR(10) primary key,
  Question_1	 VARCHAR(1),
  Question_2	 VARCHAR(1),
  Question_3	 VARCHAR(1),
  Question_4	 VARCHAR(1),
  Question_5	 VARCHAR(1),
  Question_6     VARCHAR(1),
  Question_7	 VARCHAR(1),
  Question_8	 VARCHAR(1),
  Question_9	 VARCHAR(1),
  Question_10    VARCHAR(1),
  Question_11	 VARCHAR(1),
  Question_12	 VARCHAR(1),
  Question_13	 VARCHAR(1),
  Question_14	 VARCHAR(1),
  Question_15	 VARCHAR(1),
  Question_16	 VARCHAR(1),
  Question_17 	 VARCHAR(1),
  Question_18	 VARCHAR(1),
  Question_19	 VARCHAR(1),
  Question_20	 VARCHAR(1)
  
);

LOAD DATA local INFILE  'C:\Users\Aashirya Kaushik\Desktop\OOPS\20Questions\Things Questions.txt' INTO TABLE ThingsQuestions;

select * from ThingsQuestions;