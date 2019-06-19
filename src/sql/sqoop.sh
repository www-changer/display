# 导出daily_active_user表
sqoop export --connect jdbc:mysql://192.168.146.128:3306/xwl  --username root --password pass --table daily_active_user --export-dir /user/hive/warehouse/daily_active_user --columns active_user,day --input-fields-terminated-by '\t'

# 导出daily_retained_user_rate表
sqoop export --connect jdbc:mysql://192.168.146.128:3306/xwl  --username root --password pass --table daily_retained_user_rate --export-dir /user/hive/warehouse/daily_retained_user_rate --columns retained_rate,day --input-fields-terminated-by '\t' --input-null-string '\\N' --input-null-non-string '\\N';