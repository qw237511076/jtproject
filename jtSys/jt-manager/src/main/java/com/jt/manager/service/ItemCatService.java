package com.jt.manager.service;

import com.jt.manager.vo.EasyUITree;

import java.util.List;

/**
 * @author sumail
 * @date 2019/8/26 0026-${time}
 */
public interface ItemCatService {
    List<EasyUITree> findItemCatList(Long parentId);
}
