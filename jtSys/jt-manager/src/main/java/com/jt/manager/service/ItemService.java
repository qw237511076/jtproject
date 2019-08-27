package com.jt.manager.service;

import com.jt.common.vo.EasyUIResult;
import com.jt.manager.pojo.Item;
import com.jt.manager.pojo.ItemDesc;

/**
 * @author sumail
 * @date 2019/8/25 0025-${time}
 */
public interface ItemService {

    EasyUIResult findItemByPage(int page, int rows);

    String queryItemCatName(Long ItemCatId);

    void saveItem(Item item,String desc);

    void updateItem(Item item,String desc);

    void deleteItems(Long... ids);

    void updateStatus(Long[] ids, int status);


    ItemDesc findItemDescByPage(Long itemId);

}
