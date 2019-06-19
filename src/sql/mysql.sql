-- DAU：日活跃用户数量
create table if not exists daily_active_user(
    active_user int,
    day varchar(100)
);

-- DRUR：新增用户次日留存率
create table if not exists daily_retained_user_rate(
    retained_rate float,
    day varchar(100)
);


