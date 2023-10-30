
select c.AUTHOR_ID, c.AUTHOR_NAME, c.CATEGORY, sum(s.SALES * c.price) as total_sales
from
(select a.author_id, a.author_name, b.category, b.price, b.book_id from AUTHOR a join book b on a.author_id = b.author_id) c
join 
BOOK_SALES s
on c.book_id = s.book_id
where year(SALES_DATE) = 2022 and month(SALES_DATE) = 1
group by c.category,a.author_id
order by c.author_id, c.category desc
