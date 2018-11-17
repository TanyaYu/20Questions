drop database if exists food;
create database food;
use food;
drop table if exists FoodTable;

SET SQL_SAFE_UPDATES = 0;

create table FoodTable
 (
  foodname varchar(18),
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
  
  
  
  constraint pk_foodname primary key (foodname)
 );
 
  LOAD DATA local INFILE 'C:/Users/Justin/Documents/School/FoodQuestions.txt' INTO TABLE FoodTable;
  
  select * from FoodTable;