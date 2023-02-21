-- 코드를 입력하세요
SELECT a.flavor
from FIRST_HALF a, ICECREAM_INFO b 
where a.flavor=b.flavor and a.total_order > 3000 and b.ingredient_type='fruit_based' 
order by total_order desc