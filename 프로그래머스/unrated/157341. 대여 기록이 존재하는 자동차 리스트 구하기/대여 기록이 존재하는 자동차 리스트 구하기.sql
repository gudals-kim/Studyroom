-- 코드를 입력하세요
SELECT DISTINCT a.car_id
from CAR_RENTAL_COMPANY_CAR a join CAR_RENTAL_COMPANY_RENTAL_HISTORY b
on MONTH(b.START_DATE)=10 and a.car_id=b.car_id where a.CAR_TYPE='세단' order by a.CAR_ID desc