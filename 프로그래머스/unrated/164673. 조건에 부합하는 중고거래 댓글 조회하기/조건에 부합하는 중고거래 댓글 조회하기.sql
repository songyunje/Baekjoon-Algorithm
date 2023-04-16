SELECT TITLE, b.BOARD_ID, REPLY_ID, r.WRITER_ID, r.CONTENTS, date_format(R.created_date,'%Y-%m-%d') as CREATED_DATE
from used_goods_board b, used_goods_reply r
where b.board_id=r.board_id
and date_format(b.created_date,'%Y-%m')='2022-10'
ORDER BY CREATED_DATE, TITLE