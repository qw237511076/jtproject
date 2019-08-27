package com.jt.manager.controller;

import com.jt.manager.service.ItemCatService;
import com.jt.manager.vo.EasyUITree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author sumail
 * @date 2019/8/26 0026-${time}
 */
@Controller
@RequestMapping("/item/cat")
public class ItemCatController {

    @Autowired
    private ItemCatService itemCatService;

    @RequestMapping("/list")
    @ResponseBody
    public List<EasyUITree> findItemCatList(@RequestParam(value = "id",defaultValue = "0") Long parentId){
        //1.查询一级商品分类的信息
//        Long parentId=0L;
        return itemCatService.findItemCatList(parentId);
    }
}
