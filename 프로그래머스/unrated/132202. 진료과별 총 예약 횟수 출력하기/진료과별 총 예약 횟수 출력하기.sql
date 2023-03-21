-- 코드를 입력하세요
SELECT MCDP_CD as 진료과코드, count(*) as 5월예약건수
from APPOINTMENT
where date_format(APNT_YMD,'%Y%m')='202205'
group by MCDP_CD
order by count(*), 진료과코드