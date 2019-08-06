package com.itheima.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.itheima.dao.CheckItemDao;
import com.itheima.pojo.CheckItem;
import org.springframework.beans.factory.annotation.Autowired;
@Service
public class CheckItemServiceImpl implements CheckItemService {
    @Autowired
    private CheckItemDao checkItemDao;

    @Override
    public void add(CheckItem checkItem) {

        checkItemDao.add(checkItem);
    }
}
