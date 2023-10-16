-- 코드를 입력하세요
SELECT ins.ANIMAL_ID, ins.name
from ANIMAL_INS ins join ANIMAL_OUTS outs
on ins.ANIMAL_ID = outs.ANIMAL_ID and ins.DATETIME > outs.DATETIME
order by ins.DATETIME