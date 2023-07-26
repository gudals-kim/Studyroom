-- 코드를 입력하세요
# SELECT TITLE, BOARD_ID, REPLY_ID, WRITER_ID, CONTENTS, CREATED_DATE
select board.TITLE,
reply.BOARD_ID,
reply.REPLY_ID,
reply.WRITER_ID,
reply.CONTENTS,
date_format(reply.CREATED_DATE,"%Y-%m-%d") as CREATED_DATE
from USED_GOODS_BOARD board 
join USED_GOODS_REPLY reply
on board.BOARD_ID=reply.BOARD_ID
where year(board.CREATED_DATE)=2022 and month(board.CREATED_DATE)=10
order by CREATED_DATE, board.TITLE