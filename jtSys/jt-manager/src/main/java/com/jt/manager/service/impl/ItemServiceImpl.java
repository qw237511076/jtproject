package com.jt.manager.service.impl;

import com.jt.common.vo.EasyUIResult;
import com.jt.manager.mapper.ItemDescMapper;
import com.jt.manager.mapper.ItemMapper;
import com.jt.manager.pojo.Item;
import com.jt.manager.pojo.ItemDesc;
import com.jt.manager.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author sumail
 * @date 2019/8/25 0025-${time}
 */
@Service
public class ItemServiceImpl implements ItemService {
    @Autowired
    private ItemMapper itemMapper;
    @Autowired
    private ItemDescMapper itemDescMapper;

    @Override
    public EasyUIResult findItemByPage(int page, int rows) {
        //查询商品记录的总数
//        int total = itemMapper.findCount();
        int total = itemMapper.selectCount(null);
        /**
         * 第一页 select * from tb_item limit 0,20
         * 第二页 select * from tb_item limit 20,20
         * 第三页 select * from tb_item limit 30,20
         * 第三页 select * from tb_item limit (page-1)*rows,rows
         */
        //定义起始页数
        int start = (page - 1) * rows;
        List<Item> itemList = itemMapper.findItemByPage(start, rows);

        return new EasyUIResult(total, itemList);
    }

    @Override
    public String queryItemCatName(Long ItemCatId) {
        return itemMapper.queryItemCat(ItemCatId);
    }

    //当用户添加商品时，需要同事入库2张表数据
    @Override
    public void saveItem(Item item,String desc) {
        //封装数据
        item.setStatus(1);                      //表示正常
        item.setCreated(new Date());
        item.setUpdated(item.getCreated());
        itemMapper.insert(item);


        //入库itemDsc表
        ItemDesc itemDesc = new ItemDesc();
        itemDesc.setItemDesc(desc);
        itemDesc.setItemId(item.getId());
        itemDesc.setUpdated(item.getUpdated());
        itemDesc.setCreated(item.getCreated());
        itemDescMapper.insert(itemDesc);
    }

    @Override
    public void updateItem(Item item,String desc) {
        item.setUpdated(new Date());
        //动态更新操作 将对象中不为null的数据充当set条件 注解
        itemMapper.updateByPrimaryKeySelective(item);
        System.out.println(desc);
        ItemDesc itemDesc = new ItemDesc();
        itemDesc.setItemDesc(desc);
        System.out.println(item.getId());
        itemDesc.setItemId(item.getId());
        System.out.println("+++++++++++++++++++++++++++++");
        System.out.println(itemDesc.getItemId());
        itemDesc.setUpdated(item.getUpdated());
        System.out.println(itemDesc);
        itemDescMapper.updateByPrimaryKeySelective(itemDesc);
    }

    @Override
    public void deleteItems(Long... ids) {
        itemMapper.deleteByIDS(ids);
        itemDescMapper.deleteByIDS(ids);
    }

    //实现商品上下架处理
    @Override
    public void updateStatus(Long[] ids, int status) {
        itemMapper.updateStatus(ids, status);
//        System.out.println(ids+"==========================================================="+status);
    }

    @Override
    public ItemDesc findItemDescByPage(Long itemId) {
        return itemDescMapper.selectByPrimaryKey(itemId);
    }


}
