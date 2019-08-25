package com.jt.manager.pojo;

import com.google.common.annotations.VisibleForTesting;
import com.jt.common.po.BasePojo;

/**
 * @author sumail
 * @date 2019/8/25 0025-${time}
 */
public class Item extends BasePojo {
    private Long id;            //商品ID
    private String title;       //商品标题
    private String sellPoint;   //买点信息
    private Long price;         //商品价格 1.int>long>dubbo
    private Integer num;        //商品数量
    private String barcode;     //二维码
    private String image;       //商品图片
    private Long cid;           //商品分类信息
    private Integer status;     //商品状态信息    1.正常2.下架3.删除

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSellPoint() {
        return sellPoint;
    }

    public void setSellPoint(String sellPoint) {
        this.sellPoint = sellPoint;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Long getCid() {
        return cid;
    }

    public void setCid(Long cid) {
        this.cid = cid;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
