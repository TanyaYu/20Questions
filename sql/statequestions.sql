drop database if exists States;
create database States;
use States;
drop table if exists StatesTable;

SET SQL_SAFE_UPDATES = 0;

create table StatesTable
 (
  statename varchar(18),
  -- Is it a vegitable
  Question_1 varchar(1),
  -- Is it a food
  Question_2 varchar(1),
  -- Is it high in fat
  Question_3 varchar(1),
  -- Is it 
  Question_4 varchar(1),
  -- Is it a vegitable
  Question_5 varchar(1),
  -- Is it a vegitable
  Question_6 varchar(1),
  -- Is it a vegitable
  Question_7 varchar(1),
  -- Is it a vegitable
  Question_8 varchar(1),
  -- Is it a vegitable
  Question_9 varchar(1),
  -- Is it a vegitable
  Question_10 varchar(1),
  -- Is it a vegitable
  Question_11 varchar(1),
  -- Is it a vegitable
  Question_12 varchar(1),
  -- Is it a vegitable
  Question_13 varchar(1),
  -- Is it a vegitable
  Question_14 varchar(1),
  -- Is it a vegitable
  Question_15 varchar(1),
  -- Is it a vegitable
  Question_16 varchar(1),
  -- Is it a vegitable
  Question_17 varchar(1),
  -- Is it a vegitable
  Question_18 varchar(1),
  -- Is it a vegitable
  Question_19 varchar(1),
  -- Is it a vegitable
  Question_20 varchar(1),
  
  
  
  constraint pk_statename primary key (statename)
 );
 
  LOAD DATA local INFILE 'C:/Users/Justin/Documents/School/StatesQuestions.txt' INTO TABLE StatesTable;
  
  select * from StatesTable;