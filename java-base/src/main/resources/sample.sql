select
    a.word '名称',
    a.num '次数',
    a.theme_id 'ID',
    (b.words / 1000) '字数',
    b.theme_name '标题',
    (select x.num from sis_theme_text_segmenter x where x.word = '' and x.theme_id = a.theme_id) a
from sis_theme_text_segmenter a
         left join sis_theme b on a.theme_id = b.id
where (a.word = '') and a.num > 3 and b.words > 50000;
