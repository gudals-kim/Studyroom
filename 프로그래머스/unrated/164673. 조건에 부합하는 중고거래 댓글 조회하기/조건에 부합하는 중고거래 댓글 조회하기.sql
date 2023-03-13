-- 코드를 입력하세요
SELECT item.TITLE, item.BOARD_ID, review.REPLY_ID, review.WRITER_ID, review.CONTENTS, DATE_format(review.CREATED_DATE,'%Y-%m-%d') as CREATED_DATE
from USED_GOODS_BOARD item join USED_GOODS_REPLY review on item.BOARD_ID = review.BOARD_ID
where year(item.CREATED_DATE)=2022 and month(item.CREATED_DATE)=10
order by review.CREATED_DATE, item.TITLE