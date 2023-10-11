-- 코드를 입력하세요
#
# select *
SELECT concat("/home/grep/src/", file.board_id,"/", file.file_id,file.file_name, file.file_ext) as FILE_PATH
# from (select max(views), board_id from USED_GOODS_BOARD) board 
from (select board_id from USED_GOODS_BOARD order by views desc limit 1) board
join USED_GOODS_FILE file
on board.board_id = file.board_id 
order by file.file_id desc
