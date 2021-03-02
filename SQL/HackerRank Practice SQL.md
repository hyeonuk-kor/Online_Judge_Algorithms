# HackerRank Practice SQL



## Basic SELECT

- ##### REVISING the Select Query I

  ```sql
  select * from city
  where population > 100000 and countrycode='usa'
  ```

- ##### REVISING the Select Query II

  ```sql
  select name from city
  where population > 120000 and countrycode='usa'
  ```

- ##### Select ALL

  ```sql
  select * from city
  ```

- ##### Select By ID

  ```sql
  select * from city
  where id=1661;
  ```

- ##### Japanese Cities' Attributes

  ```sql
  Select * from city
  where countrycode='JPN';
  ```

- ##### Japanese Cities' Names

  ```SQL
  select name from city
  where countrycode = 'JPN';
  ```

- ##### Weather Observation Station 1

  ```SQL
  SELECT CITY, STATE
  FROM STATION
  ```

- ##### Weather Observation Station 3

  ```SQL
  SELECT DISTINCT(CITY)
  FROM STATION
  WHERE MOD(ID,2)=0;
  ```

  



