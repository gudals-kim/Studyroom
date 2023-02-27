-- 코드를 입력하세요
SELECT dr_name, dr_id, MCDP_CD, date_format(HIRE_YMD,'%Y-%m-%d') as HIRE_YMD
from doctor
where MCDP_CD='CS' or MCDP_CD='GS'
order by HIRE_YMD desc, DR_NAME