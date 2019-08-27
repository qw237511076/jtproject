package com.jt.manager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * 文件上传下载
 *
 * @author sumail
 * @date 2019/8/27 0027-${time}
 */
@Controller
@RequestMapping("/file")
public class FileController {


    /*实现文件上传
     * 说明:MultipartFile 是SpringMVC中提供的文件上传的API
     *
     * 1.判断文件的类型是否为图片
     * 2.准备文件上传的文件路径
     */
    @RequestMapping(value="/image",produces="text/html;charset=utf-8",method = RequestMethod.POST)
    @ResponseBody
    public String picUpload(MultipartFile image) throws IllegalStateException, IOException {

        //1.文件上传的名称    abc.jpg
        String fileName = image.getOriginalFilename();

        //2.判断是否问文件类型(jpg|png|gif)
        if(fileName.matches("^.*(jpg|png|gif)$")){

            //3.定义上传的路径
            String path = "E:/jt-upload";

            //4.判断是否有文件夹
            File file = new File(path);

            if(!file.exists()){
                //创建文件夹  创建多级目录
                file.mkdirs();
            }

            //E:/jt-upload/abc.jpg
            String fileNamePath = path + "/" + fileName;
            //5.实现文件上传
            image.transferTo(new File(fileNamePath));

            System.out.println("好久不学了,忘的光光的!");
        }

        return "好久不学了,忘的光光的!";
    }
}
