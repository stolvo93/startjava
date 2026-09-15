\echo Все роботы
SELECT *
  FROM jaegers;

\echo Неуничтоженные роботы
SELECT *
  FROM jaegers
 WHERE status <> 'Destroyed';

\echo Роботы серий Mark-1 и Mark-4
SELECT *
  FROM jaegers
 WHERE mark IN ('Mark-1', 'Mark-4');

\echo Все роботы, кроме Mark-1 и Mark-4, отсортированные по серии по убыванию
SELECT *
  FROM jaegers
 WHERE mark NOT IN ('Mark-1', 'Mark-4')
 ORDER BY mark DESC;

\echo Информация о самых старых роботах
SELECT *
  FROM jaegers
 ORDER BY launch;

\echo Модель, серия, год выпуска роботов, уничтоживших больше всех кайдзю
SELECT model_name AS "Модель",
       mark       AS "Серия",
       launch     AS "Год выпуска",
       kaiju_kill AS "Уничтожено кайдзю"
  FROM jaegers
 ORDER BY kaiju_kill DESC;

\echo Средний вес роботов
SELECT ROUND(AVG(weight), 3) AS avg_weight;

\echo Увеличение количества уничтоженных кайдзю на 1 для неразрушенных роботов
UPDATE jaegers
   SET kaiju_kill = kaiju_kill + 1
 WHERE status <> 'Destroyed';

SELECT *
  FROM jaegers;

\echo Удаление всех уничтоженных роботов
DELETE FROM jaegers
 WHERE status = 'Destroyed';

SELECT *
  FROM jaegers;
