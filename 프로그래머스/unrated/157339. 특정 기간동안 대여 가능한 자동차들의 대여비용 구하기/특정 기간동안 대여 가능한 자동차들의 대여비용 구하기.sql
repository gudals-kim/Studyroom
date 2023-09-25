-- 코드를 입력하세요
SELECT  car.car_id, car.car_type, FLOOR((car.daily_fee)*((100-discount.discount_rate)*0.01)*30) as FEE
from CAR_RENTAL_COMPANY_CAR car 
join CAR_RENTAL_COMPANY_DISCOUNT_PLAN discount
on 
car.car_type = discount.car_type 
and 
discount.duration_type = "30일 이상"
where 
car.car_id not in
(select car_id from CAR_RENTAL_COMPANY_RENTAL_HISTORY
 where start_date<="2022-11-30" and end_date>"2022-11-01")
and 
(car.car_type = "세단" or car.car_type = "SUV")
and FLOOR((car.daily_fee)*(100-discount.discount_rate)*0.01*30) >= 500000
and FLOOR((car.daily_fee)*(100-discount.discount_rate)*0.01*30) < 2000000
order by FEE desc, car.car_type, car.car_id desc
