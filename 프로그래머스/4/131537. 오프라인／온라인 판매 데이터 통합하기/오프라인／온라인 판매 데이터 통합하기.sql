select date_format(a.SALES_DATE, "%Y-%m-%d") as SALES_DATE, a.PRODUCT_ID, a.user_id, a.SALES_AMOUNT
from 
(
select SALES_DATE, PRODUCT_ID, null as user_id, SALES_AMOUNT 
from OFFLINE_SALE
where year(SALES_DATE) = 2022 and month(SALES_DATE)=3
union all
select SALES_DATE, PRODUCT_ID, USER_ID, SALES_AMOUNT 
from ONLINE_SALE 
where year(SALES_DATE) = 2022 and month(SALES_DATE)=3
) a
order by a.SALES_DATE, a.PRODUCT_ID, a.USER_ID