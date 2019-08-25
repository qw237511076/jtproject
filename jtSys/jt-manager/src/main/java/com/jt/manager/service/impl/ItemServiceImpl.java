package com.jt.manager.service.impl;

import com.jt.common.vo.EasyUIResult;
import com.jt.common.vo.ItemCatData;
import com.jt.manager.mapper.ItemMapper;
import com.jt.manager.pojo.Item;
import com.jt.manager.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author sumail
 * @date 2019/8/25 0025-${time}
 */
@Service
public class ItemServiceImpl implements ItemService {
    @Autowired
    private ItemMapper itemMapper;


    @Override
    public EasyUIResult findItemByPage(int page, int rows) {
        //查询商品记录的总数
        int total = itemMapper.findCount();
        /**
         * 第一页 select * from tb_item limit 0,20
         * 第二页 select * from tb_item limit 20,20
         * 第三页 select * from tb_item limit 30,20
         * 第三页 select * from tb_item limit (page-1)*rows,rows
         */
        //定义起始页数
        int start = (page - 1) * rows;
        List<Item> itemList = itemMapper.findItemByPage(start,rows);

        return new EasyUIResult(total, itemList);
    }

    @Override
    public String queryItemCatName(Long ItemCatId) {
        return itemMapper.queryItemCat(ItemCatId);
    }
}
