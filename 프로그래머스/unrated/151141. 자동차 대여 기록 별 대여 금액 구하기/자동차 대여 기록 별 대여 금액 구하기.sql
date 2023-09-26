-- 코드를 입력하세요
SELECT history.HISTORY_ID, floor((DATEDIFF(history.end_date,history.start_date)+1)*car.DAILY_FEE*
((100-if(DATEDIFF(history.end_date,history.start_date)+1>=90, (select discount_rate from CAR_RENTAL_COMPANY_DISCOUNT_PLAN where duration_type="90일 이상" and car_type="트럭"), 
   if(DATEDIFF(history.end_date,history.start_date)+1>=30, (select discount_rate from CAR_RENTAL_COMPANY_DISCOUNT_PLAN where duration_type="30일 이상" and car_type="트럭"),
     if(DATEDIFF(history.end_date,history.start_date)+1>=7, (select discount_rate from CAR_RENTAL_COMPANY_DISCOUNT_PLAN where duration_type="7일 이상" and car_type="트럭"), 0
       ))))*0.01)) as FEE
from CAR_RENTAL_COMPANY_CAR car 
join CAR_RENTAL_COMPANY_RENTAL_HISTORY history
on car.car_id=history.car_id
and car.car_type="트럭"
order by FEE desc, history.HISTORY_ID desc