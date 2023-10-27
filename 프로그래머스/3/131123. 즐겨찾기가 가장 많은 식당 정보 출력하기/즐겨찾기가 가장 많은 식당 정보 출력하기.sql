-- 코드를 입력하세요
SELECT info.FOOD_TYPE, info.REST_ID, info.REST_NAME, info.FAVORITES
from REST_INFO info
join 
(select FOOD_TYPE, max(FAVORITES) as FAVORITES from REST_INFO group by FOOD_TYPE) m
on info.FAVORITES = m.FAVORITES and info.FOOD_TYPE = m.FOOD_TYPE
order by info.FOOD_TYPE desc