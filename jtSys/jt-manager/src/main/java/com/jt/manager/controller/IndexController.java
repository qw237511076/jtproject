package com.jt.manager.controller;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author sumail
 * @date 2019/8/24 0024-${time}
 */
@Controller
public class IndexController {

    @RequestMapping("/index")
    public String index(){
        return "index";
    }

    /**
     * 通过restFul实现页面的通用跳转
     * url:
     *      /page/item-add
     *      /page/item-list
     *
     * 思考：
     *      如果能够获取动态变化的数据，则可以试想页面的动态跳转
     * 实现：实现数据的动态获取
     * restFul格式要求：
     *      1.参数拼接url中，并且以"/"进行分割
     *      2.参数的位置必须固定
     *      3.后台服务器接收的参数使用{}包裹变量,之后使用
     *      @PathVariable 实现数据的动态获取
     *
     * @param module
     * @return
     */
    @RequestMapping("/page/{module}")
    public String module(@PathVariable String module){
        return module;
    }
}
