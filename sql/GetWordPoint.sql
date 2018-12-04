use  questionsdatabase;
drop function if exists GetWordPoint;
create function GetWordPoint(original varchar(1), symbol varchar(1))
returns decimal(4, 2) DETERMINISTIC
return if(original = 'Y' and symbol = 'Y', 1, 
    if(original = 'Y' and symbol = 'N', 0, 
    if(original = 'Y' and symbol = 'U', 0, 
    if(original = 'Y' and symbol = 'S', 0.5, 
    if(original = 'N' and symbol = 'Y', 0, 
    if(original = 'N' and symbol = 'N', 1, 
    if(original = 'N' and symbol = 'U', 0, 
    if(original = 'N' and symbol = 'S', 0.5, 
    if(original = 'U' and symbol = 'Y', 0, 
    if(original = 'U' and symbol = 'N', 0, 
    if(original = 'U' and symbol = 'U', 1, 
    if(original = 'U' and symbol = 'S', 0, 
    if(original = 'S' and symbol = 'Y', 0.5, 
    if(original = 'S' and symbol = 'N', 0.5, 
    if(original = 'S' and symbol = 'U', 0, 
    if(original = 'S' and symbol = 'S', 1, 
    0
))))))))))))))));