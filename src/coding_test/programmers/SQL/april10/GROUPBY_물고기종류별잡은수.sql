select
    count(*) as FISH_COUNT,
    n.FISH_NAME as FISH_NAME
from fish_info i
join fish_name_info n on i.fish_type = n.fish_type
group by i.fish_type, n.fish_name
order by FISH_COUNT desc;

-- select에 쓰는 컬럼은 반드시 group by에 포함되거나 집계함수여야함