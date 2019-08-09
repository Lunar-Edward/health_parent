package com.itheima.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.itheima.constant.MessageConstant;
import com.itheima.entity.PageResult;
import com.itheima.entity.QueryPageBean;
import com.itheima.entity.Result;
import com.itheima.pojo.CheckItem;
import com.itheima.service.CheckItemService;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/checkitem")
public class CheckItemController {
    private Logger log=Logger.getLogger(CheckItemController.class);
    @Reference
    private CheckItemService checkItemService;
    @RequestMapping("/add")
    public Result add(@RequestBody CheckItem checkItem){
        try {
            checkItemService.add(checkItem);
        } catch (Exception e) {
            return new Result(false, MessageConstant.ADD_CHECKITEM_FAIL);
        }
        return new Result(true,MessageConstant.ADD_CHECKITEM_SUCCESS);
    }
    @RequestMapping("/findPage")
    @ResponseBody
    public PageResult findPage(@RequestBody QueryPageBean queryPageBean){
        PageResult pageResult=checkItemService.findPage(queryPageBean);
        return pageResult;
    }
    @RequestMapping("/queryCheckItemById")
    public Result queryCheckItemById(Integer id){
        try {
            CheckItem checkItem = checkItemService.queryCheckItemById(id);
            return new Result(true,MessageConstant.QUERY_CHECKITEM_SUCCESS,checkItem);
        } catch (Exception e) {
            log.error("Query CheckItem Error",e);
        }
        return new Result(false,MessageConstant.QUERY_CHECKITEM_FAIL);
    }
    @RequestMapping("/edit")
    public Result edit(@RequestBody CheckItem checkItem){
        try {
            checkItemService.edit(checkItem);
            return new Result(true,MessageConstant.EDIT_CHECKITEM_SUCCESS);
        } catch (Exception e) {
            log.error("Edit Error,",e);
        }
        return new Result(false,MessageConstant.EDIT_CHECKITEM_FAIL);
    }
    @RequestMapping("/delete")
    public Result deleteById(Integer id){
        try {
            checkItemService.deleteById(id);
            return new Result(true,MessageConstant.DELETE_CHECKITEM_SUCCESS);
        } catch (Exception e) {
            log.error("Delete CheckItem By Id Error,",e);
        }
        return new Result(false,MessageConstant.DELETE_CHECKITEM_FAIL);
    }
}
