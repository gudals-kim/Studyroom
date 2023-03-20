-- 코드를 입력하세요
SELECT a.PRODUCT_CODE, sum(b.sales_amount)*a.price as sales
from PRODUCT a join OFFLINE_SALE b on a.PRODUCT_ID=b.PRODUCT_ID
group by a.product_id
order by sales desc, a.PRODUCT_CODE