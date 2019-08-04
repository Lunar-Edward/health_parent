package com.itheima.dao;

import com.itheima.pojo.CheckItem;
import org.apache.ibatis.annotations.Param;

public interface CheckItemDao {
    void add(@Param("checkItem") CheckItem checkItem);
}
