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



## Aggregation

- ##### Revising Aggregations - The Count Function

  ```sql
  select count(*)
  from city
  where population > 1000;
  ```

- ##### Revising Aggregations - The Sum Function

  ```sql
  select sum(population)
  from city
  where district='California';
  ```

- ##### Revising Aggregations - Averages

  ```sql
  select avg(population)
  from city
  where district='California';
  ```

- ##### Average Population

  ```sql
  select round(avg(population)
  from city;
  /* other */   
  select floor(avg(population))
  from city;
  ```

- ##### Japan Population

  ```sql
  select sum(population)
  from city
  where countrycode='jpn'
  ```

- ##### Population Density Difference

  ```sql
  select max(population) - min(population)
  from city;
  ```

- ##### The Blunder

  ```sql
  select ceil(avg(salary) - avg(replace(salary, '0', '')))
  from employees;
  ```

- ##### Top Earners

  ```sql
  select max(salary*months), count((salary*months))
  from employee
  group by (salary*months)
  order by salary*months desc
  limit 1
  ```

- ##### Weather Observation Station 2

  ```sql
  select round(sum(lat_n), 2), round(sum(long_w), 2)
  from station
  ```

- ##### Weather Observation Station 13

  ```sql
  select round(sum(lat_n), 4)
  from station
  where lat_n > 38.7880 and lat_n < 137.2345
  ```

- ##### Weather Observation Station 14

  ```sql
  select round(max(lat_n), 4)
  from station
  where lat_n < 137.2345;
  ```

- ##### Weather Observation Station 15

  ```sql
  select round(max(long_w), 4)
  from station
  where lat_n = (select max(lat_n) from station where lat_n < 137.2345);
  ```

- ##### Weather Observation Station 16

  ```sql
  select round(min(lat_n), 4)
  from station
  where lat_n > 38.7780;
  ```

- ##### Weather Observation Station 17

  ```sql
  select round(max(long_w), 4)
  from station
  where lat_n = (select min(lat_n) from station where lat_n > 38.7780);
  ```

- ##### Weather Observation Station 18

  ```sql
  select round(abs(min(lat_n)-max(lat_n))+abs(min(long_w)-max(long_w)), 4)
  from station;
  ```

- ##### Weather Observation Station 19

  ```sql
  select round(sqrt(
      power(max(lat_n)-min(lat_n),2) + power(max(long_w)-min(long_w),2)
               ), 4)
  from station;
  ```

- ##### Weather Observation Station 20

  ```sql
  /* mysql */
  set @row := -1;
  select 
      round(avg(t.lat), 4)
  from
      (
          select @row:=@row + 1 as r, lat_n as lat
          from station
          order by lat
      ) as t
  where t.r in (floor(@row/2), ceil(@row/2));
  
  /* oracle */
  select round(median(lat_n), 4)
  from station;
  ```




## Basic Join

- ##### Asian Population

  ```sql
  select 
      sum(city.population)
  from
      city inner join country
      on city.countrycode = country.code
  where country.continent='asia';
  ```

- ##### African Cities

  ```sql
  select 
  	city.name
  from
      city inner join country
      on city.countrycode = country.code
  where country.continent='africa';
  ```

- ##### Average Population of Each Continent

  ```sql
  select country.continent, floor(avg(city.population))
  from city inner join country
  on city.countrycode = country.code
  group by country.continent;
  ```

- ##### The Report

  ```sql
  select 
      if(grade<8, null, name), 
      grade, 
      marks
  from
      students inner join grades
  where marks between min_mark and max_mark
  order by grade desc, name
  ```

- ##### Top Competitors

  ```sql
  select hacker_id, name
  from 
  submissions s 
  inner join challenges c on s.challenge_id = c.challenge_id
  inner join difficulty d on c.difficulty_level = d.difficulty_level 
  inner join hackers h on s.hacker_id = h.hacker_id
  where s.score = d.score and c.difficulty_level = d.difficulty_level
  group by h.hacker_id, h.name
  having count(s.hacker_id) > 1
  order by count(s.hacker_id) desc, s.hacker_id asc
  ```

- ##### Ollivander's Inventory

  ```sql
  SELECT
      w.id, p.age, w.coins_needed, w.power
  FROM
      Wands w INNER JOIN Wands_Property p ON w.code = p.code
  WHERE
      w.coins_needed = (SELECT MIN(coins_needed)
                      FROM Wands w2 INNER JOIN Wands_Property p2 ON w2.code = p2.code
                      WHERE p2.is_evil = 0 AND w.power = w2.power AND p.age = p2.age)
  ORDER BY
      w.power DESC, p.age DESC
  ```

- ##### Challenges

  ```sql
  select C.hacker_id, H.name, count(C.hacker_id)
  from
  Hackers as H inner join Challenges as C
  on c.hacker_id = h.hacker_id
  group by c.hacker_id, H.name
  having cnt = (
      select count(c1.challenge_id) 
      from challenges as c1 
      group by c1.hacker_id
  	order by count(*) desc
  	limit 1
  ) or cnt not in (
  	select count(c2.challenge_id)
      from challenges as c2
      group by c2.hacker_id
      having c2.hacker_id <> c.hacker_id
  )
  order by count(C.hacker_id) desc, c.hacker_id
  ```

- ##### Contest Leaderboard

  ```sql
  select 
      h.hacker_id, name, sum(score) as totalScore
  from
      hackers as h
      inner join
      (select hacker_id, max(score) as score
       from submissions
       group by challenge_id, hacker_id) maxScore
       on h.hacker_id = maxScore.hacker_id
  group by h.hacker_id, name
  having totalScore > 0
  order by totalScore desc, h.hacker_id;
  ```

  







