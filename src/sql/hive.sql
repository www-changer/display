-- 用户登录信息表:
create external table if not exists src_LoginRole_day(
    device_model string,
    device_height int,
    device_width int ,
    os_name string,
    os_ver string,
    app_channel string,
    app_ver string,
    server string,
    role_id string,
    create_time float,
    role_level int,
   login_time bigint,
   last_logout_time bigint,
    offline_money int,
    offline_exp int
) row format delimited fields terminated by '\t';


-- 用户登出信息表：
create external table if not exists src_LogoutRole_day(
    device_model string,
    device_height int,
    device_width int ,
    os_name string,
    os_ver string,
    app_channel string,
    app_ver string,
    server string,
    role_id string,
    create_time float,
    role_level int,
    exp int
) row format delimited fields terminated by '\t';


-- 将本地数据导入hive:
load data local inpath '/home/xwl/hive/data/src_LoginRole_day.log' overwrite into table src_loginrole_day;
load data local inpath '/home/xwl/hive/data/src_LogoutRole_day.log' overwrite into table src_logoutrole_day;

-- DAU：日活跃用户数量
create table if not exists daily_active_user(
    active_user int,
    day string
) row format delimited fields terminated by '\t';

insert into table daily_active_user
select count(distinct(role_id)) , from_unixtime(login_time,'yyyy-MM-dd')
from src_loginrole_day
group by from_unixtime(login_time,'yyyy-MM-dd');

-- DNU：日新增用户数量
create table if not exists daily_new_user(
    new_user int,
    day string
) row format delimited fields terminated by '\t';


insert into table daily_new_user
select count(distinct(role_id)) , from_unixtime(login_time,'yyyy-MM-dd')
from src_loginrole_day
where from_unixtime(cast(create_time as bigint), 'yyyy-MM-dd') = from_unixtime(login_time,'yyyy-MM-dd')
group by from_unixtime(login_time,'yyyy-MM-dd');

-- DRU：日留存用户数量
create table if not exists daily_retained_user(
    retained_user int,
    day string
) row format delimited fields terminated by '\t';

insert into table daily_retained_user
select count(distinct(role_id)) , from_unixtime(login_time,'yyyy-MM-dd')
from src_loginrole_day
where from_unixtime(cast(create_time as bigint)+86400, 'yyyy-MM-dd') = from_unixtime(login_time,'yyyy-MM-dd')
group by from_unixtime(login_time,'yyyy-MM-dd');

-- DRUR：新增用户次日留存率
create table if not exists daily_retained_user_rate(
    retained_rate float,
    day string
) row format delimited fields terminated by '\t';

insert into table daily_retained_user_rate
select t2.retained_user/t1.new_user, t1.day
from daily_new_user t1 left join daily_retained_user t2 on datediff(t2.day,t1.day) =1;



