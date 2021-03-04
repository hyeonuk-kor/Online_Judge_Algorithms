# HackerRank Practice SQL



## Basic SELECT

- ##### REVISING the Select Query I

  ```sql
  select * from city
  where population > 100000 and countrycode='usa';
  ```

- ##### REVISING the Select Query II

  ```sql
  select name from city
  where population > 120000 and countrycode='usa';
  ```

- ##### Select ALL

  ```sql
  select * from city;
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
  FROM STATION;
  ```

- ##### Weather Observation Station 3

  ```SQL
  SELECT DISTINCT(CITY)
  FROM STATION
  WHERE MOD(ID,2)=0;
  ```

- ##### Weather Observation Station 4

  ```SQL
  SELECT COUNT(CITY) - COUNT(DISTINCT CITY)
  FROM STATION;
  ```

- ##### Weather Observation Station 5

  ```SQL
  (SELECT CITY, LENGTH(CITY)
  FROM STATION
  ORDER BY LENGTH(CITY), CITY LIMIT 1)
  UNION 
  (SELECT CITY, LENGTH(CITY)
  FROM STATION
  ORDER BY LENGTH(CITY) DESC LIMIT 1);
  ```

- ##### Weather Observation Station 6

  ```SQL
  SELECT DISTINCT(CITY)
  FROM STATION
  WHERE LEFT(LOWER(CITY),1) IN ('a','e','i','o','u');
  ```

- ##### Weather Observation Station 7

  ```SQL
  SELECT DISTINCT(CITY)
  FROM STATION
  WHERE RIGHT(LOWER(CITY),1) IN ('a','e','i','o','u');
  ```

- ##### Weather Observation Station 8

  ```sql
  SELECT DISTINCT(CITY)
  FROM STATION
  WHERE LEFT(LOWER(CITY),1) IN ('a','e','i','o','u')
  AND RIGHT(LOWER(CITY),1) IN ('a','e','i','o','u');
  ```

- ##### Weather Observation Station 9

  ```SQL
  SELECT DISTINCT(CITY)
  FROM STATION
  WHERE LEFT(LOWER(CITY),1) NOT IN ('a','e','i','o','u');
  ```

- ##### Weather Observation Station 10

  ```SQL
  SELECT DISTINCT(CITY)
  FROM STATION
  WHERE RIGHT(LOWER(CITY),1) NOT IN ('a','e','i','o','u');
  ```

- ##### Weather Observation Station 11

  ```SQL
  SELECT DISTINCT(CITY)
  FROM STATION
  WHERE LEFT(LOWER(CITY),1) NOT IN ('a','e','i','o','u')
  OR RIGHT(LOWER(CITY),1) NOT IN ('a','e','i','o','u');
  ```

- ##### Weather Observation Station 12

  ```SQL
  SELECT DISTINCT(CITY)
  FROM STATION
  WHERE LEFT(LOWER(CITY),1) NOT IN ('a','e','i','o','u')
  AND RIGHT(LOWER(CITY),1) NOT IN ('a','e','i','o','u');
  ```

- ##### Higher Than 75 Marks

  ```SQL
  SELECT NAME
  FROM STUDENTS
  WHERE MARKS > 75
  ORDER BY RIGHT(NAME, 3), ID;
  ```

- ##### Employee Names

  ```SQL
  SELECT NAME
  FROM EMPLOYEE
  ORDER BY NAME;
  ```

- ##### Employee Salaries

  ```SQL
  SELECT NAME
  FROM EMPLOYEE
  WHERE MONTHS<10 AND SALARY > 2000
  ORDER BY EMPLOYEE_ID;
  ```

- ### You just solved all the Basic Select challenges in SQL!



## Advanced SELECT

- ##### Type of Triangle

  ```sql
  SELECT
      CASE
          WHEN A+B>C AND B+C>A AND C+A>B THEN
              CASE 
                  WHEN A=B AND B=C AND C=A THEN 'Equilateral'
                  WHEN A=B OR B=C OR C=A THEN 'Isosceles'
                  WHEN A!=B AND B!=C AND C!=A THEN 'Scalene'
              END
          ELSE 'Not A Triangle'
      END
  FROM TRIANGLES;
  ```

  