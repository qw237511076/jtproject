package com.jt.manager.service;

import com.jt.common.vo.EasyUIResult;
import com.jt.common.vo.ItemCatData;
import com.jt.manager.pojo.Item;

import java.util.List;

/**
 * @author sumail
 * @date 2019/8/25 0025-${time}
 */
public interface ItemService {

    EasyUIResult findItemByPage(int page, int rows);

    String queryItemCatName(Long ItemCatId);
}
