package com.jt.manager.controller;

import com.jt.common.vo.EasyUIResult;
import com.jt.common.vo.ItemCatData;
import com.jt.manager.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author sumail
 * @date 2019/8/25 0025-${time}
 */
@Controller
@RequestMapping("/item")
public class ItemController {
    @Autowired
    private ItemService itemService;

    //实现商品分页查询
    @RequestMapping("/query")
    @ResponseBody
    public EasyUIResult findItemByPage(int page, int rows) {
        return itemService.findItemByPage(page, rows);
    }

    @RequestMapping(value = "/queryItemCatName",produces = "text/html;charset=utf-8")
    @ResponseBody
    public String queryItemCatName(Long itemCatId) {
        return itemService.queryItemCatName(itemCatId);
    }

}
