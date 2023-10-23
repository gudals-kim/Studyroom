-- 코드를 입력하세요
SELECT info.REST_ID, info.REST_NAME, info.FOOD_TYPE, info.FAVORITES, info.ADDRESS, round(sum(review.review_score)/count(review.review_score),2) as SCORE
from REST_INFO info join REST_REVIEW review on info.REST_ID = review.REST_ID
where substring_index(info.address," ",1) like "서울%"
group by info.rest_ID
order by SCORE desc, info.FAVORITES desc