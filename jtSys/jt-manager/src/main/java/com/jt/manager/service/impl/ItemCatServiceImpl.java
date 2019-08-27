package com.jt.manager.service.impl;

import com.jt.manager.mapper.ItemCatMapper;
import com.jt.manager.pojo.ItemCat;
import com.jt.manager.service.ItemCatService;
import com.jt.manager.vo.EasyUITree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sumail
 * @date 2019/8/26 0026-${time}
 */
@Service
public class ItemCatServiceImpl implements ItemCatService {
    @Autowired
    private ItemCatMapper itemCatMapper;

    /**
     * 实现思路：
     * 1.利用通用Mapper查询商品分类信息
     * 2.将ItemCatList转化为EasyUITreeList
     *
     * @param parentId
     * @return
     */
    @Override
    public List<EasyUITree> findItemCatList(Long parentId) {
        ItemCat itemCat = new ItemCat();
        itemCat.setParentId(parentId);
        List<ItemCat> itemCatList = itemCatMapper.select(itemCat);

        List<EasyUITree> treeList = new ArrayList<>();
        for (ItemCat itemCatTemp : itemCatList) {
            EasyUITree easyUITree = new EasyUITree();
            easyUITree.setId(itemCatTemp.getId());
            easyUITree.setText(itemCatTemp.getName());

            //如果是父级 应该设置为closed，否则open即可
            String state = itemCatTemp.getIsParent() ? "closed" : "open";
            easyUITree.setState(state);
            treeList.add(easyUITree);
        }
        return treeList;
    }
}
