package com.example.display.util;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

public interface ParentMapper<T> extends Mapper<T>,MySqlMapper {
}
