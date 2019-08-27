package com.jt.manager.mapper;

import com.jt.common.mapper.SysMapper;
import com.jt.manager.pojo.Item;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author sumail
 * @date 2019/8/25 0025-${time}
 */
public interface ItemMapper extends SysMapper<Item> {
//    int findCount();

    /**
     * 说明mybatis中不允许多值传参，可以将多值封装为单值
     * 封装的策略
     *  1.将数据封装为POJO对象
     *  2.将数据封装为Map集合 map<key,value>
     *      @Param("start") int start底层实现时封装为map集合
     *  3.将数据封装为Array数组/List集合
     * @param start
     * @param rows
     * @return
     */
    List<Item> findItemByPage(
            @Param("start") int start,
            @Param("rows") int rows);
    @Select("SELECT NAME FROM tb_item_cat WHERE id=#{ItemCatId}")
    String queryItemCat(Long ItemCatId);

    void updateStatus(@Param("ids")Long[] ids,@Param("status") int status);
}
