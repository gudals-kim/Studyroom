-- 코드를 입력하세요
SELECT count(age) as users
from USER_INFO
where year(JOINED)=2021 and 20<=AGE and AGE<=29