-- 코드를 입력하세요

SELECT book_id, date_format(PUBLISHED_DATE, '%Y-%m-%d') from book where category='인문' and YEAR(PUBLISHED_DATE)=2021 and PUBLISHED_DATE order by PUBLISHED_DATE
