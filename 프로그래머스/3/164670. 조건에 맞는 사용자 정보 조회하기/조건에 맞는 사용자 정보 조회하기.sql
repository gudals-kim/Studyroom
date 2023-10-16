-- 코드를 입력하세요
select a.USER_ID, a.NICKNAME, concat(a.CITY," ",a.STREET_ADDRESS1," ",a.STREET_ADDRESS2) as 전체주소, concat(substring(TLNO,1,3),"-",substring(TLNO,4,4),"-",substring(TLNO,8,4)) as 전화번호
from USED_GOODS_USER a join USED_GOODS_BOARD b on a.USER_ID = b.WRITER_ID
group by a.USER_ID
having count(*)>2
order by a.user_id desc