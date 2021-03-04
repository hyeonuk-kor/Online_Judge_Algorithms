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

- ##### The PADS

  ```sql
  SELECT CONCAT(NAME, '(', SUBSTR(OCCUPATION,1,1) ,')')
  FROM OCCUPATIONS
  ORDER BY NAME;
  SELECT CONCAT('There are a total of ', count(occupation), ' ', lower(occupation), 's.')
  from occupations
  group by occupation
  order by count(occupation);
  ```

- ##### Occupations

  ```sql
  set @r1=0, @r2=0, @r3=0, @r4=0;
  select min(t.doctor), min(t.professor), min(t.singer), min(t.actor)
  from(
      select 
          case 
              when occupation='doctor' then (@r1:=@r1+1)
              when occupation='professor' then (@r2:=@r2+1)
              when occupation='singer' then (@r3:=@r3+1)
              when occupation='actor' then (@r4:=@r4+1)
          end as NUMBER,
          case when occupation='doctor' then name end as doctor,
          case when occupation='professor' then name end as professor,
          case when occupation='singer' then name end as singer,
          case when occupation='actor' then name end as actor
      from occupations
      order by name
  ) t
  group by NUMBER;
  ```

- ##### Binary Tree Nodes

  ```sql
  select 
  	n, if(p is null, 'Root', 
            if( (select count(*) 
                 from bst 
                 where p=tree.n)> 0, 
                 'Inner', 'Leaf'))
  from bst
  order by n;
  
  /* using case */
  select 
      case 
          when p is null 
              then concat(n, ' Root')
          else
              case 
                  when n in (select distinct p from bst) 
                      then concat(n, ' Inner')
                  else 
                      concat(n, ' Leaf')
              end
      end
  from bst
  order by n
  ```

- ##### New Companies

  ```sql
  select
  	c.company_code,
  	c.founder,
  	count(distinct l.lead_manager_code),
  	count(distinct s.senior_manager_code),
  	count(distinct m.manager_code),
  	count(distinct e.employee_code)
  from
  	Company c, 
  	Lead_manager l, 
  	Senior_Manager s, 
  	Manager m, 
  	Employee e
  where
  	c.company_code = l.company_code and
  	l.lead_manager_code = s.lead_manager_code and
  	s.senior_manager_code = m.senior_manager_code and
  	m.manager_code = e.manager_code
  group by c.company_code, c.founder
  order by c.company_code;
  
  /* using inner join */
  select 
  	c.company_code, 
  	c.founder, 
  	count(distinct e.lead_manager_code),
  	count(distinct e.senior_manager_code),
  	count(distinct e.manager_code),
  	count(distinct e.employee_code)
  from 
  	company c inner join employee e 
  	on e.company_code = c.company_code
  group by c.company_code, c.founder
  order by c.company_code;
  ```

  



