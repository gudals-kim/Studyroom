-- 코드를 입력하세요
SELECT count(DISTINCT name) as count
from ANIMAL_INS 
where NAME is not null