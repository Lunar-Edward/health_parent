package com.itheima.dao;

import com.github.pagehelper.Page;
import com.itheima.pojo.CheckItem;
import org.apache.ibatis.annotations.Param;

public interface CheckItemDao {
    void add(CheckItem checkItem);

    Page<CheckItem> queryByCondition(@Param("queryString") String queryString);

    CheckItem queryCheckItemById(@Param("id") int id);

    void edit(CheckItem checkItem);

    void deleteById(@Param("id") Integer id);
}
