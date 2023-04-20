-- 코드를 입력하세요
SELECT CAST(date_format(DATETIME,"%H") AS UNSIGNED) as HOUR, count(*) as COUNT
from ANIMAL_OUTS
group by HOUR
having HOUR BETWEEN 9 and 20
order by HOUR

