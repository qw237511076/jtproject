package com.jt.manager.pojo;

import com.jt.common.po.BasePojo;

import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author sumail
 * @date 2019/8/27 0027-${time}
 */
@Table(name = "tb_item_desc")
public class ItemDesc extends BasePojo {
    @Id
    private Long itemId;
    private String itemDesc;

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public String getItemDesc() {
        return itemDesc;
    }

    @Override
    public String toString() {
        return "ItemDesc{" +
                "itemId=" + itemId +
                ", itemDesc='" + itemDesc + '\'' +
                '}';
    }

    public void setItemDesc(String itemDesc) {

        this.itemDesc = itemDesc;
    }
}
