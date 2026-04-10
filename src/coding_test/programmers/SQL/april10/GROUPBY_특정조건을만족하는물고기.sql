select
    count(*) as FISH_COUNT,
    max(length) as MAX_LENGTH,
    FISH_TYPE
from fish_info
group by fish_type
having avg(coalesce(length, 10)) >= 33
order by fish_type asc;

-- coalesce()는 인자 중 첫번째로 null이 아닌 값을 반환하는 함수