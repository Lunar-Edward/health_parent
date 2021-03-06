package com.itheima.service;

import com.itheima.entity.PageResult;
import com.itheima.entity.QueryPageBean;
import com.itheima.pojo.CheckItem;

public interface CheckItemService {
    void add(CheckItem checkItem);

    PageResult findPage(QueryPageBean queryPageBean);

    CheckItem queryCheckItemById(int id);

    void edit(CheckItem checkItem);

    void deleteById(Integer id);
}
