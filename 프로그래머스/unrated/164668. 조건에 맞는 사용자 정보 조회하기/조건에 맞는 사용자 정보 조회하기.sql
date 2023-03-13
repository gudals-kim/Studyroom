-- 코드를 입력하세요
SELECT b.USER_ID, b.NICKNAME, sum(a.price) as TOTAL_SALES
from USED_GOODS_BOARD a join USED_GOODS_USER b on a.WRITER_ID = b.USER_ID
where a.status='DONE'
group by a.writer_id
having sum(a.price)>=700000
order by TOTAL_SALES