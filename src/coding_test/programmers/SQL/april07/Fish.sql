select F.id, N.fish_name, F.length
from fish_info F
join fish_name_info N on F.fish_type = N.fish_type
where (F.fish_type, F.length) in (
        select fish_type, MAX(length)
        from fish_info
        group by fish_type
)
order by F.id ASC;